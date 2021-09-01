package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailesScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailes_screen);

        Intent intent = getIntent();
        String theDish= intent.getExtras().getString("dish");
        TextView dish = findViewById(R.id.ingredirentsDetails);
        dish.setText(theDish);

        // get button
        Button backBtn = findViewById(R.id.backToMenuBtn);

        // add listeners
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMenuPage = new Intent(DetailesScreen.this, MenuScreen.class);
                startActivity(goToMenuPage);
            }
        });
    }
}