package com.example.rohan.bvpgo20.NavigationDrawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.rohan.bvpgo20.R;
import com.example.rohan.bvpgo20.Utils.Constants;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class MarksAndResultsActivity extends AppCompatActivity {

    String uid;

    Spinner semesterSpinner;
    ListView lvSubjects;
    ListView lvMarks;

    Firebase ref;
    Firebase marksRef;
    Firebase tempMarksRef;

    ArrayList<String> subjects;
    ArrayList<String> sems;
    ArrayList<String> marks;

    TextView resultTextView;
    float result;

    ArrayAdapter subjectsArrayAdapter;
    ArrayAdapter marksArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks_and_results);

        setTitle("Marks and Results");

        subjects = new ArrayList<>();
        sems = new ArrayList<>();
        marks = new ArrayList<>();

        sems.add("Semester 1");
        sems.add("Semester 2");
        sems.add("Semester 3");
        sems.add("Semester 4");
        sems.add("Semester 5");

        final Intent i = getIntent();
        uid = i.getStringExtra(Constants.SHARED_PREF_UID);

        semesterSpinner = (Spinner) findViewById(R.id.chooseSemesterSpinner);
        lvSubjects = (ListView) findViewById(R.id.subjectsList);
        lvMarks = (ListView) findViewById(R.id.marksList);
        resultTextView = (TextView) findViewById(R.id.result);

        ref = new Firebase(Constants.FIREBASE_URL);
        marksRef = ref.child("Students").child(uid).child("marks");

        ArrayAdapter semesterSpinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sems);
        semesterSpinner.setAdapter(semesterSpinnerAdapter);

        subjectsArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, subjects);
        lvSubjects.setAdapter(subjectsArrayAdapter);

        marksArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, marks);
        lvMarks.setAdapter(marksArrayAdapter);

        semesterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                result = 0;
                marks.clear();

                switch (position) {
                    case 0: {
                        subjects.clear();
                        subjects.add("ETCS 101");
                        subjects.add("ETCS 105");
                        subjects.add("ETEC 103");
                        subjects.add("ETEE 102");
                        tempMarksRef = marksRef.child("Semester 1");
                        xyz();
                        break;
                    }
                    case 1: {
                        subjects.clear();
                        subjects.add("ETCS 103");
                        subjects.add("ETCS 104");
                        subjects.add("ETEC 104");
                        subjects.add("ETEE 106");
                        tempMarksRef = marksRef.child("Semester 2");
                        xyz();
                        break;
                    }
                    case 2: {
                        subjects.clear();
                        subjects.add("ETCS 201");
                        subjects.add("ETCS 202");
                        subjects.add("ETCS 204");
                        subjects.add("ETEE 212");
                        tempMarksRef = marksRef.child("Semester 3");
                        xyz();
                        break;
                    }
                    case 3: {
                        subjects.clear();
                        subjects.add("ETCS 203");
                        subjects.add("ETCS 205");
                        subjects.add("ETEC 208");
                        subjects.add("ETIT 201");
                        tempMarksRef = marksRef.child("Semester 4");
                        xyz();
                        break;
                    }
                    case 4: {
                        subjects.clear();
                        subjects.add("ETCS 301");
                        subjects.add("ETCS 303");
                        subjects.add("ETCS 306");
                        subjects.add("ETEE 302");
                        tempMarksRef = marksRef.child("Semester 5");
                        xyz();
                        break;
                    }
                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


    }

    public void xyz() {

        subjectsArrayAdapter.notifyDataSetChanged();

        tempMarksRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot temp : dataSnapshot.getChildren()) {
                    marks.add(temp.getValue().toString());
                }

                marksArrayAdapter.notifyDataSetChanged();
                setResult();

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });

    }

    public void setResult() {

        for (int i = 0; i < marks.size(); i++) {
            result += Float.valueOf(marks.get(i));
        }

        result = (result / 4);

        resultTextView.setText("Result = " + result + " %");

    }


}