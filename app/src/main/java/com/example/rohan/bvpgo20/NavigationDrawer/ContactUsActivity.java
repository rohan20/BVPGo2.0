package com.example.rohan.bvpgo20.NavigationDrawer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.rohan.bvpgo20.R;
import com.squareup.picasso.Picasso;

public class ContactUsActivity extends AppCompatActivity {

    ImageView location;
    ImageView call1;
    ImageView call2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        setTitle("Contact Information");

        location = (ImageView) findViewById(R.id.location);
        call1 = (ImageView) findViewById(R.id.call1);
        call2 = (ImageView) findViewById(R.id.call2);

        Picasso.with(ContactUsActivity.this).load("http://images.clipartpanda.com/location-icon-map-location_icon.png").into(location);
        Picasso.with(ContactUsActivity.this).load("https://pixabay.com/static/uploads/photo/2015/02/27/06/29/phone-651704_640.png").into(call1);
        Picasso.with(ContactUsActivity.this).load("https://pixabay.com/static/uploads/photo/2015/02/27/06/29/phone-651704_640.png").into(call2);

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?daddr=28.675852, 77.113036"));
                startActivity(intent);
            }
        });

        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "01125278444"));
                startActivity(intent);
            }
        });

        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "01125278443"));
                startActivity(intent);
            }
        });

    }
}
