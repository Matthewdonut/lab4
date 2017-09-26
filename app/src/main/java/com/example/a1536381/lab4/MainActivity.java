package com.example.a1536381.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.util.Log;
import android.view.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openMapActivity(View v) {
        Intent sendIntent = new Intent(this, MapActivity.class);
        sendIntent.putExtra("country", getString(R.string.country));

        //sendIntent.setType("text/plain");
        if(sendIntent.resolveActivity(getPackageManager()) != null)
            startActivity(sendIntent);
    }
}
