package com.pram.realmtest;

import io.realm.Realm;
import io.realm.RealmResults;

public class StudentManager {
    private final Realm realm;
    private static StudentManager instance;

    public StudentManager() {
        realm = Realm.getDefaultInstance();
    }

    public static StudentManager getInstance() {
        if (instance == null)
            instance = new StudentManager();

        return instance;
    }

    public Realm getRealm() {
        return realm;
    }

    /*Controller*/

    public void clearAll() {
        realm.beginTransaction();
        realm.delete(StudentModel.class);
        realm.commitTransaction();
    }

    public void deleteStudent(int id) {
        realm.beginTransaction();
        realm.where(StudentModel.class)
                .equalTo("studentId", id)
                .findFirst()
                .deleteFromRealm();
        realm.commitTransaction();
    }

    public RealmResults<StudentModel> getStudents() {
        return realm.where(StudentModel.class).findAll();
    }

    public RealmResults<StudentModel> getStudent(int studentId) {
        return realm.where(StudentModel.class).equalTo("studentId", studentId).findAll();
    }

    public RealmResults<StudentModel> queryedStudent(String firstName) {
        return realm.where(StudentModel.class)
                .contains("firstName", firstName)
                .findAll();
    }

    public void addStudent(StudentModel student) {
        realm.beginTransaction();
        realm.insert(student);
        realm.commitTransaction();
    }

    public void updateStudent(int id, String name) {
        StudentModel student = realm.where(StudentModel.class)
                .equalTo("studentId", id)
                .findFirst();

        realm.beginTransaction();
        student.setFirstName(name);
        realm.insertOrUpdate(student);
        realm.commitTransaction();
    }

    public int nextId() {
        Number student = realm.where(StudentModel.class).max("studentId");
        if (student == null)
            return 10001;
        else
            return student.intValue() + 1;
    }

    /*END Controller*/
}
