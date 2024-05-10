package com.example.mypantry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class mealRecommendation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_recommendations);


        ImageView imageView = (ImageView) findViewById(R.id.recipeImage);
        imageView.setImageResource(R.drawable.german_pancake);

        TextView nameTextView = (TextView) findViewById(R.id.recipeName);
        nameTextView.setText(R.string.name_text1);

        TextView ingredientTextView = (TextView) findViewById(R.id.recipeIngredients);
        ingredientTextView.setText(R.string.ingredient_text1);

        TextView instructionTextView = (TextView) findViewById(R.id.recipeInstructions);
        instructionTextView.setText(R.string.instruction_text1);


        Button recipeBtn1 = findViewById(R.id.recipe_button1);
        recipeBtn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                ImageView imageView = (ImageView) findViewById(R.id.recipeImage);
                imageView.setImageResource(R.drawable.german_pancake);

                TextView nameTextView = (TextView) findViewById(R.id.recipeName);
                nameTextView.setText(R.string.name_text1);

                TextView ingredientTextView = (TextView) findViewById(R.id.recipeIngredients);
                ingredientTextView.setText(R.string.ingredient_text1);

                TextView instructionTextView = (TextView) findViewById(R.id.recipeInstructions);
                instructionTextView.setText(R.string.instruction_text1);
            }
        });


        Button recipeBtn2 = findViewById(R.id.recipe_button2);
        recipeBtn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                ImageView imageView = (ImageView) findViewById(R.id.recipeImage);
                imageView.setImageResource(R.drawable.cheesy_carrots);

                TextView nameTextView = (TextView) findViewById(R.id.recipeName);
                nameTextView.setText(R.string.name_text2);

                TextView ingredientTextView = (TextView) findViewById(R.id.recipeIngredients);
                ingredientTextView.setText(R.string.ingredient_text2);

                TextView instructionTextView = (TextView) findViewById(R.id.recipeInstructions);
                instructionTextView.setText(R.string.instruction_text2);
            }
        });

        Button recipeBtn3 = findViewById(R.id.recipe_button3);
        recipeBtn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                ImageView imageView = (ImageView) findViewById(R.id.recipeImage);
                imageView.setImageResource(R.drawable.grasshopper_alcohol);

                TextView nameTextView = (TextView) findViewById(R.id.recipeName);
                nameTextView.setText(R.string.name_text3);

                TextView ingredientTextView = (TextView) findViewById(R.id.recipeIngredients);
                ingredientTextView.setText(R.string.ingredient_text3);

                TextView instructionTextView = (TextView) findViewById(R.id.recipeInstructions);
                instructionTextView.setText(R.string.instruction_text3);
            }
        });


        Intent intent = new Intent(mealRecommendation.this, MainActivity.class);

        Button closeBtn = findViewById(R.id.close_recipe);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}
