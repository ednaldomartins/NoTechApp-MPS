package projetomps.com.notech.net;

import android.support.annotation.NonNull;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import projetomps.com.notech.R;

//Façade
public class NoticiaClient {
    private static final String API_BASE_URL = "https://newsapi.org/v2/";
    private static String API_KEY;
    private AsyncHttpClient cliente;

    /**
     * Contrutor com chave da api google news
     * @param API_KEY Chave da api google news
     */
    public NoticiaClient(final String API_KEY) {
        cliente = new AsyncHttpClient();
        this.API_KEY = API_KEY;
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
            String url = getApiUrl("everything?q="+query+"&"+API_KEY);
            cliente.get(url + URLEncoder.encode(query, "utf-8"), handler);
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
    public void getNoticiasFonte(final String source, JsonHttpResponseHandler handler) {
        try {
            String url = getApiUrl("top-headlines?source="+source+"&"+API_KEY);
            cliente.get(url + URLEncoder.encode(source, "utf-8"), handler);
        } catch (UnsupportedEncodingException e) {
            //TODO: Tratar excessao
            e.printStackTrace();
        }
    }
}
