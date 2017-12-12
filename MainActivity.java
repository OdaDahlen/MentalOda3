package com.example.oda.mentaloda3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    public static final String EXTRA_MESSAGE = "com.example.MentalOda3.MESSAGE";
    int mCount = 1;
    TextView mTextView;
    TextView mTextView2;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.welcome);
        mTextView.setText(R.string.app_name);
        mTextView2 = (TextView) findViewById(R.id.display_info);

        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMyText();
            }
        });
    }


    public void setMyText() {
        if (mCount == 1) {
            mTextView2.setText(R.string.s1);
        } else if (mCount == 2) {
            mTextView2.setText(R.string.s2);
        } else if(mCount == 3) {
            mTextView2.setText(R.string.s3);
        } else if(mCount == 4){
            mTextView2.setText(getString(R.string.hvorforCBT));
        }
        mCount +=1;
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}

