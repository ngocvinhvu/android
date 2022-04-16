package com.example.buoi1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_message);
        mReply = findViewById(R.id.editText_second);
    }
}


public void returnReply(View view) {
    String reply = mReply.getText().toString()
}