package projetomps.com.notech.control;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import projetomps.com.notech.model.Comentario;

@Dao
public interface ComentarioDAO {
    @Insert
    void insert(Comentario comentario);

    @Query("SELECT * FROM comentario_table WHERE comentario_table.id = comentario_table.respostaId")
    LiveData<List<Comentario>> getRespostas();

    @Query("SELECT * FROM comentario_table WHERE comentario_table.paiId = :id")
    LiveData<List<Comentario>> getRespostasPorPai(int id);
}
