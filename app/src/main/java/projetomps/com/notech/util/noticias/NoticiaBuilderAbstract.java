package projetomps.com.notech.util.noticias;

import org.json.JSONException;
import org.json.JSONObject;

import projetomps.com.notech.model.Noticia;

public abstract class NoticiaBuilderAbstract {
    protected Noticia noticia;

    public NoticiaBuilderAbstract(){
        noticia = new Noticia();
    }

    public abstract void buildFonteId();

    public abstract void buildFonteNome();

    public abstract void buildAutor();

    public abstract void buildTitulo();

    public abstract void buildDescricao();

    public abstract void buildUrl();

    public abstract void buildUrlImagem();

    public abstract void buildData();

    public abstract void buildComentarios();

    public abstract void buildFromJson(JSONObject jsonObject) throws JSONException;

    public Noticia getNoticia(){
        return noticia;
    }
}
