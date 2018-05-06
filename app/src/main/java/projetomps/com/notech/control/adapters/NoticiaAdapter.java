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

public class NoticiaAdapter extends RecyclerView.Adapter<NoticiaAdapter.ViewHolder> {

    private List<Noticia> noticias;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagem;
        public TextView titulo;
        public TextView autor;
        public TextView data;
        public TextView texto;

        public ViewHolder(View view) {
            super(view);
            imagem = view.findViewById(R.id.mainImagem);
            titulo = view.findViewById(R.id.mainTitulo);
            autor = view.findViewById(R.id.mainAutor);
            data = view.findViewById(R.id.mainData);
            texto = view.findViewById(R.id.mainTexto);
        }
    }

    public NoticiaAdapter(List<Noticia> noticias, Context context) {
        this.noticias = noticias;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_noticia, parent, false);

        NoticiaAdapter.ViewHolder viewHolder = new NoticiaAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NoticiaAdapter.ViewHolder viewHolder = holder;
        Noticia noticia = noticias.get(position);

        Picasso.get().load(noticia.getUrl()).into(viewHolder.imagem);
        viewHolder.titulo.setText(noticia.getTitulo());
        viewHolder.autor.setText(noticia.getAutor());
        viewHolder.data.setText(noticia.getData());
        viewHolder.texto.setText(noticia.getTexto());
    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }
}
