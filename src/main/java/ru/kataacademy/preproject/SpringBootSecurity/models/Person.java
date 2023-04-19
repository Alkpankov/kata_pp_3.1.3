package ru.kataacademy.preproject.SpringBootSecurity.models;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private int age;

    @Column(name="password")
    private String password;

    @Column(name="role_id")
    private int role_id;

    public Person() {
    }

    public Person(String name, String email, String address, int age, String password, int role_id) {
        this.username = name;
        this.email = email;
        this.address = address;
        this.age = age;
        this.password = password;
        this.role_id = role_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", role_id=" + role_id +
                '}';
    }
}
