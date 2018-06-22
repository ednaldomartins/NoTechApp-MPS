package projetomps.com.notech.util.command;

import projetomps.com.notech.data.BancoFacade;

public interface BancoFacadeCommand {
    void commit(BancoFacade.OnSuccessNoticiaListener callback);
    void commit(BancoFacade.OnSuccessUsuarioListener callback);
    void push();
}
