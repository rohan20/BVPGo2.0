package com.example.rohan.bvpgo20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rohan.bvpgo20.Models.Student;
import com.example.rohan.bvpgo20.Utils.Constants;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText newEmail;
    EditText newPassword;
    EditText reEnterPassword;
    EditText newMobileNumber;
    EditText newRollNumber;
    EditText newName;
    Button bNewRegister;

    Spinner spinnerSemester;
    String studentSemester;
    Spinner spinnerBranch;
    String studentBranch;

    ArrayList<String> semester;
    ArrayList<String> branch;

    boolean passwordMatch;

    Firebase ref;
    Firebase studentsRef;

    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setTitle("Register");

        ref = new Firebase(Constants.FIREBASE_URL);
        studentsRef = ref.child("Students");

        newEmail = (EditText) findViewById(R.id.NewEmail);
        newPassword = (EditText) findViewById(R.id.NewPassword);
        reEnterPassword = (EditText) findViewById(R.id.ReEnterNewPassword);
        newName = (EditText)findViewById(R.id.NewName);
        newMobileNumber = (EditText) findViewById(R.id.NewMobileNumber);
        newRollNumber = (EditText) findViewById(R.id.NewRollNumber);
        bNewRegister = (Button) findViewById(R.id.NewRegisterButton);

        spinnerSemester = (Spinner) findViewById(R.id.SemesterSpinner);
        spinnerBranch = (Spinner) findViewById(R.id.BranchSpinner);

        passwordMatch = false;

        studentSemester = "1";
        studentBranch = "CSE";

        if (newPassword.getText().toString().equals(reEnterPassword.getText().toString()))
            passwordMatch = true;

        semester = new ArrayList<>();
        branch = new ArrayList<>();

        semester.add("1");
        semester.add("2");
        semester.add("3");
        semester.add("4");
        semester.add("5");
        semester.add("6");
        semester.add("7");
        semester.add("8");

        branch.add("CSE");
        branch.add("IT");
        branch.add("ECE");
        branch.add("EEE");
        branch.add("ICE");

        final ArrayAdapter<String> semesterAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, semester);
        final ArrayAdapter<String> branchAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, branch);
        spinnerSemester.setAdapter(semesterAdapter);
        spinnerBranch.setAdapter(branchAdapter);

        spinnerSemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    studentSemester = spinnerSemester.getItemAtPosition(position).toString();
//                    Toast.makeText(RegisterActivity.this, studentSemester, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerBranch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    studentBranch = spinnerBranch.getItemAtPosition(position).toString();
//                    Toast.makeText(RegisterActivity.this, studentBranch, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bNewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newPassword.getText().toString().equals("") || reEnterPassword.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Cannot leave field empty", Toast.LENGTH_SHORT).show();
                } else if (!passwordMatch) {
                    Toast.makeText(RegisterActivity.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                } else if (newMobileNumber.getText().toString().equals("") || newRollNumber.getText().toString().equals("")
                        || newName.getText().toString().equals("") || newEmail.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Cannot leave field empty", Toast.LENGTH_SHORT).show();
                } else {

                    ref.createUser(newEmail.getText().toString(), newPassword.getText().toString(), new Firebase.ValueResultHandler<Map<String, Object>>() {
                        @Override
                        public void onSuccess(Map<String, Object> result) {

                            Student student = new Student();
                            student.setEmail(newEmail.getText().toString());
                            student.setName(newName.getText().toString());
                            student.setMobileNumber(newMobileNumber.getText().toString());
                            student.setRollNumber(newRollNumber.getText().toString());
                            student.setBranch(studentBranch);
                            student.setSemester(studentSemester);

                            uid = result.get("uid").toString();

                            studentsRef.child(uid).setValue(student);
                            Toast.makeText(RegisterActivity.this, "Successfully created user account with uid: " + result.get("uid"), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onError(FirebaseError firebaseError) {
                            // there was an error
                        }
                    });

                    Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(i);
                    RegisterActivity.this.finish();
                }

            }
        });


    }
}
