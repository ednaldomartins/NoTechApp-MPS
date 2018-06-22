package projetomps.com.notech.data.remote;

import android.support.annotation.NonNull;
import android.util.Log;

import com.loopj.android.http.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Cliente do servidor de noticias
 */
public class NoticiaClient {
    private static final String API_BASE_URL = "http://newsapi.org/v2/";
    private static String API_KEY;
    private AsyncHttpClient cliente;

    /**
     * Contrutor com chave da api google news
     * @param api_key Chave da api google news
     */
    public NoticiaClient(final String api_key) {
        cliente = new AsyncHttpClient();
        API_KEY = api_key;
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
            cliente.get(URLEncoder.encode(url, "utf-8"), handler);
        }  catch (UnsupportedEncodingException e) {
            //TODO: Tratar excessao
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
            String url = getApiUrl("top-headlines?source="+source+"&apiKey="+API_KEY);
            cliente.get(URLEncoder.encode(url, "utf-8"), handler);
        } catch (UnsupportedEncodingException e) {
            //TODO: Tratar excessao
            e.printStackTrace();
        }
    }
}
