package projetomps.com.notech.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
    private String nome;
    private String email;
    private ArrayList<Noticia> noticiasFavorita;
    private ArrayList<Noticia> noticiasMarcada;
    private int horarioLembrete;

    public Usuario(String nome, String email, ArrayList<Noticia> noticiasFavorita, ArrayList<Noticia> noticiasMarcada, int horarioLembrete) {
        this.nome = nome;
        this.email = email;
        this.noticiasFavorita = noticiasFavorita;
        this.noticiasMarcada = noticiasMarcada;
        this.horarioLembrete = horarioLembrete;
    }


    //GETs
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Noticia> getNoticiasFavorita() {
        return noticiasFavorita;
    }

    public ArrayList<Noticia> getNoticiasMarcada() {
        return noticiasMarcada;
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

    public void setNoticiasFavorita(ArrayList<Noticia> noticiasFavorita) {
        this.noticiasFavorita = noticiasFavorita;
    }

    public void setNoticiasMarcada(ArrayList<Noticia> noticiasMarcada) {
        this.noticiasMarcada = noticiasMarcada;
    }

    public void setHorarioLembrete(int horarioLembrete) {
        this.horarioLembrete = horarioLembrete;
    }
}