package projetomps.com.notech.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

@Entity(tableName = "usuario_tabela")
public class Usuario implements Serializable {
    @PrimaryKey private String nome;
    @NonNull
    private String email;
    private ArrayList<Integer> noticiasFavoritas;
    private ArrayList<Integer> noticiasMarcadas;
    private int horarioLembrete;

    public Usuario(String nome, String email, ArrayList<Integer> noticiasFavorita, ArrayList<Integer> noticiasMarcada, int horarioLembrete) {
        this.nome = nome;
        this.email = email;
        this.noticiasFavoritas = noticiasFavorita;
        this.noticiasMarcadas = noticiasMarcada;
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

    public int getHorarioLembrete() {
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

    public void setHorarioLembrete(int horarioLembrete) {
        this.horarioLembrete = horarioLembrete;
    }
}