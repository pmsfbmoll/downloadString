package com.example.downloadstring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.downloadstring.R;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private EditText et;
    private String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        tv = (TextView) findViewById(R.id.textView);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        text = et.getText().toString();
        new GetData(text,tv).execute();

    }
}

