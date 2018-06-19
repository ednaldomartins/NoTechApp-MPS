package projetomps.com.notech.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import static android.arch.persistence.room.ForeignKey.CASCADE;
import android.support.v4.widget.CircularProgressDrawable;

import java.io.Serializable;
import java.util.ArrayList;

@Entity(tableName = "comentario_table")
public class Comentario implements Serializable {
    @PrimaryKey @ColumnInfo(name = "id") private int comentarioId;
    private String comentario;
    private String usuarioNome;
    private int numeroDeCurtidas;

    private int paiId;
    private int respostaId;

    public Comentario(int id, String comentario, String usuarioNome, int numeroDeCurtidas, int paiId, int respostaId) {
        this.comentarioId = id;
        this.usuarioNome = usuarioNome;
        this.comentario = comentario;
        this.numeroDeCurtidas = numeroDeCurtidas;
        this.paiId = paiId;
        this.respostaId = respostaId;
    }


    //GETs
    public int getId() {
        return comentarioId;
    }

    public String getComentario() {
        return comentario;
    }

    public int getNumeroDeCurtidas() {
        return numeroDeCurtidas;
    }

    public int getComentarioId() {
        return comentarioId;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public int getPaiId() {
        return paiId;
    }

    public int getRespostaId() {
        return respostaId;
    }

    //SETs
    public void setComentarioId(int comentarioId) {
        this.comentarioId = comentarioId;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public void setNumeroDeCurtidas(int numeroDeCurtidas) {
        this.numeroDeCurtidas = numeroDeCurtidas;
    }

    public void setPaiId(int paiId) {
        this.paiId = paiId;
    }

    public void setRespostaId(int respostaId) {
        this.respostaId = respostaId;
    }
}
