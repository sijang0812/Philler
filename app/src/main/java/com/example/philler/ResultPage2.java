package com.example.philler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultPage2 extends AppCompatActivity implements OnClickListener{
    ImageView imageView;
    Button restartButton;
    Button mainButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page2);

        imageView = findViewById(R.id.imageView);
        mainButton = findViewById(R.id.mainButton);
        mainButton.setOnClickListener(this);
        restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.mainButton){
            this.finish();
            Intent intent = new Intent(this, StartPage.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.restartButton){
            this.finish();
            Intent intent = new Intent(this, MailFiltering.class);
            startActivity(intent);
        }
    }
}
