package projetomps.com.notech.util.noticias;

import org.json.JSONException;
import org.json.JSONObject;

public class NoticiaJobsBuilder extends NoticiaBuilderAbstract {
    @Override
    public void buildFonteId() {

    }

    @Override
    public void buildFonteNome() {

    }

    @Override
    public void buildAutor() {

    }

    @Override
    public void buildTitulo() {

    }

    @Override
    public void buildDescricao() {

    }

    @Override
    public void buildUrl() {

    }

    @Override
    public void buildUrlImagem() {

    }

    @Override
    public void buildData() {

    }

    @Override
    public void buildComentarios() {

    }

    @Override
    public void buildFromJson(JSONObject artigo) throws JSONException {
        JSONObject fonte = null;

        fonte = artigo.getJSONObject("source");

        noticia.setFonteId(fonte.getString("id"));
        noticia.setFonteNome(fonte.getString("name"));

        noticia.setAutor(artigo.getString("author"));
        noticia.setTitulo(artigo.getString("title"));
        noticia.setDescricao(artigo.getString("description"));
        noticia.setUrl(artigo.getString("url"));
        noticia.setUrlImagem(artigo.getString("urlToImage"));
        noticia.setData(artigo.getString("publishedAt"));
    }
}
