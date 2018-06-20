package projetomps.com.notech.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import projetomps.com.notech.R;
import projetomps.com.notech.control.NoticiasController;

public class SplashScreenActivity extends AppCompatActivity {

    private final int timer = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handle = new Handler();

        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(projetomps.com.notech.view.SplashScreenActivity.this, NoticiasController.class));
                finish();
            }

        }, timer);

    }
}
