package projetomps.com.notech.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import projetomps.com.notech.R;
import projetomps.com.notech.control.adapters.NoticiaAdapter;
import projetomps.com.notech.model.Noticia;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NoticiaAdapter adapter;
    private List<Noticia> listaNoticia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsingBar();

        recyclerView = findViewById(R.id.rvNoticias);

        listaNoticia = new ArrayList<>();
        adapter = new NoticiaAdapter(listaNoticia, this);

        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        recyclerView.setAdapter(adapter);

        Picasso.get().load(R.drawable.mcafee_do_mit).into((ImageView) findViewById(R.id.backdrop));

        //testando localmente
        preparaNoticias();

    }

    private void initCollapsingBar(){
        final CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    private void preparaNoticias() {
        //TODO: procurar noticias pela API GOOGLE NEWS
        JSONObject json = null;
        try {
            json = new JSONObject(getResources().getString(R.string.json));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Noticia noticia = Noticia.fromJson(json);
        listaNoticia.add(noticia);

        adapter.notifyDataSetChanged();
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


    public void abrirNoticia (View view) {

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.mcafee_do_mit);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] imagemMateria = stream.toByteArray();

        Intent intent = new Intent(MainActivity.this, NoticiaActivity.class);
        intent.putExtra("imagem", imagemMateria );
        intent.putExtra("titulo", getResources().getString(R.string.titulo));
        intent.putExtra("texto", getResources().getString(R.string.noticia_mcafee));
        intent.putExtra("autor", getResources().getString(R.string.autor));
        intent.putExtra("data", getResources().getString(R.string.data));
        startActivity(intent);

    }
}
