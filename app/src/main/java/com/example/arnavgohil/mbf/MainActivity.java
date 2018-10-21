package com.example.arnavgohil.mbf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arnavgohil.massbunkfinal.R;

public class MainActivity extends AppCompatActivity {

    EditText ida;
    EditText pass;
    static String a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void butt(View view) {
        ida = (EditText) findViewById(R.id.id);
        pass = (EditText) findViewById(R.id.pass);
        a = ida.getText().toString();
        b = pass.getText().toString();

        if (a.equals(b)) {
            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, CameraActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "Invalid ID or Password", Toast.LENGTH_LONG).show();
        }
    }
}
