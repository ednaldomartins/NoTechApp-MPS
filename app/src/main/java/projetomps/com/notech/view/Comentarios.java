package projetomps.com.notech.view;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import projetomps.com.notech.R;
import projetomps.com.notech.data.local.ComentarioDAO;
import projetomps.com.notech.model.Comentario;

public class Comentarios extends AppCompatActivity {
    private ComentarioDAO comentarioDAO;
    private ListView listaDeComentarios;
    private ArrayAdapter<String> itensAdaptador;
    private ArrayList<Comentario> Comentarios;
    private AlertDialog.Builder dialog;

    private EditText comentarioDigitado;
    private Button botaoVoltar, botaoComentar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios);

        //findView
        listaDeComentarios = (ListView) findViewById(R.id.comentariosListView);
        comentarioDigitado = (EditText) findViewById(R.id.comentariosDigitarComentario);
        botaoVoltar = (Button) findViewById(R.id.comentariosBotaoVoltar);
        botaoComentar = (Button) findViewById(R.id.comentarioBotaoComentar);

        //criacao de acoes nos comentario atraves da acao de pressionar a tela
        listaDeComentarios.setLongClickable(true);
        listaDeComentarios.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                // esse tipo de dialog sera usado apenas para teste
                dialog = new AlertDialog.Builder(Comentarios.this);
                dialog.setTitle("Comentário");
                dialog.setMessage("Escolha abaixo o que deseja fazer (toque fora para cancelar) :");
                //escolhendo icone para o popup
                dialog.setIcon(android.R.drawable.ic_menu_edit);

                //positive como Editar
                dialog.setPositiveButton("Editar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                //Negative como Deletar
                dialog.setNegativeButton("Deletar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                dialog.create();
                dialog.show();

                return true;
            }
        });

    }

    private void carregarComentarios () {

    }

    private void salvarComentario(Comentario comentario) {
        comentarioDAO.insert(comentario);
        Toast.makeText(Comentarios.this, "comentário publicado", Toast.LENGTH_LONG).show();
    }

    private void editarComentario(Comentario comentario) {
        comentarioDAO.delete(comentario);
        Toast.makeText(Comentarios.this, "comentario editado", Toast.LENGTH_LONG).show();
    }

    private void removerComentario(Comentario comentario) {
        comentarioDAO.delete(comentario);
        Toast.makeText(Comentarios.this, "comentario removido", Toast.LENGTH_LONG).show();
    }
}
