package projetomps.com.notech.util.usuario;

import java.util.ArrayList;
import java.util.Calendar;

import projetomps.com.notech.model.Usuario;

public class UsuarioMock implements FabricaUsuario {
    @Override
    public Usuario criaUsuario() {
        return new Usuario(
                "alef",
                "alef_berg@hotmail.com.br",
                new ArrayList<Integer>(),
                new ArrayList<Integer>(),
                Calendar.getInstance().getTime());
    }
}
