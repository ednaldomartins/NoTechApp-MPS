package projetomps.com.notech.data.remote;

import android.util.Log;

import com.loopj.android.http.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import projetomps.com.notech.model.Noticia;

/**
 * Cliente do servidor de noticias
 */
public class NoticiaClient {
    private static final String API_BASE_URL = "http://newsapi.org/v2/";
    private static String API_KEY;
    private static NoticiaClient instancia = null;
    private static AsyncHttpClient client = null;

    private NoticiaClient(){
        client = new AsyncHttpClient();
    }

    public static synchronized NoticiaClient getInstance(final String api_key) {
        if(instancia == null)
            instancia = cria(api_key);
        return instancia;
    }

    private static NoticiaClient cria(final String api_key){
        API_KEY = api_key;
        return new NoticiaClient();
    }

    /**
     * Metodo para resgatar url completo BASE + urlRelativo
     * @param urlRelativo
     * @return Url completo
     */
    private String getApiUrl(String urlRelativo) {
        return API_BASE_URL + urlRelativo;
    }

    /**
     * Metodo para resgatar noticias de qualquer fonte
     * @param query assunto
     * @param handler handler http
     */
    public void getNoticias(final String query, JsonHttpResponseHandler handler) {
        try {
            String url = getApiUrl("everything?q="+query+"&apiKey="+API_KEY);
            client.get(URLEncoder.encode(url, "utf-8"), handler);
        }  catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para resgatar top noticias de uma fonte
     * @param source fonte
     * @param handler handler http
     */
    public void getNoticiasHeadlines(final String source, JsonHttpResponseHandler handler) {
        try {
            String url = getApiUrl("top-headlines?sources="+source+"&apiKey="+API_KEY);
            client.get(URLEncoder.encode(url, "utf-8"), handler);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
