package projetomps.com.notech.control;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import projetomps.com.notech.model.Usuario;

@Dao
public interface UsuarioDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Usuario usuario);

    @Query("DELETE FROM usuario_tabela")
    void apagar();

    @Query("SELECT * FROM usuario_tabela WHERE nome LIKE :nome")
    Usuario getUsuario(String nome);
}
