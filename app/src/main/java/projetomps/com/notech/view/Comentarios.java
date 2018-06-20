package projetomps.com.notech.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import projetomps.com.notech.R;
import projetomps.com.notech.data.local.ComentarioDAO;

public class Comentarios extends AppCompatActivity {
    ComentarioDAO comentarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios);
        //comentarioDAO.insert();

    }
}
