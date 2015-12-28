package model.execucao;

import java.util.Date;



public class Agenda 
{
	private int idagenda;
        private int idtarefa;
        private int idativ;
        private int idproc;
        private int idfin;
        private int sequencia;
        private int idusuario;
        private String dt_inicial;
        private String dt_final;
        private String valor;
        private int pai;
        private String atraso;
        private String solicitante;

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getAtraso() {
        return atraso;
    }

    public void setAtraso(String atraso) {
        this.atraso = atraso;
    }

    public int getPai() {
        return pai;
    }

    public void setPai(int pai) {
        this.pai = pai;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDt_final() {
        return dt_final;
    }

    public void setDt_final(String dt_final) {
        this.dt_final = dt_final;
    }

    public String getDt_inicial() {
        return dt_inicial;
    }

    public void setDt_inicial(String dt_inicial) {
        this.dt_inicial = dt_inicial;
    }

    public int getIdagenda() {
        return idagenda;
    }

    public void setIdagenda(int idagenda) {
        this.idagenda = idagenda;
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

    public int getIdtarefa() {
        return idtarefa;
    }

    public void setIdtarefa(int idtarefa) {
        this.idtarefa = idtarefa;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }
        
	
}