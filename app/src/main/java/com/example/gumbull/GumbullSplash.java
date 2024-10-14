package com.example.gumbull;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GumbullSplash extends AppCompatActivity {
    private ImageView im1,im2,im3,im4,im5,im6,im7,im8,im9,im10,im11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        // Ajustement pour la gestion des insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Liaison des vues avec leurs IDs respectifs
        im1 = findViewById(R.id.im1);
        im2 = findViewById(R.id.im2);
        im3 = findViewById(R.id.im3);
        im4 = findViewById(R.id.im4);
        im5 = findViewById(R.id.im5);
        im6 = findViewById(R.id.im6);
        im7 = findViewById(R.id.im7);
        im8 = findViewById(R.id.im8);
        im9 = findViewById(R.id.im9);
        im10 = findViewById(R.id.im10);
        im11 = findViewById(R.id.im11);



        // Animations pour chaque ImageView
        im1.animate().rotation(360f).setDuration(7000);
        im1.animate().scaleX(0.5f).scaleY(0.5f).setDuration(8500);
        im1.animate().translationYBy(1000f).setDuration(7000);
        im1.animate().alpha(0f).setDuration(9500);

        im2.animate().rotation(360f).setDuration(7000);
        im2.animate().scaleX(0.5f).scaleY(0.5f).setDuration(8500);
        im2.animate().translationYBy(1000f).setDuration(7000);
        im2.animate().alpha(0f).setDuration(9500);


        im3.animate().rotation(360f).setDuration(7000);
        im3.animate().scaleX(0.5f).scaleY(0.5f).setDuration(8500);
        im3.animate().translationYBy(1000f).setDuration(7000);
        im3.animate().alpha(0f).setDuration(9500);

        im4.animate().rotation(360f).setDuration(7000);
        im4.animate().scaleX(0.5f).scaleY(0.5f).setDuration(8500);
        im4.animate().translationYBy(1000f).setDuration(7000);
        im4.animate().alpha(0f).setDuration(9500);

        im5.animate().rotation(360f).setDuration(7000);
        im5.animate().scaleX(0.5f).scaleY(0.5f).setDuration(8500);
        im5.animate().translationYBy(1000f).setDuration(7000);
        im5.animate().alpha(0f).setDuration(9500);

        im6.animate().rotation(360f).setDuration(7000);
        im6.animate().scaleX(0.5f).scaleY(0.5f).setDuration(8500);
        im6.animate().translationYBy(1000f).setDuration(7000);
        im6.animate().alpha(0f).setDuration(9500);

        im7.animate().rotation(360f).setDuration(7000);
        im7.animate().scaleX(0.5f).scaleY(0.5f).setDuration(8500);
        im7.animate().translationYBy(1000f).setDuration(7000);
        im7.animate().alpha(0f).setDuration(9500);

        im8.animate().rotation(360f).setDuration(7000);
        im8.animate().scaleX(0.5f).scaleY(0.5f).setDuration(8500);
        im8.animate().translationYBy(1000f).setDuration(7000);
        im8.animate().alpha(0f).setDuration(9500);

        im9.animate().rotation(360f).setDuration(7000);
        im9.animate().scaleX(0.5f).scaleY(0.5f).setDuration(8500);
        im9.animate().translationYBy(1000f).setDuration(7000);
        im9.animate().alpha(0f).setDuration(9500);

        im10.animate().rotation(360f).setDuration(7000);
        im10.animate().scaleX(0.5f).scaleY(0.5f).setDuration(8500);
        im10.animate().translationYBy(1000f).setDuration(7000);
        im10.animate().alpha(0f).setDuration(9500);

        im11.animate().rotation(360f).setDuration(7000);
        im11.animate().scaleX(0.5f).scaleY(0.5f).setDuration(8500);
        im11.animate().translationYBy(1000f).setDuration(7000);
        im11.animate().alpha(0f).setDuration(9500);

        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(10000);
                    Intent intent = new Intent(GumbullSplash.this, GumbullActivity.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}
