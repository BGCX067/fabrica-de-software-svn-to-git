package model.processo;

public class Opcao
{
    private int id;
    private int finalizacao;
    private String nome;
    private String valor;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getFinalizacao()
    {
        return finalizacao;
    }

    public void setFinalizacao(int finalizacao)
    {
        this.finalizacao = finalizacao;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
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
