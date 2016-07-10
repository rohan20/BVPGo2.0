package com.example.rohan.bvpgo20.NavigationDrawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.rohan.bvpgo20.R;
import com.example.rohan.bvpgo20.Utils.Constants;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class AttendanceActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayList<String> subjects;

    String uid;

    Firebase ref;
    Firebase subjectRef;

    TextView attendance;
    TextView attendanceStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        setTitle("Attendance");

        Intent i = getIntent();
        uid = i.getStringExtra(Constants.SHARED_PREF_UID);

        ref = new Firebase(Constants.FIREBASE_URL);
        subjectRef = ref.child("Students").child(uid).child("attendance");

        attendance = (TextView) findViewById(R.id.attendanceTextView);
        attendanceStatus = (TextView) findViewById(R.id.attendanceStatusTextView);

        spinner = (Spinner) findViewById(R.id.attendanceSpinner);
        subjects = new ArrayList<>();

        subjects.add("ETCS 301");
        subjects.add("ETCS 302");
        subjects.add("ETCS 303");
        subjects.add("ETCS 308");
        subjects.add("ETEE 303");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, subjects);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                subjectRef.child(spinner.getItemAtPosition(position).toString()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        attendance.setText(dataSnapshot.getValue().toString());
                        String x = dataSnapshot.getValue().toString();
                        x = x.substring(0, 2);
                        if (Float.parseFloat(x) < 75) {
                            attendanceStatus.setText("You may get detained in this subject");
                            attendanceStatus.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                        } else {
                            attendanceStatus.setText("You are safe in this subject");
                            attendanceStatus.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
