package com.example.rohan.bvpgo20.NavigationDrawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.rohan.bvpgo20.R;
import com.squareup.picasso.Picasso;

public class AboutUsActivity extends AppCompatActivity {

    ImageView college;
    ImageView principal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        setTitle("About BVCOE");

        college = (ImageView) findViewById(R.id.collegePhoto);
        principal = (ImageView) findViewById(R.id.principalPhoto);

        Picasso.with(AboutUsActivity.this).load("http://educrib.com/uploads/1f6115698c3d72ec4d36f5975e12ec25bvcoend_cover.jpg").into(college);
        Picasso.with(AboutUsActivity.this).load("http://bvcoend.ac.in/images/upload/BVPFILE79516609248352FILE29315UPLOAD9865417.jpg").into(principal);
    }
}
