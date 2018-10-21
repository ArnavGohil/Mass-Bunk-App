package com.example.arnavgohil.mbf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.arnavgohil.massbunkfinal.R;

public class CameraActivity extends AppCompatActivity {
    TextView textView;
    static boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);


        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2BasicFragment.newInstance())
                    .commit();
        }
    }

    public void click(View view)
    {
        Intent i = new Intent(this, Third.class);
        startActivity(i);
    }


}

