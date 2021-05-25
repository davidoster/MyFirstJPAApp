/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mac
 */
@Entity // 1st entity
@Table(name = "customers")
public class Customer implements Serializable { // 2nd implements

    @Id // 3rd id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fname")
    private String fullName;

    @Column(name = "lname")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Customer() {
    }

    public Customer(int id, String fullName, String lastName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer{id=").append(id);
        sb.append(", fullName=").append(fullName);
        sb.append(", lastName=").append(lastName);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }

}
