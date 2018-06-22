package projetomps.com.notech.data;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import projetomps.com.notech.data.local.Cache;
import projetomps.com.notech.data.remote.NoticiaClient;
import projetomps.com.notech.model.Comentario;
import projetomps.com.notech.model.CommandMemento;
import projetomps.com.notech.model.CommandMementoCT;
import projetomps.com.notech.model.Noticia;
import projetomps.com.notech.model.Usuario;
import projetomps.com.notech.util.command.BancoFacadeCommand;

/**
 * Fachada do banco de dados
 */
public class BancoFacade {

    public interface OnSuccessNoticiaListener {
        void onSuccessNoticicia(List<Noticia> noticias);
    }

    public interface OnSuccessUsuarioListener {
        void onSuccessUsuario(Usuario usuario);
    }

    private static CommandMementoCT careTaker;
    private static BancoFacadeCommand estado;

    private Cache cache;
    private NoticiaClient client;
    private static OnSuccessNoticiaListener noticiaCallback;
    private static OnSuccessUsuarioListener usuarioCallback;
    private static BancoFacade instancia = null;

    private BancoFacade(){
        careTaker = new CommandMementoCT();
    }

    public static BancoFacade getInstancia() {
        if(instancia == null)
            return new BancoFacade();
        return instancia;
    }

    public void inicializarBanco(@NonNull final Context context, @NonNull final String api_key) {
        cache = Cache.getInstancia(context);
        client = NoticiaClient.getInstance(api_key);
    }

    public void setNoticiaCallbackListener(OnSuccessNoticiaListener callback) {
        this.noticiaCallback = callback;
    }

    public void setUsuarioCallbackListener(OnSuccessUsuarioListener callback) {
        this.usuarioCallback = callback;
    }

    public void addComando(BancoFacadeCommand comando) {
        estado = comando;
        careTaker.adicionarMemento(new CommandMemento(estado));
    }

    public void executaComando() {
        estado.commit(noticiaCallback);
        estado.push();
    }

    public void desfazerComando() {
        estado = careTaker.getUltimoEstadoSalvo().getEstadoSalvo();
    }

    public List<Comentario> getComentariosByFonte(@NonNull int id) {
        return cache.getComentarioDao().getComentariosByFonte(id);
    }

    public void postComentario(@NonNull Comentario comentario) {
        cache.getComentarioDao().insert(comentario);
    }
}
