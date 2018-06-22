package projetomps.com.notech.model;

import java.util.Stack;

public class CommandMementoCT {
    protected Stack<CommandMemento> estados;

    public CommandMementoCT() {
        estados = new Stack<>();
    }

    public void adicionarMemento(CommandMemento memento) {
        estados.push(memento);
    }

    public CommandMemento getUltimoEstadoSalvo() {
        if(estados.size() <= 0)
            return new CommandMemento(null);
        CommandMemento estadoSalvo = estados.pop();
        return estadoSalvo;
    }
}
