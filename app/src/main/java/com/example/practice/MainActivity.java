package com.example.practice;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practice.databinding.ActivityMainLinearBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        TextView textView = findViewById(R.id.textView);
//        textView.setText(R.string.Dino);
//
//        ImageView imageView = findViewById(R.id.imageView);
//        imageView.setImageResource(R.drawable.velociraptor1);


        ActivityMainLinearBinding binding = ActivityMainLinearBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//        binding.textView.setText(R.string.Dino);
//        binding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i("ButtonClickBidding", "Button is clicked");
//            }
//        });
//
//        Button button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i("ButtonClickProgramm", "Button is clicked");
//            }
//        });

        Button checkButton = findViewById(R.id.button);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText answerEditText = findViewById(R.id.editText);
                String answer = answerEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, MainSecondActivity.class);
                intent.putExtra("answer", answer);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EditText answerEditText = findViewById(R.id.editText);
        ActivityMainLinearBinding binding = ActivityMainLinearBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (requestCode == 1) {
            if (resultCode == RESULT_CANCELED) {
                binding.textView.setText("Не угадали, может теперь?");
            } else if (resultCode == RESULT_OK) {
                binding.textView.setText("Вы уже угадали");
            }
        }
    }

//    public void clicky(View view){
//        Log.i("buttonClick", "Button is clicked");
//    }
}