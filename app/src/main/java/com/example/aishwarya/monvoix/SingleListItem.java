package com.example.aishwarya.monvoix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleListItem extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.single_list_item_view);

        ImageView productimage = (ImageView) findViewById(R.id.image);

        Intent i = getIntent();
        // getting attached intent data
        String product = i.getStringExtra("product");
        // displaying selected product name
        switch (product) {
            case "Alphabets":
                productimage.setImageResource(R.drawable.alphabets);
                break;
            case "Baby Sign Language":
                productimage.setImageResource(R.drawable.babysignlanguage);
                break;
            case "Color:Black":
               productimage.setImageResource(R.drawable.black);
                break;
            case "Color:Orange":
                productimage.setImageResource(R.drawable.orange);
                break;
            case "Color:Pink":
                productimage.setImageResource(R.drawable.pink);
                break;
            case "Color:Purple":
                productimage.setImageResource(R.drawable.purple);
                break;
            case "Color:Red":
                productimage.setImageResource(R.drawable.red);
                break;
            case "Color:White":
                productimage.setImageResource(R.drawable.white);
                break;
            case "Color:Yellow":
                productimage.setImageResource(R.drawable.yellow);
                break;
            case "Common Word:Bath":
               productimage.setImageResource(R.drawable.bath);
                break;
            case "Common Word:Bed":
                productimage.setImageResource(R.drawable.bed);
                break;
            case "Common Word:Book":
                 productimage.setImageResource(R.drawable.book);
                break;
            case "Common Word:Bubbles":
                productimage.setImageResource(R.drawable.bubbles);
                break;
            case "Common Word:Hair":
                productimage.setImageResource(R.drawable.hair);
                break;
            case "Common Word:No":
                 productimage.setImageResource(R.drawable.no);
                break;
            case "Common Word:Yes":
                 productimage.setImageResource(R.drawable.yes);
                break;
            case "Greeting:Good":
                productimage.setImageResource(R.drawable.good);
                break;
            case "Greeting:Good Bye":
                  productimage.setImageResource(R.drawable.goodbye);
                break;
            case "Greeting:Hello":
                  productimage.setImageResource(R.drawable.hello);
                break;
            case "Greeting:I Love You":
                  productimage.setImageResource(R.drawable.iloveyou);
                break;
            case "Greeting:Morning":
                  productimage.setImageResource(R.drawable.morning);
                break;
            case "Greeting:Nice To Meet You":
                  productimage.setImageResource(R.drawable.nicetomeetu);
                break;
            case "Greeting:Night":
                 productimage.setImageResource(R.drawable.night);
                break;
            case "Greeting:Please":
                 productimage.setImageResource(R.drawable.please);
                break;
            case "Greeting:Thank You":
                 productimage.setImageResource(R.drawable.thankyou);
                break;
            case "Numbers":
                productimage.setImageResource(R.drawable.numbers);
                break;
//upto all 10 images

        }

    }
}