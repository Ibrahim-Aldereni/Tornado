package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get buttons
        Button addDishBtn = findViewById(R.id.homeAddDishBtn);
        Button menuBtn = findViewById(R.id.homeMenuBtn);

        // add listeners
        addDishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAddDishScreen = new Intent(MainActivity.this, AddDishScreen.class);
                startActivity(goToAddDishScreen);
            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMenuScreen = new Intent(MainActivity.this, MenuScreen.class);
                startActivity(goToMenuScreen);
            }
        });

    }
}