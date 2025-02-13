package com.mycompany.personalmanagment.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class mainForm extends javax.swing.JFrame {

    public static int UserId;
    public static int StatusUvolen;
    public static int DepartId;
    public static String NameOrg;
    public static List ListRole = new ArrayList();
    public static List ListDepartment = new ArrayList();
    private OkHttpClient ok = new OkHttpClient();

    public mainForm() {
        initComponents();
        CreateListRole();
        CreateListDepartment();
        ImageIcon icon = new ImageIcon("src\\main\\resources\\image\\Untitled.png");
        setIconImage(icon.getImage());
    }

    private void CreateListRole() {
        String url = "http://localhost:8080/api/v1/AllPositions";

        Request req = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response r = ok.newCall(req).execute()) {
            JSONArray ja = new JSONArray(r.body().string());
            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = ja.getJSONObject(i);
                ListRole.add(jo.getString("positionName"));
            }
        } catch (IOException ex) {
            Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CreateListDepartment() {

        podrPanel.setLayout(new BoxLayout(podrPanel, BoxLayout.Y_AXIS));
        podrPanel.setBackground(Color.GREEN);

        Request req = new Request.Builder()
                .url("http://localhost:8080/api/v1/GetDepartment")
                .get()
                .build();

        try (Response r = ok.newCall(req).execute()) {

            JSONArray ja = new JSONArray(r.body().string());
            HashMap<Integer, JPanel> levelPanels = new HashMap<>();

            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = ja.getJSONObject(i);
                ListDepartment.add(jo.getString("departmentName"));

                String kod = jo.getString("description");
                int kodLength = kod.length();

                JPanel levelPanel = levelPanels.get(kodLength);
                if (levelPanel == null) {
                    levelPanel = new JPanel();
                    levelPanel.setBackground(Color.GREEN);
                    levelPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
                    levelPanels.put(kodLength, levelPanel);
                }

                JPanel podr = new JPanel();
                JLabel podrNazv = new JLabel();
                podrNazv.setText(jo.getString("departmentName"));
                podr.add(podrNazv);

                int selectOrg = jo.getInt("departmentID");
                String orgName = jo.getString("departmentName");

                podr.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        DepartId = selectOrg;
                        NameOrg = orgName;
                        CreatePanel(selectOrg);
                    }
                });

                levelPanel.add(podr);
            }

            List<Integer> sortedKeys = new ArrayList<>(levelPanels.keySet());
            Collections.sort(sortedKeys);

            for (Integer key : sortedKeys) {
                podrPanel.add(levelPanels.get(key));
            }

        } catch (IOException ex) {
            Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CreatePanel(int department) {

        Request req = new Request.Builder()
                .url("http://localhost:8080/api/v1/employee/AllEmplDep" + "?department=" + department)
                .get()
                .build();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));        // Устанавливаем BoxLayout с вертикальной ориентацией
        mainPanel.setBorder(new EmptyBorder(8, 8, 8, 8));

        mainPanel.removeAll();        // Очищаем панель перед добавлением новых карточек
        mainPanel.revalidate();  // Перерисовываем панель, чтобы изменения вступили в силу

        try (Response r = ok.newCall(req).execute()) {
            JSONArray ja = new JSONArray(r.body().string());
            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = ja.getJSONObject(i);

                Request req1 = new Request.Builder()
                        .url("http://localhost:8080/api/v1/employee/StatusWork" + "?idUser=" + jo.getInt("employeeID"))
                        .get()
                        .build();

                try (Response r1 = ok.newCall(req1).execute()) {

                    Color EmolCardColor;

                    if (r1.code() != 404) {
                        EmolCardColor = Color.GRAY;
                        StatusUvolen = 1;
                    } else {
                        EmolCardColor = Color.white;
                        StatusUvolen = 0;
                    }

                    mainPanel.add(Box.createVerticalStrut(10));
                    JPanel nestedPanel = new JPanel();
                    nestedPanel.setLayout(new BoxLayout(nestedPanel, BoxLayout.Y_AXIS)); // Используем BoxLayout для вертикального расположения

                    JPanel labelPodr = new JPanel();
                    labelPodr.setBackground(EmolCardColor);
                    labelPodr.add(new JLabel((String) ListDepartment.get(jo.getInt("departmentId") - 1) + " - " + (String) ListRole.get(jo.getInt("positionId") - 1)));
                    nestedPanel.add(labelPodr);

                    JPanel email = new JPanel();
                    email.setBackground(EmolCardColor);
                    email.add(new JLabel(jo.getString("corporateEmail") + " " + jo.getString("workPhone")));
                    nestedPanel.add(email);

                    JPanel cabinet = new JPanel();
                    cabinet.setBackground(EmolCardColor);
                    cabinet.add(new JLabel(jo.getString("office")));
                    nestedPanel.add(cabinet);

                    JPanel labelPanel = new JPanel();
                    labelPanel.setBackground(EmolCardColor);
                    labelPanel.add(new JLabel(jo.getString("patronymic") + " " + jo.getString("name") + " " + jo.getString("surname")));
                    nestedPanel.add(labelPanel);

                    nestedPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
                    mainPanel.add(nestedPanel);

                    int panelIndex = jo.getInt("employeeID"); // Захватываем значение i для использования в ActionListener

                    nestedPanel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            openInformationForm(panelIndex);// Действие при клике на панель
                        }
                    });
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void openInformationForm(int panelIndex) {
        UserId = panelIndex;
        new employeeForm().setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        podrPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("организационная структура");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 153, 0));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton8.setText("+");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.setBackground(new java.awt.Color(51, 153, 0));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainPanel);

        javax.swing.GroupLayout podrPanelLayout = new javax.swing.GroupLayout(podrPanel);
        podrPanel.setLayout(podrPanelLayout);
        podrPanelLayout.setHorizontalGroup(
            podrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );
        podrPanelLayout.setVerticalGroup(
            podrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(podrPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        UserId = 0;
        StatusUvolen = 0;
        new employeeForm().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel podrPanel;
    // End of variables declaration//GEN-END:variables
}
