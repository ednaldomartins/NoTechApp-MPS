package projetomps.com.notech.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.loopj.android.http.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import projetomps.com.notech.data.local.Cache;
import projetomps.com.notech.data.remote.NoticiaClient;
import projetomps.com.notech.model.Comentario;
import projetomps.com.notech.model.Noticia;

/**
 * Fachada do banco de dados
 */
public class BancoFacade {

    public interface OnSuccessListener{
        void onSuccess(List<Noticia> noticias);
    }

    protected Cache cache;
    protected NoticiaClient client;
    protected OnSuccessListener callback;

    public void inicializarBanco(@NonNull final Context context, @NonNull final String api_key) {
        cache = Cache.getInstancia(context);
        client = new NoticiaClient(api_key);
    }

    public void setCallbackListener(OnSuccessListener callback) {
        this.callback = callback;
    }

    public void getNoticias(@NonNull final String query) {
        client.getNoticias(query, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    callback.onSuccess(Noticia.fromJson(response.getJSONArray("articles")));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable t, JSONObject response){
                Log.d(String.valueOf(statusCode), response.toString());
            }
        });
    }

    public void getNoticiasHeadlines(@NonNull final String source) {
        client.getNoticiasHeadlines(source, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    callback.onSuccess(Noticia.fromJson(response.getJSONArray("articles")));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable t, JSONObject response){
                Log.d(String.valueOf(statusCode), response.toString());
            }
        });
    }

    public List<Comentario> getComentariosByFonte(@NonNull int id) {
        return cache.getComentarioDao().getComentariosByFonte(id);
    }

    public void postComentario(@NonNull Comentario comentario) {
        cache.getComentarioDao().insert(comentario);
    }
}
