package com.example.rohan.bvpgo20.NavigationDrawer;

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

import com.example.rohan.bvpgo20.Models.Meeting;
import com.example.rohan.bvpgo20.R;
import com.example.rohan.bvpgo20.Utils.Constants;
import com.firebase.client.Firebase;

import java.util.ArrayList;

public class FixMeetingActivity extends AppCompatActivity {

    Spinner teachersSpinner;
    EditText subjectEditText;
    Button bSend;

    String uid;

    ArrayList<String> teachers;

    Firebase ref;
    Firebase meetingRef;
    Firebase studentRef;

    String selectedTeacher;
    String messageSent;

    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_meeting);

        setTitle("Setup a meeting");

        Intent i = getIntent();
        uid = i.getStringExtra(Constants.SHARED_PREF_UID);

        ref = new Firebase(Constants.FIREBASE_URL);
        studentRef = ref.child("Students").child(uid);

        teachersSpinner = (Spinner) findViewById(R.id.teachersSpinner);
        subjectEditText = (EditText) findViewById(R.id.subjectEditText);
        bSend = (Button) findViewById(R.id.sendButton);

        teachers = new ArrayList<>();

        teachers.add("Ms. Poonam Verma");
        teachers.add("Ms. Reena Singh");
        teachers.add("Mr. Dharmender Saini");
        teachers.add("Ms. Silica Kole");
        teachers.add("Ms. Deepika");
        teachers.add("Ms. Sanskriti");
        teachers.add("Ms. Preeti Nagrath");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, teachers);
        teachersSpinner.setAdapter(arrayAdapter);

        teachersSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedTeacher = teachersSpinner.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageSent = subjectEditText.getText().toString();
                Meeting meeting = new Meeting(selectedTeacher, messageSent);
                studentRef.child("meetingRequest").setValue(meeting);
                Toast.makeText(FixMeetingActivity.this, "Request Submitted.", Toast.LENGTH_SHORT).show();
                FixMeetingActivity.this.finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });


    }
}
