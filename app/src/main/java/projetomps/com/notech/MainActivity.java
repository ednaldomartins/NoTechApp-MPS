package projetomps.com.notech;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private ImageView imagemView;
    private TextView tituloView, textoView, autorView, dataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tituloView = (TextView) findViewById(R.id.mainTitulo);
        imagemView = (ImageView) findViewById(R.id.mainImagem);
        textoView = (TextView) findViewById(R.id.mainTexto);
        autorView = (TextView) findViewById(R.id.mainAutor);
        dataView = (TextView) findViewById(R.id.mainData);

        /*
            como as views estão separadas todas elas devem chamar o metodo abrirNoticia
            usando cardView ou similar nao serah preciso.
         */

        imagemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirNoticia();
            }
        });

        tituloView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirNoticia();
            }
        });

        textoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirNoticia();
            }
        });

        autorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirNoticia();
            }
        });

        dataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirNoticia();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int opt = item.getItemId();

        if (opt == R.id.action_categorias) {
            startActivity(new Intent(MainActivity.this, CategoriasActivity.class));
        }

        if (opt == R.id.action_favoritos) {
            //startActivity(new Intent(MainActivity.this, CategoriasActivity.class));
        }

        if (opt == R.id.action_marcador) {
            //startActivity(new Intent(MainActivity.this, CategoriasActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }


    public void abrirNoticia () {

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.mcafee_do_mit);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] imagemMateria = stream.toByteArray();

        Intent intent = new Intent(MainActivity.this, NoticiaActivity.class);
        intent.putExtra("imagem", imagemMateria );
        intent.putExtra("titulo", tituloView.getText().toString() );
        intent.putExtra("texto", textoView.getText().toString() );
        intent.putExtra("autor", autorView.getText().toString() );
        intent.putExtra("data", dataView.getText().toString() );
        startActivity(intent);

    }
}
