package com.example.sander.splashnavigation;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable(){
            @Override

            public void run(){ // Meetod run
                Intent homeIntent = new Intent(MainActivity.this, com.example.sander.splashnavigation.HomeActivity.class); // Muudab HomeAcitvity ekraani MainAcivity vastu
                startActivity(homeIntent); // Alustatakse ekraani muutmist
                finish(); // Lõpetab
            }
        },SPLASH_TIME_OUT); // SPLASH_TIME_OUT läheb tööle
    }
}
