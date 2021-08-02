package com.example.artistdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     private EditText edtAuthor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtAuthor = (EditText) findViewById(R.id.edittxtArtist);
    }

    public void GetArtist(View view) {
        try {
            Intent intent = new Intent(MainActivity.this,DisplayArtist.class);
            Bundle b = new Bundle();
            b.putString("artist_name", edtAuthor.getText().toString()); //Your id
            intent.putExtras(b); //Put your id to your next Intent
            startActivity(intent);
        }catch(Exception ex)
        {
            throw(ex);
        }
    }
}