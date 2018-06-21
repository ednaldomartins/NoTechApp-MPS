package projetomps.com.notech.model;

import java.util.ArrayList;

public class ComentarioCareTaker {
    protected ArrayList<ComentarioMemento> estadosComentario;

    public ComentarioCareTaker () {
        estadosComentario = new ArrayList<ComentarioMemento>();
    }

    public void adcionarMemento (ComentarioMemento comentarioMemento) {
        estadosComentario.add(comentarioMemento);
    }

    //recuperar ultimo comentario feito se exisitir
    public ComentarioMemento getUltimoComentarioSalvo() {
        if(estadosComentario.size() > 0) {
            ComentarioMemento ultimoComentario = estadosComentario.get(estadosComentario.size() - 1);
            estadosComentario.remove(estadosComentario.size() - 1);
            return ultimoComentario;
        }
        else {
            /*
            no nosso caso aqui o ideal é apagar o comentario, ou retornar uma mensagem para o
            usuario dizendo que não há uma versão anterior do seu comentario.
             */
            return new ComentarioMemento(" ");
        }
    }
}
