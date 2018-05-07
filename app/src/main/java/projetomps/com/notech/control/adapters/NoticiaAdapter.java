package projetomps.com.notech.control.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import projetomps.com.notech.R;
import projetomps.com.notech.model.Noticia;

public class NoticiaAdapter extends RecyclerView.Adapter<NoticiaAdapter.MyViewHolder> {

    private List<Noticia> noticias;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagem;
        public TextView titulo;
        public TextView autor;
        public TextView data;
        public TextView descricao;

        public MyViewHolder(final View view) {
            super(view);
            imagem = view.findViewById(R.id.imagem);
            titulo = view.findViewById(R.id.titulo);
            autor = view.findViewById(R.id.autor);
            data = view.findViewById(R.id.data);
            descricao = view.findViewById(R.id.descricao);
        }
    }

    public NoticiaAdapter(List<Noticia> noticias, Context context) {
        this.noticias = noticias;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.noticia_card, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        NoticiaAdapter.MyViewHolder viewHolder = holder;
        Noticia noticia = noticias.get(position);

        //Nao baixa?
        //TODO:descobrir porque nao baixa a imagem
        Picasso.get().load(noticia.getUrlImagem()).into(viewHolder.imagem);
        //funciona mas nao é o que eu quero
        //Picasso.get().load(R.drawable.mcafee_do_mit).into(viewHolder.imagem);
        viewHolder.titulo.setText(noticia.getTitulo());
        viewHolder.autor.setText(noticia.getAutor());
        viewHolder.data.setText(noticia.getData());
        viewHolder.descricao.setText(noticia.getDescricao());
    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }
}
