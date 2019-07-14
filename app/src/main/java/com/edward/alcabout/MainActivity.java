package com.edward.alcabout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startAboutAlc(View view) {
        Intent aboutAlcIntent= new Intent(this, AboutAlcActivity.class);
        startActivity(aboutAlcIntent);
    }

    public void startProfile(View view) {
        Intent profileIntent= new Intent(this, ProfileActivity.class);
        startActivity(profileIntent);
    }
}
