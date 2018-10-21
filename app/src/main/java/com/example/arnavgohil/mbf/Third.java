package com.example.arnavgohil.mbf;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arnavgohil.massbunkfinal.R;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import java.io.File;

import static org.opencv.core.Core.absdiff;


public class Third extends AppCompatActivity {

    public static boolean imgch;
    TextView tv;
    File imgFile,file;
    Bitmap myBitmap,savedBitmap;
    Uri img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tv=(TextView) findViewById(R.id.textview);

         imgFile = new  File(String.valueOf(Camera2BasicFragment.mFile));

        if(imgFile.exists()){

            myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

            ImageView myImage = (ImageView) findViewById(R.id.imageView);

            myImage.setImageBitmap(myBitmap);

            tv.setText(Camera2BasicFragment.currentTime.toString());

        }

        savedBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.photo);

        imgch=isImgch(myBitmap,savedBitmap);

    }

    public void cl(View view)
    {
        if(imgch==true)
        {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("*/*");
            intent.putExtra(Intent.EXTRA_EMAIL, "arnav.gohil04@gmail.com");
            intent.putExtra(Intent.EXTRA_SUBJECT, MainActivity.a+" PRESENT");
            intent.putExtra(Intent.EXTRA_TEXT, "PRESENT \n batch "+MainActivity.a+" at "+Camera2BasicFragment.currentTime);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
        else
        {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("*/*");
            intent.putExtra(Intent.EXTRA_EMAIL, "arnav.gohil04@gmail.com");

            intent.putExtra(Intent.EXTRA_SUBJECT, "MASS BUNK");
            intent.putExtra(Intent.EXTRA_TEXT, "MASS BUNK \n batch "+MainActivity.a+" at "+Camera2BasicFragment.currentTime);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }

    public boolean isImgch(Bitmap img1,Bitmap img2)
    {
        int width = img1.getWidth();
        int height = img2.getHeight();

        Mat imgToProcess1 = new Mat(height, width, CvType.CV_8UC4);
        Mat  imgToProcess2 = new Mat(height, width, CvType.CV_8UC4);
        Mat  imgToProcess = new Mat(height, width, CvType.CV_8UC4);

        Utils.bitmapToMat(img1, imgToProcess1);
        Utils.bitmapToMat(img2, imgToProcess1);
        absdiff(imgToProcess1, imgToProcess2, imgToProcess);
        if(imgToProcess==null)
        {
            return true;
        }
        else
        {
           return false;
        }
    }
}
