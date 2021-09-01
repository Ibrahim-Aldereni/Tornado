package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDishScreen extends AppCompatActivity {
    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish_screen);


        /////////////////////////////////// save to db ////////////////////////////////

        // get all edit text data
        EditText dishName = findViewById(R.id.dishNameField);
        EditText dishPrice = findViewById(R.id.dishPriceField);
        EditText dishIngredients = findViewById(R.id.dishIngredientsField);

        // get the submit button
        Button submitBtn = findViewById(R.id.addDishSubmitBtn);

        // add listeners
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = dishName.getText().toString();
                String price = dishPrice.getText().toString();
                String ingredients = dishIngredients.getText().toString();

                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "dishes").allowMainThreadQueries().fallbackToDestructiveMigration().build();

                // save input fields into object
                Dish dish = new Dish(name, price, ingredients);
                // save to db
                appDatabase.dishDao().insertAll(dish);
                // redirect to menu page
                Intent goToMenuPage = new Intent(AddDishScreen.this, MenuScreen.class);
                startActivity(goToMenuPage);
            }
        });


    }
}