package projetomps.com.notech.model;

import android.media.Image;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

//baseado no google news
public class Noticia implements Serializable{
    private String fonteId;
    private String fonteNome;
    private String autor;
    private String titulo;
    private String descricao;
    private String url;
    private String urlImagem;
    private String data;

    public Noticia() {

    }

    public String getFonteId() {
        return fonteId;
    }

    public void setFonteId(String fonteId) {
        this.fonteId = fonteId;
    }

    public String getFonteNome() {
        return fonteNome;
    }

    public void setFonteNome(String fonteNome) {
        this.fonteNome = fonteNome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    /**
     * Parser de noticia no Json
     * @param artigo Json contendo artigo
     * @return Instancia de Noticia
     */
    public static Noticia fromJson(JSONObject artigo) {
        Noticia noticia = new Noticia();
        JSONObject fonte = null;

        try {
            fonte = artigo.getJSONObject("source");
            noticia.fonteId = fonte.getString("id");
            noticia.fonteNome = fonte.getString("name");
            noticia.autor = artigo.getString("author");
            noticia.titulo = artigo.getString("titulo");
            noticia.descricao = artigo.getString("descricao");
            noticia.url = artigo.getString("url");
            noticia.urlImagem = artigo.getString("urlToImage");
            noticia.data = artigo.getString("publishedAt");
        } catch (JSONException ex){
            ex.printStackTrace();
            return null;
        }

        return noticia;
    }

    /**
     * Parser de noticas no JsonArray
     * @param artigos Json contendo array de artigos
     * @return Lista de Noticias
     */
    public static ArrayList<Noticia> fromJson(JSONArray artigos) {
        ArrayList<Noticia> noticias = new ArrayList<Noticia>(artigos.length());

        for(int i = 0; i < artigos.length(); i++) {
            JSONObject noticiaJson = null;
            try {
                noticiaJson = artigos.getJSONObject(i);
            } catch (JSONException ex){
                ex.printStackTrace();
                continue;
            }
            Noticia noticia = Noticia.fromJson(noticiaJson);
            if(noticia != null) {
                noticias.add(noticia);
            }
        }

        return noticias;
    }

    /**
     * Metodo para recuperar texto da noticia em fonte
     * @return Texto da noticia
     */
    public String getTexto() {
        return Crawler.getNoticiaByUrl(url);
    }
}
