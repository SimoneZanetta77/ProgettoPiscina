
import java.io.Serializable;

public class Nodo implements Serializable
{
	private Abbonamento info;
	private Nodo link;
	
	public Nodo (Abbonamento abbonamento)
	{
		setInfo(abbonamento);
		link=null;
	}

	public Abbonamento getInfo() 
	{
		return info;
	}

	public void setInfo(Abbonamento info) 
	{
		this.info = new Abbonamento(info);
	}

	public Nodo getLink() 
	{
		return link;
	}

	public void setLink(Nodo link) 
	{
		this.link = link;
	}

}
