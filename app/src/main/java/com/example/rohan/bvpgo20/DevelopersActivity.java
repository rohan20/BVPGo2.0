package com.example.rohan.bvpgo20;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DevelopersActivity extends AppCompatActivity {

    ImageView rohan;
    ImageView sahib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);

        setTitle("Developed By");

        rohan = (ImageView) findViewById(R.id.imageRohan);
        sahib = (ImageView) findViewById(R.id.imageSahib);

        Picasso.with(DevelopersActivity.this).load("https://scontent.xx.fbcdn.net/hphotos-xpa1/v/t1.0-9/10390360_1628330457378612_1731398566093234437_n.jpg?oh=ff47e8666d1d7c98e9fcea80b740a54b&oe=57A33281").into(rohan);
        Picasso.with(DevelopersActivity.this).load("https://scontent.xx.fbcdn.net/hphotos-xta1/v/t1.0-9/12096137_10152989862416920_8014298938280384481_n.jpg?oh=a98acc2faf43dba872137713ae0359d8&oe=579B46BF").into(sahib);
    }

    public void callSahib(View v) {
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919899090147"));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    public void callRohan(View v) {
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919891417273"));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    public void emailSahib(View v) {
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:sahib.sethi.30@gmail.com"));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }

    public void emailRohan(View v) {
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:rohan.bvcoe@gmail.com"));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }

}
