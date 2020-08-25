package com.builditbigger.jokeandroidlibrary;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;

public class DisplayJoke extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        Intent intent = getIntent();
        String joke = intent.getStringExtra("joke");

        TextView jokeTextView = (TextView) findViewById(R.id.joke_text);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }
    }

}

