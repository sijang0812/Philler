package com.example.philler;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HelpPage extends AppCompatActivity implements View.OnClickListener {
    android.widget.ImageView ImageView;
    Button mainButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_page);

        ImageView = findViewById(R.id.ImageView);
        mainButton = findViewById(R.id.mainButton);
    }

    @Override
    public void onClick(View v){
        this.finish();
    }
}
