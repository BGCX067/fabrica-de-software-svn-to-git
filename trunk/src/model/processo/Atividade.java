package model.processo;

public class Atividade 
{
	private int id;
	private String nome;
	private String descricao;
	
	private int user_modif;
	private int autor;
	private int status;
	

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getNome()
	{
		return nome;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public String getDescricao()
	{
		return descricao;
	}
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
	
	public int getUserModif()
	{
		return user_modif;
	}
	public void setUserModif(int user_modif )
	{
		this.user_modif = user_modif;
	}
	public int getAutor()
	{
		return autor;
	}
	public void setAutor(int autor)
	{
		this.autor = autor;
	}
	public int getStatus()
	{
		return status;
	}
	public void setStatus(int status)
	{
		this.status = status;
	}
	
}