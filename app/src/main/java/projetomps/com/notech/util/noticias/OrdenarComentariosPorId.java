package projetomps.com.notech.util.noticias;

import projetomps.com.notech.model.Comentario;

public class OrdenarComentariosPorId extends OrdenadorTemplate
{
    @Override
    public boolean ordena(Comentario comentario1, Comentario comentario2)
    {
        if (comentario1.getId() > comentario2.getId()) {
            return true;
        } else {
            return false;
        }
    }

}
