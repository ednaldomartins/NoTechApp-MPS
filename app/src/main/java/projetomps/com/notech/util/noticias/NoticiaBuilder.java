package projetomps.com.notech.util.noticias;

import org.json.JSONException;
import org.json.JSONObject;

import projetomps.com.notech.model.Noticia;

public class NoticiaBuilder {
    protected NoticiaBuilderAbstract montador;

    public NoticiaBuilder(NoticiaBuilderAbstract montador) {
        this.montador = montador;
    }

    public void build(){
        montador.buildFonteId();
        montador.buildFonteNome();
        montador.buildAutor();
        montador.buildTitulo();
        montador.buildDescricao();
        montador.buildUrl();
        montador.buildUrlImagem();
        montador.buildData();
        montador.buildComentarios();
    }

    public void buildFromJson(JSONObject json) throws JSONException {
        montador.buildFromJson(json);
    }

    public Noticia getNoticia(){
        return montador.getNoticia();
    }
}
