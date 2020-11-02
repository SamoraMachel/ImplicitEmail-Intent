package com.example.intentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText senderEmail = (EditText)findViewById(R.id.senderEmail);
        EditText message = (EditText)findViewById(R.id.Message);
        EditText subject = (EditText)findViewById(R.id.subject);
        Button sendButton = (Button)findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SENDTO);
                email.setData(Uri.parse("mailto:" + senderEmail.getText().toString()
                        + "?subject=" + subject.getText().toString() + "&body=" +
                        message.getText().toString()
                ));
                startActivity(Intent.createChooser(email, "Choose an email client:"));
            }
        });


    }
}