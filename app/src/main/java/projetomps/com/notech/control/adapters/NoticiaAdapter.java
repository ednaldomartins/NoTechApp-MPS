package projetomps.com.notech.control.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import projetomps.com.notech.R;
import projetomps.com.notech.model.Noticia;
import projetomps.com.notech.util.noticias.NoticiaBuilder;
import projetomps.com.notech.util.noticias.NoticiaJobsBuilder;

public class NoticiaAdapter extends RecyclerView.Adapter<NoticiaAdapter.MyViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Noticia item);
    }

    private final List<Noticia> noticias;
    private final OnItemClickListener listener;

    public NoticiaAdapter(final List<Noticia> noticias, OnItemClickListener listener) {
        this.noticias = noticias;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_frag, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Log.d("NoticiaAdapter", "Element "+position+" set.");
        // TODO: usar client

        holder.bind(noticias.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cv;
        public ImageView imagem;
        public TextView titulo;
        public TextView autor;
        public TextView data;
        public TextView descricao;

        public MyViewHolder(final View view) {
            super(view);
            cv = (CardView)view.findViewById(R.id.cardView);
            imagem = view.findViewById(R.id.imagem);
            titulo = view.findViewById(R.id.titulo);
            autor = view.findViewById(R.id.autor);
            data = view.findViewById(R.id.data);
            descricao = view.findViewById(R.id.descricao);
        }

        public void bind(final Noticia noticia, final OnItemClickListener listener) {
            //Nao baixa?
            //TODO:descobrir porque nao baixa a imagem
            //Picasso.get().load(noticias.get(position).getUrlImagem()).into(viewHolder.imagem);
            //funciona mas nao é o que eu quero
            Picasso.get().load(R.drawable.mcafee_do_mit).into(imagem);
            titulo.setText(noticia.getTitulo());
            autor.setText(noticia.getAutor());
            data.setText(noticia.getData());
            descricao.setText(noticia.getDescricao());

            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(noticia);
                }
            });
        }
    }
}
