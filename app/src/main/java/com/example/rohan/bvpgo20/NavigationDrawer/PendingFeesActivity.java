package com.example.rohan.bvpgo20.NavigationDrawer;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohan.bvpgo20.R;
import com.example.rohan.bvpgo20.Utils.Constants;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class PendingFeesActivity extends AppCompatActivity {

    ArrayList<String> sems;
    ArrayList<String> amount;

    Firebase ref;
    Firebase feesRef;
    Firebase tempFeesRef;

    String uid;
    String status;
    String feeAmount;

    TextView amountTextView;
    TextView statusTextView;

    Spinner semesterSelector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_fees);

        setTitle("Fee status");

        Intent i = getIntent();
        uid = i.getStringExtra(Constants.SHARED_PREF_UID);

        amountTextView = (TextView) findViewById(R.id.amountTextView);
        statusTextView = (TextView) findViewById(R.id.statusTextView);

        ref = new Firebase(Constants.FIREBASE_URL);
        feesRef = ref.child("Students").child(uid).child("pendingFees");
        tempFeesRef = ref.child("Students").child(uid).child("pendingFees");

        semesterSelector = (Spinner) findViewById(R.id.semSpinner);

        sems = new ArrayList<>();
        amount = new ArrayList<>();

        sems.add("Semester 1");
        sems.add("Semester 2");
        sems.add("Semester 3");
        sems.add("Semester 4");
        sems.add("Semester 5");
        sems.add("Semester 6");
        sems.add("Semester 7");
        sems.add("Semester 8");

        ArrayAdapter semesterAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sems);
        semesterSelector.setAdapter(semesterAdapter);

        semesterSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        tempFeesRef = feesRef.child("Semester 1");
                        status = "Paid";
                        getFeeAmount();
                        statusTextView.setTextColor(getResources().getColor(android.R.color.holo_green_light));
                        break;
                    }
                    case 1: {
                        tempFeesRef = feesRef.child("Semester 2");
                        status = "Paid";
                        getFeeAmount();
                        statusTextView.setTextColor(getResources().getColor(android.R.color.holo_green_light));
                        break;
                    }
                    case 2: {
                        tempFeesRef = feesRef.child("Semester 3");
                        status = "Paid";
                        getFeeAmount();
                        statusTextView.setTextColor(getResources().getColor(android.R.color.holo_green_light));
                        break;
                    }
                    case 3: {
                        tempFeesRef = feesRef.child("Semester 4");
                        status = "Paid";
                        getFeeAmount();
                        statusTextView.setTextColor(getResources().getColor(android.R.color.holo_green_light));
                        break;
                    }
                    case 4: {
                        tempFeesRef = feesRef.child("Semester 5");
                        status = "Paid";
                        getFeeAmount();
                        statusTextView.setTextColor(getResources().getColor(android.R.color.holo_green_light));
                        break;
                    }
                    case 5: {
                        tempFeesRef = feesRef.child("Semester 6");
                        status = "Paid";
                        getFeeAmount();
                        statusTextView.setTextColor(getResources().getColor(android.R.color.holo_green_light));
                        break;
                    }
                    case 6: {
                        tempFeesRef = feesRef.child("Semester 7");
                        status = "Pending";
                        getFeeAmount();
                        statusTextView.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                        break;
                    }
                    case 7: {
                        tempFeesRef = feesRef.child("Semester 8");
                        status = "Pending";
                        getFeeAmount();
                        statusTextView.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                        break;
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

    }

    public void getFeeAmount() {
        tempFeesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() == null) {
                    Toast.makeText(PendingFeesActivity.this, "NULL", Toast.LENGTH_SHORT).show();
                    return;
                }

                feeAmount = dataSnapshot.getValue().toString();
                amountTextView.setText(feeAmount);
                statusTextView.setText(status);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }


        });

    }
}
