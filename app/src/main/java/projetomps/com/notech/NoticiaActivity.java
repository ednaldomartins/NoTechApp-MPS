package projetomps.com.notech;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NoticiaActivity extends AppCompatActivity {

    private ImageView imagem;
    private TextView titulo, data, texto, autor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            //recuperando a imagem
            byte[] byteArray = extras.getByteArray("imagem");
            Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            imagem = (ImageView) findViewById(R.id.noticiaImagemId);
            imagem.setImageBitmap(bmp);

            //recuperando o titulo
            titulo = (TextView) findViewById(R.id.noticiaTituloId);
            titulo.setText( extras.getString("titulo") );

            //recuperando o texto
            texto = (TextView) findViewById(R.id.noticiaTextoId);
            texto.setText( extras.getString("texto") );

            //recuperando o autor
            autor = (TextView) findViewById(R.id.noticiaAutorId);
            autor.setText(extras.getString("autor"));

            //recuperando a data
            data = (TextView) findViewById(R.id.noticiaDataId);
            data.setText(extras.getString("data"));
        }

    }
}
