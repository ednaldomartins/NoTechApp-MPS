package projetomps.com.notech;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import projetomps.com.notech.data.local.Cache;
import projetomps.com.notech.data.local.ComentarioDAO;
import projetomps.com.notech.model.Comentario;


@RunWith(AndroidJUnit4.class)
public class ComentarioDAOTest {

    private Context contexto;
    private Cache cache;
    private ComentarioDAO comentarioDAO;
    private Comentario comentario;

    @Before
    public void setup() {
        contexto = InstrumentationRegistry.getContext();
        cache = Room.inMemoryDatabaseBuilder(contexto, Cache.class).build();
        comentarioDAO = cache.getComentarioDao();
        comentario = new Comentario(1, "testando", "alef", 1, 1, 1);
    }

    @After
    public void fechaBanco() {
        cache.close();
    }

    @Test
    public void insertComentario() {
        comentarioDAO.insert(comentario);
        List<Comentario> teste = comentarioDAO.getComentarioById(1);

        Assert.assertEquals(teste.isEmpty(), false);
    }

    @Test
    public void getComentario() {
        Comentario comentario1 = new Comentario(2, "testando", "alef",1,1,1);
        comentarioDAO.insert(comentario);
        comentarioDAO.insert(comentario1);

        List<Comentario> teste = comentarioDAO.getComentarios();

        Assert.assertEquals(teste.size(), 2);
    }

    @Test
    public void deleteComentarios() {
        comentarioDAO.insert(comentario);

        comentarioDAO.delete(comentario);

        List<Comentario> teste = comentarioDAO.getComentarios();

        Assert.assertEquals(teste.isEmpty(), true);
    }
}
