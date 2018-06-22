package projetomps.com.notech.data.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import projetomps.com.notech.model.Comentario;

@Dao
public interface ComentarioDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Comentario comentario);

    @Update
    void update(Comentario comentario);

    @Delete
    void delete(Comentario comentario);

    @Query("SELECT * FROM comentario_table WHERE comentario_table.id = :id")
    Comentario getComentarioById(int id);

    @Query("SELECT * FROM comentario_table WHERE comentario_table.fonteId = :id")
    List<Comentario> getComentariosByFonte(int id);

}
