
public class AbbonamentoCoda 
{

	private Nodo head;
	private int elementi;
	
	public AbbonamentoCoda()
	{
		head=null;
		elementi=0;
	}
	
	public int getElementi()
	{
		return elementi;
	}
	
	private Nodo creaNodo(Abbonamento abbonamento, Nodo link)
	{
		Nodo nodo= new Nodo(abbonamento);
		nodo.setLink(link);
		return nodo;
	}
	
	private Nodo getLinkPosizione(int posizione) throws AbbonamentoException
	{
		
		Nodo p;
		int n;
		p=head;
		n=1;
		
		if (posizione<1 || posizione>getElementi())
			throw new AbbonamentoException("Posizione non valida");
		if (elementi==0)
			throw new AbbonamentoException("Lista vuota");
			
		while(p.getLink()!=null && n<posizione)
		{
			p=p.getLink();	
			n++;
		}
		
		return p;
	}
	
	public void enqueue (Abbonamento abbonamento)
	{
		
		Nodo p=creaNodo(abbonamento, head);
		head=p;
		elementi++;
	}
	
	public String toString()
	{
		String risultato="Head";
		if (elementi==0)
			return risultato+="-->";
		Nodo p=head;
		while (p!=null)
		{
			risultato+="-->"+p.getInfo().toString();
			p=p.getLink();
		}
		return risultato;
	}
	
	
	
	
	
	public Abbonamento dequeue() throws AbbonamentoException
	{
		if (elementi==0)
			throw new AbbonamentoException("Lista vuota");
		Nodo p;
		if (elementi==1)
		{
			p=head;
			head=null;
			elementi--;
			return p.getInfo();
		}
		
		p=getLinkPosizione(elementi);
		Nodo penultimo=getLinkPosizione(elementi-1);
		penultimo.setLink(null);
		elementi--;
		return p.getInfo();
	}
}
