package com.example.rohan.bvpgo20.NavigationDrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rohan.bvpgo20.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TimeTableActivity extends AppCompatActivity {

    Spinner spinner;
    ImageView timeTable;
    ArrayList<String> classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        setTitle("Time Table");

        spinner = (Spinner) findViewById(R.id.spinner);
        timeTable = (ImageView) findViewById(R.id.timeTableImage);

        classes = new ArrayList<>();

        classes.add("CSE - 1st Year");
        classes.add("IT - 1st Year");
        classes.add("ECE - 1st Year");
        classes.add("EEE - 1st Year");
        classes.add("ICE - 1st Year");

        classes.add("CSE - 2nd Year");
        classes.add("IT - 2nd Year");
        classes.add("ECE - 2nd Year");
        classes.add("EEE - 2nd Year");
        classes.add("ICE - 2nd Year");

        classes.add("CSE - 3rd Year");
        classes.add("IT - 3rd Year");
        classes.add("ECE - 3rd Year");
        classes.add("EEE - 3rd Year");
        classes.add("ICE - 3rd Year");

        classes.add("CSE - 4th Year");
        classes.add("IT - 4th Year");
        classes.add("ECE - 4th Year");
        classes.add("EEE - 4th Year");
        classes.add("ICE - 4th Year");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, classes);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(TimeTableActivity.this, classes.get(position).toString(), Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                        Picasso.with(TimeTableActivity.this).load("http://barnsleysixthformcollege.co.uk/wp-content/uploads/2015/03/timetable.jpg").into(timeTable);
                        break;
                    case 1:
                        Picasso.with(TimeTableActivity.this).load("http://www.wizzed.com/wp-content/uploads/2015/01/timetable1.gif").into(timeTable);
                        break;
                    case 2:
                        Picasso.with(TimeTableActivity.this).load("http://i28.tinypic.com/2lc8g48.jpg").into(timeTable);
                        break;
                    case 4:
                        Picasso.with(TimeTableActivity.this).load("http://www.academy.tas.edu.au/Images/Timetable/Timetable_2013.JPG").into(timeTable);
                        break;
                    case 5:
                        Picasso.with(TimeTableActivity.this).load("http://www.brightoncollege.com/wp-content/uploads/2012/03/how-to-plan-a-college-time-table.jpg").into(timeTable);
                        break;
                    case 7:
                        Picasso.with(TimeTableActivity.this).load("http://barnsleysixthformcollege.co.uk/wp-content/uploads/2015/03/timetable.jpg").into(timeTable);
                        break;
                    case 8:
                        Picasso.with(TimeTableActivity.this).load("http://www.wizzed.com/wp-content/uploads/2015/01/timetable1.gif").into(timeTable);
                        break;
                    case 9:
                        Picasso.with(TimeTableActivity.this).load("http://i28.tinypic.com/2lc8g48.jpg").into(timeTable);
                        break;
                    case 11:
                        Picasso.with(TimeTableActivity.this).load("http://www.academy.tas.edu.au/Images/Timetable/Timetable_2013.JPG").into(timeTable);
                        break;
                    case 13:
                        Picasso.with(TimeTableActivity.this).load("http://www.brightoncollege.com/wp-content/uploads/2012/03/how-to-plan-a-college-time-table.jpg").into(timeTable);
                        break;
                    case 14:
                        Picasso.with(TimeTableActivity.this).load("http://barnsleysixthformcollege.co.uk/wp-content/uploads/2015/03/timetable.jpg").into(timeTable);
                        break;
                    case 15:
                        Picasso.with(TimeTableActivity.this).load("http://www.wizzed.com/wp-content/uploads/2015/01/timetable1.gif").into(timeTable);
                        break;
                    case 16:
                        Picasso.with(TimeTableActivity.this).load("http://i28.tinypic.com/2lc8g48.jpg").into(timeTable);
                        break;
                    case 18:
                        Picasso.with(TimeTableActivity.this).load("http://www.brightoncollege.com/wp-content/uploads/2012/03/how-to-plan-a-college-time-table.jpg").into(timeTable);
                        break;
                    case 19:
                        Picasso.with(TimeTableActivity.this).load("http://www.academy.tas.edu.au/Images/Timetable/Timetable_2013.JPG").into(timeTable);
                        break;
                    default:
                        Picasso.with(TimeTableActivity.this).load(R.drawable.timetable1).into(timeTable);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
