package projetomps.com.notech;

import java.util.ArrayList;

public class Comentario {
    private String comentario;
    private int numeroDeCurtidas;
    private ArrayList <Resposta> respostas;
    private ArrayList <Denuncia> denuncias;

    public Comentario(String comentario, int numeroDeCurtidas, ArrayList<Resposta> respostas, ArrayList<Denuncia> denuncias) {
        this.comentario = comentario;
        this.numeroDeCurtidas = numeroDeCurtidas;
        this.respostas = respostas;
        this.denuncias = denuncias;
    }


    //GETs
    public String getComentario() {
        return comentario;
    }

    public int getNumeroDeCurtidas() {
        return numeroDeCurtidas;
    }

    public ArrayList<Resposta> getRespostas() {
        return respostas;
    }

    public ArrayList<Denuncia> getDenuncias() {
        return denuncias;
    }


    //SETs
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setNumeroDeCurtidas(int numeroDeCurtidas) {
        this.numeroDeCurtidas = numeroDeCurtidas;
    }

    public void setRespostas(ArrayList<Resposta> respostas) {
        this.respostas = respostas;
    }

    public void setDenuncias(ArrayList<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }
}
