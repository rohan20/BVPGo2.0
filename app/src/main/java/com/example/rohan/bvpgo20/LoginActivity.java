package com.example.rohan.bvpgo20;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rohan.bvpgo20.Utils.Constants;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button bLogin;
    Button bRegisterNow;

    String uid;

    SharedPreferences mSharedPreferences;

    ProgressDialog mDialog;

    Firebase ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ref.setAndroidContext(LoginActivity.this);

        if(!isConnected(LoginActivity.this))
            showDialog();

        //check if already logged in
        mSharedPreferences = getSharedPreferences("BVPGO", MODE_PRIVATE);
        if (mSharedPreferences.contains(Constants.SHARED_PREF_UID)) {
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
            uid = mSharedPreferences.getString(Constants.SHARED_PREF_UID, "");
            LoginActivity.this.finish();
        }

        email = (EditText) findViewById(R.id.Email);
        password = (EditText) findViewById(R.id.Password);
        bLogin = (Button) findViewById(R.id.loginButton);
        bRegisterNow = (Button) findViewById(R.id.registerButton);

        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Logging in...");

        ref = new Firebase(Constants.FIREBASE_URL);

        bRegisterNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDialog.show();

                ref.authWithPassword(email.getText().toString(), password.getText().toString(), new Firebase.AuthResultHandler() {
                    @Override
                    public void onAuthenticated(AuthData authData) {
                        mDialog.dismiss();

                        uid = authData.getUid();

                        SharedPreferences.Editor editor = mSharedPreferences.edit();
                        editor.putString(Constants.SHARED_PREF_UID, uid);
                        editor.commit();

                        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(i);
                        LoginActivity.this.finish();

                        Toast.makeText(LoginActivity.this, "UID: " + authData.getUid(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError) {
                        mDialog.dismiss();
                        Toast.makeText(LoginActivity.this, "Incorrect Password / Register yourself", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

    }

    public boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wifiInfo != null && wifiInfo.isConnected()) || (mobileInfo != null && mobileInfo.isConnected())) {
            Toast.makeText(LoginActivity.this, "WiFi/Data connected", Toast.LENGTH_SHORT).show();
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
                        if(!isConnected(LoginActivity.this))
                            showDialog();
                    }
                })
                .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        LoginActivity.this.finish();
                    }
                });

        builder.create().show();
    }
}


