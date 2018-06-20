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

import projetomps.com.notech.data.local.Cache;
import projetomps.com.notech.data.local.UsuarioDAO;
import projetomps.com.notech.model.Usuario;

@RunWith(AndroidJUnit4.class)
public class UsuarioDAOTest {
    private Context contexto;
    private Cache cache;
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;

    @Before
    public void setup() {
        contexto = InstrumentationRegistry.getContext();
        cache = Room.inMemoryDatabaseBuilder(contexto, Cache.class).build();
        usuarioDAO = cache.getUsuarioDao();
        usuario = new Usuario("alef", "alef_berg@hotmail.com.br", null, null, null);
    }

    @After
    public void fechaBanco() {
        cache.close();
    }

    @Test
    public void insertUsuario() {
        usuarioDAO.insert(usuario);
        Usuario teste = usuarioDAO.getUsuario("alef");

        Assert.assertNotNull(teste);//teste equivalente ao get
    }

    @Test
    public void deleteUsuario() {
        usuarioDAO.insert(usuario);

        usuarioDAO.delete(usuario);

        Usuario teste = usuarioDAO.getUsuario("alef");

        Assert.assertNull(teste);
    }
}
