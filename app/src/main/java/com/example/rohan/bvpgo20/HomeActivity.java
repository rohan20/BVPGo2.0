package com.example.rohan.bvpgo20;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohan.bvpgo20.Models.Event;
import com.example.rohan.bvpgo20.NavigationDrawer.AboutUsActivity;
import com.example.rohan.bvpgo20.NavigationDrawer.AttendanceActivity;
import com.example.rohan.bvpgo20.NavigationDrawer.ContactUsActivity;
import com.example.rohan.bvpgo20.NavigationDrawer.DepartmentsActivity;
import com.example.rohan.bvpgo20.NavigationDrawer.FixMeetingActivity;
import com.example.rohan.bvpgo20.NavigationDrawer.LibraryActivity;
import com.example.rohan.bvpgo20.NavigationDrawer.MarksAndResultsActivity;
import com.example.rohan.bvpgo20.NavigationDrawer.PendingFeesActivity;
import com.example.rohan.bvpgo20.NavigationDrawer.SportsActivity;
import com.example.rohan.bvpgo20.NavigationDrawer.TimeTableActivity;
import com.example.rohan.bvpgo20.Utils.Constants;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView;
    private ArrayList<Event> events;

    String uid;

    Firebase ref;
    Firebase studentRef;
    Firebase studentNameRef;
    Firebase studentEmailRef;

    TextView studentName;
    TextView studentEmail;

    String temp;

    SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle("News and Events");

        if (!isConnected(HomeActivity.this))
            showDialog();


        ref.setAndroidContext(HomeActivity.this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSharedPreferences = getSharedPreferences("BVPGO", MODE_PRIVATE);
        uid = mSharedPreferences.getString(Constants.SHARED_PREF_UID, "");

        ref = new Firebase(Constants.FIREBASE_URL);
        studentRef = ref.child("Students").child(uid);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(HomeActivity.this);
        recyclerView.setLayoutManager(llm);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        temp = null;

        studentName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.StudentName);
        studentEmail = (TextView) navigationView.getHeaderView(0).findViewById(R.id.StudentEmail);

        studentNameRef = studentRef.child("name");
        studentEmailRef = studentRef.child("email");

        studentNameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                studentName.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        studentEmailRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                studentEmail.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        initializeData();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(events, HomeActivity.this);
        recyclerView.setAdapter(adapter);

    }

    public void initializeData() {
        events = new ArrayList<>();
        events.add(new Event("GDG Orientation", "Google Developers Group - BVP is organizing it's orientation in the Auditorium on 18th May. Be there!", "https://az725512.vo.msecnd.net/banners/8096c5bb868f555abe5e077bf1bfa071"));
        events.add(new Event("NOTICE", "All 3rd year students have to get their marksheets verified before 20/5/16 for campus recruitment process @ TnP cell.", "http://2.bp.blogspot.com/-oSemV7X1fNg/VmZ-e3qXzwI/AAAAAAAAS4c/vELe1uOTu7w/s1600/BVDU%2BResult.png"));
        events.add(new Event("Fervour - IEEE", "The Annual IEEE Tech Fest is being held on 17th of May this year. May odds be in your fervour.", "https://cdn-az.allevents.in/banners/1d5be5bc3929e361f2d44f3de80a7ec1"));
        events.add(new Event("CSI RSC", "CSI RSC regional meeting to be held at BVCOE on 15/5/16. All RSC students are invited.", "http://rsc.bvpcsi.in/images/cultural/lan.jpg"));
        events.add(new Event("LFT Ceremony", "Leaders For Tomorrow held a plantation drive in Paschim Vihar last week. More than 100 students participated.", "http://bvcoend.ac.in/images/upload/BVP_Bharati_Vidyapeeths_College_of_Engineering_,New_Delhi_9674078201796FILE34153UPLOAD87822651442385690.jpg"));
        events.add(new Event("ACM - Entheos", "ACM's technical fest 'Entheos' has been ranked 17th in New Delhi's best college tech-fests list by Forbes.", "http://bvcoe.acm.org/wp-content/uploads/2014/10/enthoes1-960x479.jpg"));
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_logout) {

            SharedPreferences.Editor editor = mSharedPreferences.edit();
            editor.remove(Constants.SHARED_PREF_UID);
            editor.commit();

            Intent i = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(i);
            HomeActivity.this.finish();

            return true;
        }

        if (id == R.id.action_developers) {

            Intent i = new Intent(HomeActivity.this, DevelopersActivity.class);
            startActivity(i);

            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_marks_and_results) {
            Intent i = new Intent(HomeActivity.this, MarksAndResultsActivity.class);
            i.putExtra(Constants.SHARED_PREF_UID, uid);
            startActivity(i);

        } else if (id == R.id.nav_attendance) {
            Intent i = new Intent(HomeActivity.this, AttendanceActivity.class);
            i.putExtra(Constants.SHARED_PREF_UID, uid);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        } else if (id == R.id.nav_timetable) {
            Intent i = new Intent(HomeActivity.this, TimeTableActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        } else if (id == R.id.nav_setupMeeting) {
            Intent i = new Intent(HomeActivity.this, FixMeetingActivity.class);
            i.putExtra(Constants.SHARED_PREF_UID, uid);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        } else if (id == R.id.nav_checkFees) {
            Intent i = new Intent(HomeActivity.this, PendingFeesActivity.class);
            i.putExtra(Constants.SHARED_PREF_UID, uid);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        } else if (id == R.id.nav_departments) {
            Intent i = new Intent(HomeActivity.this, DepartmentsActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        } else if (id == R.id.nav_sports) {
            Intent i = new Intent(HomeActivity.this, SportsActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        } else if (id == R.id.nav_library) {
            Intent i = new Intent(HomeActivity.this, LibraryActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        } else if (id == R.id.nav_about_us) {
            Intent i = new Intent(HomeActivity.this, AboutUsActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        } else if (id == R.id.nav_contact_us) {
            Intent i = new Intent(HomeActivity.this, ContactUsActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wifiInfo != null && wifiInfo.isConnected()) || (mobileInfo != null && mobileInfo.isConnected())) {
            Toast.makeText(HomeActivity.this, "WiFi/Data connected", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return false;
        }

    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.myDialog);
        builder.setMessage("BVP Go 2.0 requires Internet Connection..")
                .setCancelable(false)
                .setPositiveButton("Connect to WIFI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                        if (!isConnected(HomeActivity.this))
                            showDialog();
                    }
                })
                .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        HomeActivity.this.finish();
                    }
                });

        builder.create().show();
    }

}
