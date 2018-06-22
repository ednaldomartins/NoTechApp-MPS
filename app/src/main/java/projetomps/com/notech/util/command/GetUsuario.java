package projetomps.com.notech.util.command;

import android.content.Context;

import projetomps.com.notech.data.BancoFacade;
import projetomps.com.notech.data.local.Cache;

public class GetUsuario implements BancoFacadeCommand{

    private Cache cache;
    private String nome;
    private BancoFacade.OnSuccessUsuarioListener callback;

    public GetUsuario(final String nome, final Context context) {
        this.nome = nome;
        this.cache = Cache.getInstancia(context);
    }

    @Override
    public void commit(BancoFacade.OnSuccessNoticiaListener callback) {

    }

    @Override
    public void commit(BancoFacade.OnSuccessUsuarioListener callback) {
        this.callback = callback;
    }

    @Override
    public void push() {
        callback.onSuccessUsuario(cache.getUsuarioDao().getUsuario(nome));
    }
}
