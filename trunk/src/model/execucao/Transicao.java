package model.execucao;

import java.util.Date;
import org.joda.time.DateTime;



public class Transicao 
{
        private int idtarefa;
        private int idativ;
        private int idproc;
        private int tresp;
        private int resp;
        private int chave;
        private Date dt_inicial;
        private int status;
        private int transicao;
        private int pai;
        private String solicitante;
        private Date dt_limite;
        private DateTime dt;

    public DateTime getDt() {
        return dt;
    }

    public void setDt(DateTime dt) {
        this.dt = dt;
    }

    public Date getDt_limite() {
        return dt_limite;
    }

    public void setDt_limite(Date dt_limite) {
        this.dt_limite = dt_limite;
    }

    public int getPai() {
        return pai;
    }

    public void setPai(int pai) {
        this.pai = pai;
    }




    public int getTransicao() {
        return transicao;
    }

    public void setTransicao(int transicao) {
        this.transicao = transicao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public Transicao(int idtarefa,int idativ, int idproc, int tresp, int resp, int chave, Date dt_inicial, int status, int transicao, int pai)
    {
        setIdtarefa(idtarefa);
        setIdativ(idativ);
        setIdproc(idproc);
        setTresp(tresp);
        setResp(resp);
        setChave(chave);
        setDt_inicial(dt_inicial);
        setStatus(status);
        setTransicao(transicao);
        setPai(pai);
    }
    public Transicao(int idtarefa,int idativ, int idproc, int tresp, int resp, int chave, Date dt_inicial, int status, int transicao, int pai,String solicitante)
    {
        setIdtarefa(idtarefa);
        setIdativ(idativ);
        setIdproc(idproc);
        setTresp(tresp);
        setResp(resp);
        setChave(chave);
        setDt_inicial(dt_inicial);
        setStatus(status);
        setTransicao(transicao);
        setPai(pai);
        setSolicitante(solicitante);
    }
    public Transicao(int idtarefa,int idativ, int idproc, int tresp, int resp, int chave, Date dt_inicial, int status, int transicao, int pai,String solicitante,Date dt_limite)
    {
        setIdtarefa(idtarefa);
        setIdativ(idativ);
        setIdproc(idproc);
        setTresp(tresp);
        setResp(resp);
        setChave(chave);
        setDt_inicial(dt_inicial);
        setStatus(status);
        setTransicao(transicao);
        setPai(pai);
        setSolicitante(solicitante);
        setDt_limite(dt_limite);
        
    }
    public Transicao()
    {
        
    }
    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public Date getDt_inicial() {
        return dt_inicial;
    }

    public void setDt_inicial(Date dt_inicial) {
        this.dt_inicial = dt_inicial;
    }

    public int getIdativ() {
        return idativ;
    }

    public void setIdativ(int idativ) {
        this.idativ = idativ;
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

    public int getResp() {
        return resp;
    }

    public void setResp(int resp) {
        this.resp = resp;
    }

    public int getTresp() {
        return tresp;
    }

    public void setTresp(int tresp) {
        this.tresp = tresp;
    }
    public void setSolicitante(String solicitante)
    {
        this.solicitante = solicitante;
    }
    public String getSolicitante()
    {
        return solicitante;
    }
	
}