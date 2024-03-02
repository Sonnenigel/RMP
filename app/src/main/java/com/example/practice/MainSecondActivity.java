package com.example.practice;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.practice.databinding.ActivityMainSecondBinding;

public class MainSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainSecondBinding binding = ActivityMainSecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String correctAnswer = "велоцираптор";
        String userAnswer = getIntent().getStringExtra("answer");

        if (userAnswer.equals(correctAnswer)) {
            setResult(RESULT_OK);
            binding.its.setText("Да, все верно");
            //finish();
        } else {
            setResult(RESULT_CANCELED);
            binding.its.setText("Увы, но это не " + userAnswer);
            //finish();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_CANCELED);
        //finish();
    }
}





