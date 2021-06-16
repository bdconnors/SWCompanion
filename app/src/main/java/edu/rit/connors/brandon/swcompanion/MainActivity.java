package edu.rit.connors.brandon.swcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final int SPLASH_DISPLAY_LENGTH = 2000;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Handler().postDelayed(() -> {
            Intent intent = new Intent(getApplicationContext(), WikiActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_DISPLAY_LENGTH);

    }
}
