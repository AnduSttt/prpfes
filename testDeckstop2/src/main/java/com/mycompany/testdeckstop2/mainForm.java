/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.testdeckstop2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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

/**
 *
 * @author 1208-VM1
 */
public class mainForm extends javax.swing.JFrame {

    public static List departList = new ArrayList();
    public static List dolshstList = new ArrayList();
    public static int departId;
    public static int sotrudnikId;
    public static String nameDepart;
    public static OkHttpClient ok = new OkHttpClient();

    public mainForm() {
        initComponents();
        ImageIcon img = new ImageIcon();
        setIconImage(img.getImage());
        CreateDepart();
        CreateSotrudnikPanel();
        CreateListDolsnost();
    }

    public void CreateDepart() {

        Request req = new Request.Builder()
                .url("http://localhost:8080/api/v1/departments")
                .get()
                .build();

        try (Response res = ok.newCall(req).execute()) {

            HashMap<Integer, JPanel> panels = new HashMap<>();
            JSONArray arr = new JSONArray(res.body().string());

            podrPanel.setLayout(new BoxLayout(podrPanel, BoxLayout.Y_AXIS));
            podrPanel.setBackground(Color.GREEN);

            for (int i = 0; i < arr.length(); i++) {
                JSONObject jo = arr.getJSONObject(i);

                int kodLen = jo.getString("kodPodrazdelenia").length();

                JPanel levelPanel = panels.get(kodLen);
                if (levelPanel == null) {
                    JPanel vrem = new JPanel();
                    vrem.setBackground(Color.GREEN);
                    levelPanel = vrem;
                    panels.put(kodLen, levelPanel);
                }

                JPanel podr = new JPanel();
                podr.setBackground(Color.WHITE);
                JLabel name = new JLabel();
                name.setText(jo.getString("nazvaniye"));
                departList.add(jo.getString("nazvaniye"));
                podr.add(name);

                podr.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        departId = jo.getInt("idPodrazdelenie");
                        nameDepart = jo.getString("nazvaniye");
                        CreateSotrudnikPanel();
                    }

                });

                levelPanel.add(podr);

            }

            List<Integer> sort = new ArrayList<>(panels.keySet());
            Collections.sort(sort);

            for (Integer integer : sort) {
                podrPanel.add(panels.get(integer));
            }

        } catch (Exception e) {
        }

    }

    public void CreateSotrudnikPanel() {

        Request req = new Request.Builder()
                .url("http://localhost:8080/api/v1/departments/sotrudniki" + "?idDepart=" + departId)
                .get()
                .build();

        try (Response res = ok.newCall(req).execute()) {

            JSONArray arr = new JSONArray(res.body().string());

            sodrPanel.setLayout(new BoxLayout(sodrPanel, BoxLayout.Y_AXIS));
            sodrPanel.setBorder(new EmptyBorder(8, 8, 8, 8));
            sodrPanel.setBackground(Color.GREEN);

            sodrPanel.removeAll();
            sodrPanel.revalidate();

            for (int i = 0; i < arr.length(); i++) {
                JSONObject jo = arr.getJSONObject(i);

                JPanel sotr = new JPanel();
                sotr.setLayout(new BoxLayout(sotr, BoxLayout.Y_AXIS));
                sotr.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));

                JPanel podrDolshnostP = new JPanel();
                JLabel podrDolshnost = new JLabel();
                podrDolshnost.setText(dolshstList.get(jo.getInt("idDolshnost") - 1) + " - " + nameDepart);
                podrDolshnostP.add(podrDolshnost);

                JPanel fioP = new JPanel();
                JLabel fio = new JLabel();
                fio.setText(jo.getString("familiya") + " " + jo.getString("imya") + " " + jo.getString("otchestvo"));
                fioP.add(fio);

                JPanel emailNumPhP = new JPanel();
                JLabel emailNumPh = new JLabel();
                emailNumPh.setText(jo.getString("persolalNomer") + " " + jo.getString("corporatEmail"));
                emailNumPhP.add(emailNumPh);

                JPanel cabinetP = new JPanel();
                JLabel cabinet = new JLabel();
                cabinet.setText(jo.getString("cabinet"));
                cabinetP.add(cabinet);

                sotr.add(podrDolshnostP);
                sotr.add(fioP);
                sotr.add(emailNumPhP);
                sotr.add(cabinetP);

                sotr.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        sotrudnikId = jo.getInt("idSotridnik");
                        new sotrudnikForm().setVisible(true);
                    }

                });

                sodrPanel.add(sotr);

            }

        } catch (Exception e) {
        }

    }

    public void CreateListDolsnost() {

        Request req = new Request.Builder()
                .url("http://localhost:8080/api/v1/dolhnost")
                .get()
                .build();

        try (Response res = ok.newCall(req).execute()) {

            JSONArray arr = new JSONArray(res.body().string());

            for (int i = 0; i < arr.length(); i++) {
                JSONObject jo = arr.getJSONObject(i);

                dolshstList.add(jo.getString("nazvaniye"));

            }

        } catch (Exception e) {

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        podrPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sodrPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));

        jPanel1.setBackground(new java.awt.Color(102, 204, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout podrPanelLayout = new javax.swing.GroupLayout(podrPanel);
        podrPanel.setLayout(podrPanelLayout);
        podrPanelLayout.setHorizontalGroup(
            podrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );
        podrPanelLayout.setVerticalGroup(
            podrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(podrPanel);

        javax.swing.GroupLayout sodrPanelLayout = new javax.swing.GroupLayout(sodrPanel);
        sodrPanel.setLayout(sodrPanelLayout);
        sodrPanelLayout.setHorizontalGroup(
            sodrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );
        sodrPanelLayout.setVerticalGroup(
            sodrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(sodrPanel);

        jPanel2.setBackground(new java.awt.Color(102, 204, 0));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("+");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel podrPanel;
    private javax.swing.JPanel sodrPanel;
    // End of variables declaration//GEN-END:variables
}
