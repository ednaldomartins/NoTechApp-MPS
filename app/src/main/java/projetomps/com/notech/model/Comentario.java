package projetomps.com.notech.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "comentario_table")
public class Comentario implements Serializable {
    //MEMENTO - variavel
    private ComentarioCareTaker careTaker;

    @PrimaryKey @ColumnInfo(name = "id") private int comentarioId;
    private String comentario;
    private int usuarioId;
    private int numeroDeCurtidas;
    private int paiId;
    private int respostaId;

    public Comentario(int comentarioId, String comentario, int usuarioId, int numeroDeCurtidas, int paiId, int respostaId) {
        //MEMENTO - inicialização
        this.careTaker = new ComentarioCareTaker();

        this.comentarioId = comentarioId;
        this.usuarioId = usuarioId;
        this.comentario = comentario;
        this.numeroDeCurtidas = numeroDeCurtidas;
        this.paiId = paiId;
        this.respostaId = respostaId;
    }



    //MEMENTO - metodo para editar comentario atual
    public void escreverComentario (String novoComentario) {
        //não estamos trabalhando com editor de texto, entao vamos literalmente pegar um novo comentario
        careTaker.adcionarMemento(new ComentarioMemento(this.comentario));
        //agora o novo comentario do usuario passara a ser o comentario padrao do usuario
        comentario = novoComentario;
    }

    //MEMENTO - metodo para retornar a versão anterior do comentario
    public void desfazerComentario () {
        //comentario atual recebe um memento como retorno, esse memento é o ultimo comentario
        comentario = careTaker.getUltimoComentarioSalvo().comentarioSalvo();
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

    public int getUsuarioNome() {
        return usuarioId;
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

    public void setUsuarioNome(int usuarioId) {
        this.usuarioId = usuarioId;
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
