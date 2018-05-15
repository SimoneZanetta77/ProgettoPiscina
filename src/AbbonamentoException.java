
public class AbbonamentoException extends Exception
{
	private String messaggio;
	
	public AbbonamentoException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}
}