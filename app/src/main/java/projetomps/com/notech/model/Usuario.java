package projetomps.com.notech.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Entity(tableName = "usuario_tabela")
public class Usuario implements Serializable {
    @PrimaryKey @NonNull private String nome;
    private String email;
    @TypeConverters(Converters.class) private ArrayList<Integer> noticiasFavoritas;
    @TypeConverters(Converters.class) private ArrayList<Integer> noticiasMarcadas;
    @TypeConverters(Converters.class) private Date horarioLembrete;

    public Usuario(String nome, String email, ArrayList<Integer> noticiasFavoritas, ArrayList<Integer> noticiasMarcadas, Date horarioLembrete) {
        this.nome = nome;
        this.email = email;
        this.noticiasFavoritas = noticiasFavoritas;
        this.noticiasMarcadas = noticiasMarcadas;
        this.horarioLembrete = horarioLembrete;
    }


    //GETs
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Integer> getNoticiasFavoritas() {
        return noticiasFavoritas;
    }

    public ArrayList<Integer> getNoticiasMarcadas() {
        return noticiasMarcadas;
    }

    public Date getHorarioLembrete() {
        return horarioLembrete;
    }



    //SETs
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNoticiasFavoritas(ArrayList<Integer> noticiasFavoritas) {
        this.noticiasFavoritas = noticiasFavoritas;
    }

    public void setNoticiasMarcadas(ArrayList<Integer> noticiasMarcadas) {
        this.noticiasMarcadas = noticiasMarcadas;
    }

    public void setHorarioLembrete(Date horarioLembrete) {
        this.horarioLembrete = horarioLembrete;
    }
}