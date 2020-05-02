package com.pram.realmtest;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class StudentModel extends RealmObject {
    /**
     * @Required กำหนดให้ Field นั้น ห้ามมีค่า null
     * @PrimaryKey กำหนดให้ Field นั้นเป็น primary key
     * @Ignore เป็นการกำหนดว่า Field นั้นไม่ต้องการเก็บลงใน Database
     * @Index เป็นการเพิ่ม Search index ให้กับ Field นั้นๆ ใช้สำหรับการ Query
     */

    @PrimaryKey
    private int studentId;

    private String firstName;

    private String lastName;

    private int age;

    private String gender;

    private String city;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
