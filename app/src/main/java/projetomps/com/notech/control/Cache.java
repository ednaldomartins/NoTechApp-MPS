package projetomps.com.notech.control;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import projetomps.com.notech.model.Comentario;
import projetomps.com.notech.model.Usuario;

//SINGLETON
@Database(entities = {Comentario.class, Usuario.class}, version = 1)
public abstract class Cache extends RoomDatabase {
    private static final String DB_NAME = "cache.db";
    private static volatile Cache instancia= null;

    public static synchronized Cache getInstancia(Context context){
        if(instancia == null)
            instancia = cria(context);
        return instancia;
    }

    private static Cache cria(final Context context) {
        return Room.databaseBuilder(context, Cache.class, DB_NAME).build();
    }

    public abstract UsuarioDAO getUsuarioDao();
    public abstract ComentarioDAO getComentarioDao();
}
