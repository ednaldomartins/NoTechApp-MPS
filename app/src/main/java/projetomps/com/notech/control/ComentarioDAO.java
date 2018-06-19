package projetomps.com.notech.control;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import projetomps.com.notech.model.Comentario;

@Dao
public interface ComentarioDAO {
    @Insert
    void insert(Comentario comentario);

    @Update
    void update(Comentario comentario);

    @Delete
    void delete(Comentario comentario);

    @Query("SELECT * FROM comentario_table WHERE comentario_table.id = comentario_table.respostaId")
    LiveData<List<Comentario>> getRespostas();

    @Query("SELECT * FROM comentario_table WHERE comentario_table.paiId = :id")
    LiveData<List<Comentario>> getRespostasPorPai(int id);
}
