package projetomps.com.notech.util.noticias;

import projetomps.com.notech.model.Comentario;

public class OrdenarComentariosPorCurtida extends OrdenadorTemplate{
    @Override
    public boolean ordena(Comentario comentario1, Comentario comentario2) {
        if(comentario1.getNumeroDeCurtidas() > comentario2.getNumeroDeCurtidas()) {
            return true;
        }
        else {
            return false;
        }
    }
}
