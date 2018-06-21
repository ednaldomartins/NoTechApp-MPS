package projetomps.com.notech.control;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import projetomps.com.notech.R;
import projetomps.com.notech.data.local.Cache;
import projetomps.com.notech.model.Usuario;

public class SplashScreenController extends AppCompatActivity {

    private final int timer = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Cache cache = Room.databaseBuilder(this, Cache.class, "cache.db").allowMainThreadQueries().build();

        Usuario usuario = cache.getUsuarioDao().getUsuario();

        if(usuario == null) {
            Handler handle = new Handler();
            handle.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashScreenController.this, LoginController.class));
                    finish();
                }

            }, timer);
        }
    }
}
