package com.example.ifte.myflashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        findViewById(R.id.cancel_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(AddCardActivity.this, MainActivity.class);
                AddCardActivity.this.startActivity(data);
            }
        });

        findViewById(R.id.save_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText newQuestion = findViewById(R.id.newQuestion);
                EditText correctAnswer = findViewById(R.id.correctAnswer);
                EditText wrongAnswer = findViewById(R.id.wrongAnswer);
                EditText wrongAnswer2 = findViewById(R.id.wrongAnswer2);

                Intent data = new Intent(); // create a new Intent, this is where we will put our data
                data.putExtra("question", newQuestion.getText().toString());
                data.putExtra("correct", correctAnswer.getText().toString());
                data.putExtra("wrong", wrongAnswer.getText().toString());
                data.putExtra("wrong2", wrongAnswer2.getText().toString());
                setResult(RESULT_OK, data); // set result code and bundle data for response
                finish(); // closes this activity and pass data to the original activity that launched this activity
            }
        });
    }
}
