package com.example.tornado;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder>{
    // set the list that the adapter will use to bind data to the fragment
    List<Dish> allDishes = new ArrayList<>();

    // constructor
    public DishAdapter(List<Dish> allDishes) {
        this.allDishes = allDishes;
    }

    // creating view holder class
    public static class DishViewHolder extends RecyclerView.ViewHolder {

        //task object
        public Dish dish;
        //view object
        public View itemView;

        public DishViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;

            // listener to open ingredient details page for every dish
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goToDetailsPage = new Intent(v.getContext(), DetailesScreen.class);
                    goToDetailsPage.putExtra("dish", dish.ingredients);
                    v.getContext().startActivity(goToDetailsPage);
                }
            });
        }
    }

    @NonNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // create the view
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_dish_item, viewGroup, false);
        return new DishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DishAdapter.DishViewHolder dishViewHolder, int i) {
        dishViewHolder.dish = allDishes.get(i);

        TextView name = dishViewHolder.itemView.findViewById(R.id.dishNameFragment);
        TextView price = dishViewHolder.itemView.findViewById(R.id.dishPriceFragment);

        name.setText(dishViewHolder.dish.name);
        price.setText(dishViewHolder.dish.price);
    }

    @Override
    public int getItemCount() {
        return allDishes.size();
    }
}
