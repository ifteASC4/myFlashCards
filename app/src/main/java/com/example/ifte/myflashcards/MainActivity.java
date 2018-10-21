package com.example.ifte.myflashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.flashcard_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.choice1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.choice1).setBackgroundColor(getResources().getColor(R.color.my_red_color, null));
                findViewById(R.id.choice2).setBackgroundColor(getResources().getColor(R.color.my_green_color, null));
            }
        });

        findViewById(R.id.choice2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.choice2).setBackgroundColor(getResources().getColor(R.color.my_green_color, null));
            }
        });

        findViewById(R.id.choice3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.choice3).setBackgroundColor(getResources().getColor(R.color.my_red_color, null));
                findViewById(R.id.choice2).setBackgroundColor(getResources().getColor(R.color.my_green_color, null));
            }
        });

        findViewById(R.id.app_background).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.choice1).setBackgroundColor(getResources().getColor(R.color.my_answer_color, null));
                findViewById(R.id.choice2).setBackgroundColor(getResources().getColor(R.color.my_answer_color, null));
                findViewById(R.id.choice3).setBackgroundColor(getResources().getColor(R.color.my_answer_color, null));
            }
        });

        findViewById(R.id.show_answers).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.choice1).setVisibility(View.VISIBLE);
                findViewById(R.id.choice2).setVisibility(View.VISIBLE);
                findViewById(R.id.choice3).setVisibility(View.VISIBLE);
                findViewById(R.id.hide_answers).setVisibility(View.VISIBLE);
                findViewById(R.id.show_answers).setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.hide_answers).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.choice1).setVisibility(View.INVISIBLE);
                findViewById(R.id.choice2).setVisibility(View.INVISIBLE);
                findViewById(R.id.choice3).setVisibility(View.INVISIBLE);
                findViewById(R.id.hide_answers).setVisibility(View.INVISIBLE);
                findViewById(R.id.show_answers).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.add_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(i, 100);
            }
        });

        findViewById(R.id.edit_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent data = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivity(data);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) { // this 100 needs to match the 100 we used when we called startActivityForResult!
            String string1 = data.getExtras().getString("question");
            String string2 = data.getExtras().getString("correct");
            String string3 = data.getExtras().getString("wrong");
            String string4 = data.getExtras().getString("wrong2");

            // set text view with string
            TextView newText = findViewById(R.id.flashcard_question);
            newText.setText(string1);
            TextView newText2 = findViewById(R.id.choice1);
            newText2.setText(string3);
            TextView newText3 = findViewById(R.id.choice2);
            newText3.setText(string2);
            TextView newText4 = findViewById(R.id.choice3);
            newText4.setText(string4);
        }
    }
}
