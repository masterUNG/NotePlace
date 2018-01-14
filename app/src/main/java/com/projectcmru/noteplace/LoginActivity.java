package com.projectcmru.noteplace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView text = (TextView) findViewById(R.id.textLink);
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }
    public void onClickNext(View view){
        Button but_next = (Button)findViewById(R.id.butinto);
        Intent intent = new Intent(LoginActivity.this, ListviewActivity.class);
        startActivity(intent);
    }
}
