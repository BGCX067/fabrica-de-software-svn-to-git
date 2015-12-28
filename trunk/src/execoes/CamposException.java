package execoes;

public class CamposException extends Exception
{
    private String campo;

    public String getCampo()
    {
        return campo;
    }

    public void setCampo(String campo)
    {
        this.campo = campo;
    }

    public CamposException(String campo)
    {
        this.campo = campo;
    }
}
