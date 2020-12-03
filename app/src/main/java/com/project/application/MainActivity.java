package com.project.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Button button  =(Button) findViewById(R.id.btn_ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText num = (EditText) findViewById(R.id.txt_number);
                String number = num.getText().toString();
                Intent intent = new Intent(MainActivity.this , XOActivity.class);
                intent.putExtra("number" , number);
                startActivity(intent);

            }
        });*/
    }

    public void playGame(View view){
        EditText num = (EditText) findViewById(R.id.txt_number);

        if (num.getText().toString().trim().equals("")){
            num.setError("....");
        }else{
            String number = num.getText().toString();
            int n = Integer.parseInt(number);

            if (n < 3 || n > 7){
                num.setError("เริ่มตั้งแต่ 3 - 7");
            }else {
                Intent intent = new Intent(MainActivity.this , XOActivity.class);
                intent.putExtra("number" , number);
                startActivity(intent);
            }
        }


    }
}