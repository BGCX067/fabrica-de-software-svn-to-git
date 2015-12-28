package model.processo;

public class AtividadeSelect 
{
	private int id;
	private String nome;
	private String autor;
        private String user_modif;
	

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
	public String getAutor()
	{
		return autor;
	}
	public void setAutor(String autor)
	{
		this.autor = autor;
	}
	
	public String getUserModif()
	{
		return user_modif;
	}
	public void setUserModif(String user_modif )
	{
		this.user_modif = user_modif;
	}
	
}