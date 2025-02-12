/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test1.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author 1208-VM1
 */
@Entity
@Table(name = "employees")
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
    @NamedQuery(name = "Employees.findByEmployeeID", query = "SELECT e FROM Employees e WHERE e.employeeID = :employeeID"),
    @NamedQuery(name = "Employees.findByName", query = "SELECT e FROM Employees e WHERE e.name = :name"),
    @NamedQuery(name = "Employees.findBySurname", query = "SELECT e FROM Employees e WHERE e.surname = :surname"),
    @NamedQuery(name = "Employees.findByPatronymic", query = "SELECT e FROM Employees e WHERE e.patronymic = :patronymic"),
    @NamedQuery(name = "Employees.findByWorkPhone", query = "SELECT e FROM Employees e WHERE e.workPhone = :workPhone"),
    @NamedQuery(name = "Employees.findByPersonalNumber", query = "SELECT e FROM Employees e WHERE e.personalNumber = :personalNumber"),
    @NamedQuery(name = "Employees.findByOffice", query = "SELECT e FROM Employees e WHERE e.office = :office"),
    @NamedQuery(name = "Employees.findByCorporateEmail", query = "SELECT e FROM Employees e WHERE e.corporateEmail = :corporateEmail"),
    @NamedQuery(name = "Employees.findByBirthday", query = "SELECT e FROM Employees e WHERE e.birthday = :birthday"),
    @NamedQuery(name = "Employees.findByPassword", query = "SELECT e FROM Employees e WHERE e.password = :password"),
    @NamedQuery(name = "Employees.findByLogin", query = "SELECT e FROM Employees e WHERE e.login = :login"),
    @NamedQuery(name = "Employees.findByDescription", query = "SELECT e FROM Employees e WHERE e.description = :description")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EmployeeID")
    private Integer employeeID;
    @Column(name = "Name")
    private String name;
    @Column(name = "Surname")
    private String surname;
    @Column(name = "Patronymic")
    private String patronymic;
    @Column(name = "WorkPhone")
    private String workPhone;
    @Column(name = "PersonalNumber")
    private String personalNumber;
    @Column(name = "Office")
    private String office;
    @Column(name = "CorporateEmail")
    private String corporateEmail;
    @Column(name = "Birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(name = "password")
    private String password;
    @Column(name = "login")
    private String login;
    @Column(name = "description")
    private String description;
    @JsonIgnore
    @JoinColumn(name = "Department", referencedColumnName = "DepartmentID")
    @ManyToOne(optional = false)
    private Departments department;
    @JsonIgnore
    @JoinColumn(name = "PositionID", referencedColumnName = "PositionID")
    @ManyToOne(optional = false)
    private Positions positionID;

    public Employees() {
    }

    @JsonGetter("departmentId")
    public int getDepartmentId() {
        return department.getDepartmentID();
    }

    @JsonGetter("positionId")
    public int getPositionId() {
        return positionID.getPositionID();
    }

    public Employees(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getCorporateEmail() {
        return corporateEmail;
    }

    public void setCorporateEmail(String corporateEmail) {
        this.corporateEmail = corporateEmail;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

    public Positions getPositionID() {
        return positionID;
    }

    public void setPositionID(Positions positionID) {
        this.positionID = positionID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeID != null ? employeeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.employeeID == null && other.employeeID != null) || (this.employeeID != null && !this.employeeID.equals(other.employeeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.test1.entity.Employees[ employeeID=" + employeeID + " ]";
    }

}
