package projetomps.com.notech.model;

import java.util.ArrayList;

import projetomps.com.notech.model.Denuncia;

public class Resposta {

    private String resposta;
    private int numeroDeCurtidas;
    private ArrayList<Denuncia> denuncias;

    public Resposta(String resposta, int numeroDeCurtidas, ArrayList<Denuncia> denuncias) {
        this.resposta = resposta;
        this.numeroDeCurtidas = numeroDeCurtidas;
        this.denuncias = denuncias;
    }


    //GETs

    public String getResposta() {
        return resposta;
    }

    public int getNumeroDeCurtidas() {
        return numeroDeCurtidas;
    }

    public ArrayList<Denuncia> getDenuncias() {
        return denuncias;
    }


    //SETs

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public void setNumeroDeCurtidas(int numeroDeCurtidas) {
        this.numeroDeCurtidas = numeroDeCurtidas;
    }

    public void setDenuncias(ArrayList<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }
}

