package com.pram.realmtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);

//        addStudents();
        showStudentFromRealm();
    }

    private void addStudents() {
        List<StudentModel> students = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            StudentModel student = new StudentModel();

            student.setStudentId(10000 + i);
            student.setFirstName("Name " + i);
            student.setLastName("LastName " + i);
            student.setGender("Gender " + i);
            student.setCity("City " + i);
            student.setAge(i);

            students.add(student);
        }

        addToRealm(students);
    }

    private void addToRealm(List<StudentModel> students) {
        for (StudentModel student : students) {
            StudentManager.getInstance().addStudent(student);
        }
    }

    private void showStudentFromRealm() {
        List<StudentModel> students = StudentManager.getInstance().getStudents();

        StringBuilder textResult = new StringBuilder();

        for (StudentModel student : students) {

            String result = student.getStudentId() + "\n"
                    + student.getFirstName() + "\t" + student.getLastName() + "\n"
                    + student.getGender() + "\n"
                    + student.getAge() + "\n"
                    + student.getCity() + "\n";

            Log.d(TAG, result);

            textResult.append(result);
        }

        tvResult.setText(textResult);
    }
}
