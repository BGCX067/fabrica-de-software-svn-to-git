package model.sistema;

import java.util.Date;

public class Historico
{
    private int id;
    private int processo;
    private String evento;
    private String valor;
    private int usuario;
    private Date data;

    public Date getData()
    {
        return data;
    }

    public void setData(Date data)
    {
        this.data = data;
    }

    public String getEvento()
    {
        return evento;
    }

    public void setEvento(String evento)
    {
        this.evento = evento;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getProcesso()
    {
        return processo;
    }

    public void setProcesso(int processo)
    {
        this.processo = processo;
    }

    public int getUsuario()
    {
        return usuario;
    }

    public void setUsuario(int usuario)
    {
        this.usuario = usuario;
    }

    public String getValor()
    {
        return valor;
    }

    public void setValor(String valor)
    {
        this.valor = valor;
    }
}
