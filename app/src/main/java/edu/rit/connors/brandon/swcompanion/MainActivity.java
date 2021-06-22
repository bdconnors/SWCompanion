package edu.rit.connors.brandon.swcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import edu.rit.connors.brandon.swcompanion.api.SWApi;
import edu.rit.connors.brandon.swcompanion.api.models.Person;

public class MainActivity extends AppCompatActivity {

    public static final int SPLASH_DISPLAY_LENGTH = 1500;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Handler().postDelayed(() -> {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_DISPLAY_LENGTH);

    }
}
