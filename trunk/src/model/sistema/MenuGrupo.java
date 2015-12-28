package model.sistema;

public class MenuGrupo
{
	private int id_item;
        private int id_grupo;
        private int flag_disp;
	

	public int getIdItem()

	{
		return id_item;
	}

	public void setIdItem(int id_item)
	{
		this.id_item = id_item;
	}

	public int getIdGrupo()
	{
		return id_grupo;
	}

	public void setIdGrupo(int id_grupo)
	{
		this.id_grupo = id_grupo;
	}
        public int getFlag()
        {
            return flag_disp;
        }
        public void setFlag(int flag)
        {
            flag_disp = flag;
        }
        public MenuGrupo(int id_item, int id_grupo, int flag_disp)
        {
            this.id_item = id_item;
            this.id_grupo = id_grupo;
            this.flag_disp = flag_disp;
        }
        public MenuGrupo()
        {
            
        }
}
