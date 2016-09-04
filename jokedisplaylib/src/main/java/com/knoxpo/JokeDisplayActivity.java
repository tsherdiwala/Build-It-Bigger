package com.knoxpo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    private static final String
            TAG = JokeDisplayActivity.class.getSimpleName(),
            EXTRA_JOKE = TAG + ".EXTRA_JOKE";

    public static Intent getIntent(Context context, String joke) {
        Intent intent = new Intent(context, JokeDisplayActivity.class);
        intent.putExtra(EXTRA_JOKE, joke);
        return intent;
    }

    private TextView mJokeTV;
    private String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        init();

        updateUI();
    }

    private void init(){
        mJoke = getIntent().getStringExtra(EXTRA_JOKE);
        mJokeTV = (TextView)findViewById(R.id.tv_joke);
    }

    private void updateUI(){
        mJokeTV.setText(mJoke);
    }
}
