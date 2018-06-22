package projetomps.com.notech.model;

import projetomps.com.notech.util.command.BancoFacadeCommand;

public class CommandMemento {
    protected BancoFacadeCommand estadoCommand;

    public CommandMemento(BancoFacadeCommand command) {
        estadoCommand = command;
    }

    public BancoFacadeCommand getEstadoSalvo() {
        return estadoCommand;
    }
}
