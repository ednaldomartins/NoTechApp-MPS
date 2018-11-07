package projetomps.com.notech.util.usuario;

import java.util.ArrayList;
import java.util.Calendar;

import projetomps.com.notech.model.Usuario;

public class UsuarioMock implements FabricaUsuario {
    @Override
    public Usuario criaUsuario() {
        return new Usuario("Alef", "AlefESE", "123");
    }
}
