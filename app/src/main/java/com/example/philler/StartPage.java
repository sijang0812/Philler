package com.example.philler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class StartPage extends AppCompatActivity implements View.OnClickListener {
    ImageButton naverButton;
    ImageButton daumButton;
    ImageButton googleButton;
    ImageButton etcButton;
    Button helpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        naverButton = findViewById(R.id.naverButton);
        naverButton.setOnClickListener(this);
        daumButton = findViewById(R.id.daumButton);
        daumButton.setOnClickListener(this);
        googleButton = findViewById(R.id.googleButton);
        googleButton.setOnClickListener(this);
        etcButton = findViewById(R.id.etcButton);
        etcButton.setOnClickListener(this);
        helpButton = findViewById(R.id.helpButton);
        helpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.helpButton){
            Intent intent=new Intent(this, HelpPage.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.etcButton){
            Intent intent = new Intent(this, MailFiltering.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.naverButton){
            Intent intent=new Intent(this, NaverMail.class);
            startActivity(intent);
        }
        else if(view.getId()== R.id.daumButton){
            Intent intent=new Intent(this, DaumMail.class);
            startActivity(intent);
        }
        else if(view.getId()== R.id.googleButton){
            Intent intent=new Intent(this, GoogleMail.class);
            startActivity(intent);
        }
    }
}
