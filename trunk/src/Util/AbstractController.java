package Util;

public interface AbstractController<T>
{
    public void camposObrigatorios(T objeto)throws Exception;
    public void formatoCampos(T objeto)throws Exception;
}
