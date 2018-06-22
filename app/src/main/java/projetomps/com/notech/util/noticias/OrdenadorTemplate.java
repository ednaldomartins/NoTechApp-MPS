package projetomps.com.notech.util.noticias;

import java.util.ArrayList;

import projetomps.com.notech.model.Comentario;

public abstract class OrdenadorTemplate {

    public abstract boolean ordena(Comentario comentario1, Comentario comentario2);

    public ArrayList<Comentario> ordenarComentario(ArrayList<Comentario> listaDeComentarios)
    {
        ArrayList<Comentario> novaListaDeComentarios = new ArrayList<Comentario>();
        for (Comentario comentario : listaDeComentarios) {
            //nova lista temporaria que sera usada para exibir
            novaListaDeComentarios.add(comentario);
        }

        for (int i = 0; i < novaListaDeComentarios.size(); i++) {
            for (int j = i; j < novaListaDeComentarios.size(); j++) {
                if (!ordena(novaListaDeComentarios.get(i), novaListaDeComentarios.get(j))) {
                    Comentario aux = novaListaDeComentarios.get(j);
                    novaListaDeComentarios.set(j, novaListaDeComentarios.get(i));
                    novaListaDeComentarios.set(i, aux);
                }
            }
        }

        return novaListaDeComentarios;
    }
}
