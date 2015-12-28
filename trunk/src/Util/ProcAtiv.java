/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

/**
 *
 * @author Administrador
 */
public class ProcAtiv {

    private int idproc;
    private int idativ;
    private int chave;
    private int raiz;
    private int idfin;
    private int link;
    private int tipo;
    private int idtipo;
    private int tempo;
    private float valor_tempo;

    public ProcAtiv(int idproc,int idativ,int chave, int raiz, int idfin, int link, int tipo, int idtipo, int tempo, float valor_tempo)
    {
        setIdproc(idproc);
        setIdativ(idativ);
        setRaiz(raiz);
        setIdfin(idfin);
        setLink(link);
        setTipo(tipo);
        setIdtipo(idtipo);
        setTempo(tempo);
        setValor_tempo(valor_tempo);
    }



    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getIdativ() {
        return idativ;
    }

    public void setIdativ(int idativ) {
        this.idativ = idativ;
    }

    public int getIdfin() {
        return idfin;
    }

    public void setIdfin(int idfin) {
        this.idfin = idfin;
    }

    public int getIdproc() {
        return idproc;
    }

    public void setIdproc(int idproc) {
        this.idproc = idproc;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public int getLink() {
        return link;
    }

    public void setLink(int link) {
        this.link = link;
    }

    public int getRaiz() {
        return raiz;
    }

    public void setRaiz(int raiz) {
        this.raiz = raiz;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public float getValor_tempo() {
        return valor_tempo;
    }

    public void setValor_tempo(float valor_tempo) {
        this.valor_tempo = valor_tempo;
    }




}
