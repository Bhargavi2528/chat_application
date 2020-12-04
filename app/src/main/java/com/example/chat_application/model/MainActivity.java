package com.example.chat_application.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chat_application.R;
import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {

    CountryCodePicker ccp;
    EditText Mobilenumber;
    Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mobilenumber = (EditText) findViewById(R.id.Mobileno);
        ccp = (CountryCodePicker) findViewById(R.id.Country_code_picker);
        ccp.registerCarrierNumberEditText(Mobilenumber);
        next = (Button) findViewById(R.id.btn_registration);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registration();
            }
        });
    }

    private void Registration() {

        String Mobileno = Mobilenumber.getText().toString().replace(" ", "");

        if (TextUtils.isEmpty(Mobileno))
        {
            Mobilenumber.setError("Enter Number");
            Toast.makeText(MainActivity.this,"Please enter Mobile Number",Toast.LENGTH_SHORT).show();
        }
        else if (Mobileno.length() != 10)
        {
            Mobilenumber.setError("Enter Valid Number");
            Toast.makeText(MainActivity.this,"Please enter valid number",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent(MainActivity.this, Verification.class);
            intent.putExtra("mobileno", ccp.getFullNumberWithPlus().replace(" ", ""));
            startActivity(intent);
            fileList();
        }
    }
}
