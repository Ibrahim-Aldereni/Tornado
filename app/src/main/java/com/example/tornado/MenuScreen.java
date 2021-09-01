package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MenuScreen extends AppCompatActivity {
    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        // get button
        Button homeBtn = findViewById(R.id.returnToHomeBtn);

        // add listeners
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToHomePage = new Intent(MenuScreen.this, MainActivity.class);
                startActivity(goToHomePage);
            }
        });

        ////////////////////////////////// recycler view ////////////////////////////
        // list of dishes from db
        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "dishes").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        List<Dish> allDishes = appDatabase.dishDao().getAll();

        // get recycler view
        RecyclerView allDishesRecyclerView = findViewById(R.id.dishListRecyclerView);

        // set layout manager for the view (determine if liner list or grid list)
        allDishesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // set the adapter for this recycler
        allDishesRecyclerView.setAdapter(new DishAdapter(allDishes));
    }
}