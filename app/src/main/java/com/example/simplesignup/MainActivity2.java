package com.example.simplesignup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView name,surname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name=findViewById(R.id.textname);
        surname=findViewById(R.id.textsname);
        String username=getIntent().getStringExtra("keyname");
        String userSurname=getIntent().getStringExtra("keysurname");
        name.setText(username);
        surname.setText(userSurname);

    }
}