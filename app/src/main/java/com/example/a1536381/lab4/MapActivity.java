package com.example.a1536381.lab4;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MapActivity extends AppCompatActivity {

    EditText etLocation, etErrors;
    String geoLocation;
    String errors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        etLocation = (EditText) findViewById(R.id.location);
        etErrors = (EditText) findViewById(R.id.errors);

        Intent intent = getIntent();
        String country = intent.getStringExtra("country");
        if (country != null) {
            etLocation.setText(country);
        }
    }

    public void searchGoogle(View v) {
        // validate null input
        if(etLocation.getText().toString().trim().isEmpty())
            errors = "You need to input something!";
        else {
            String query = "https://www.google.com/search?q="+Uri.encode(etLocation.getText().toString());
            showGoogleSearch(query);
        }

        etErrors.setText(errors);
    }

    public void searchMaps(View v) {
        if(etLocation.getText().toString().trim().isEmpty())
            errors = "You need to input something!";
        else {
            geoLocation = "geo:0,0?q="+Uri.encode(etLocation.getText().toString());
            showMap(Uri.parse(geoLocation));
        }

        etErrors.setText(errors);
    }

    private void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void showGoogleSearch(String query) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
