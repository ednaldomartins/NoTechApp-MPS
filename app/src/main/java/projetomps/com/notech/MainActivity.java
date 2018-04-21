package projetomps.com.notech;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private CardView cardNoticia;
    private ConstraintLayout cardLayout;
    private ImageView capaNoticia;
    private TextView tituloNoticia, textoNoticia, autorNoticia, dataNoticia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardNoticia = (CardView) findViewById(R.id.mainCardView);
        cardLayout = (ConstraintLayout) findViewById(R.id.mainCardLayout);

        tituloNoticia = (TextView) findViewById(R.id.mainTitulo);
        capaNoticia = (ImageView) findViewById(R.id.mainImagem);
        textoNoticia = (TextView) findViewById(R.id.mainTexto);
        autorNoticia = (TextView) findViewById(R.id.mainAutor);
        dataNoticia = (TextView) findViewById(R.id.mainData);

        /*
            como as views estão separadas todas ela
        if (opt == R.id.action_cas devem chamar o metodo abrirNoticia
            usando cardView ou similar nao serah preciso.
         */

        //testando com cardView
        cardNoticia.setOnClickListener(new View.OnClickListener() {
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
        intent.putExtra("titulo", tituloNoticia.getText().toString() );
        intent.putExtra("texto", textoNoticia.getText().toString() );
        intent.putExtra("autor", autorNoticia.getText().toString() );
        intent.putExtra("data", dataNoticia.getText().toString() );
        startActivity(intent);

    }
}
