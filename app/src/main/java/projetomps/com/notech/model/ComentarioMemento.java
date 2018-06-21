package projetomps.com.notech.model;

public class ComentarioMemento {
    protected String estadoComentario;

    public ComentarioMemento (String estadoComentario) {
        this.estadoComentario = estadoComentario;
    }

    public String comentarioSalvo () {
        return this.estadoComentario;
    }
}
