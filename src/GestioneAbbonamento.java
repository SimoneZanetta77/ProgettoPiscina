

public class GestioneAbbonamento
{
	private Nodo head;
	private int elementi;
	
	public GestioneAbbonamento()
	{
		head=null;
		elementi=0;
	}
	public int getElementi()
	{
		return elementi;
	}
	
	private Nodo getLinkPosizione(int posizione) throws AbbonamentoException
	{
		if (elementi==0) 
		{
			throw new AbbonamentoException("lista vuota");
		}
		if (posizione<0||posizione>elementi) 
		{
			throw new AbbonamentoException("posizione non valida");
		}
		
		
		Nodo a;
		a=head;
		
		int n=1;
		while(a.getLink()!=null&&n<posizione)
		{
			a=a.getLink();
			n++;
		}
		return a;
	}
	
	public void inserisciInTesta(Abbonamento a)
	{
		Nodo a1=creaNodo(a, head);
		head=a1;
		elementi++;
	}
	
	public String toString()
	{
		String risultato="head";
		if (elementi==0)
			
		return risultato;
		
		Nodo a=head;
		while(a!=null)
		{
			risultato+="-->"+a.getInfo().getNome();
			a=a.getLink();
		}
		return risultato;
	}
	
	public void inserisciInCoda(Abbonamento a) throws AbbonamentoException 
	{
		if (elementi==0) 
		{
			inserisciInTesta(a);
			return;
		}
		
		
		head =creaNodo(a, null);
		Nodo a1=getLinkPosizione(elementi);
		a1.setLink(a1);
		elementi++;
	}
	private Nodo creaNodo(Abbonamento a, Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	public void inserisciInPosizione(Abbonamento a,int posizione) throws AbbonamentoException
	{
		if (posizione==1) 
		{
			inserisciInTesta(a);
			return;
		}
		if (posizione<=0||posizione>elementi+1) 
		{
			throw new AbbonamentoException("posizione non valida");
		}
		
		if (posizione==elementi+1) 
		{
			inserisciInCoda(a);
			return ;
		}
		
		Nodo pn=creaNodo(a, getLinkPosizione(posizione));
		Nodo nodoprecedente=getLinkPosizione(posizione-1);
		nodoprecedente.setLink(pn);
		elementi++;
	}
	public void eliminaInTesta() throws AbbonamentoException
	{
		if (elementi==0) 
		{
			throw new AbbonamentoException("lista vuota");
		}
		head=head.getLink();
		elementi--;
	}
	public void eliminaInCoda() throws AbbonamentoException
	{
		if (elementi==0) 
		{
			throw new AbbonamentoException("lista vuota");
		}
		if (elementi==1) 
		{
			eliminaInTesta();
			elementi--;
		}
		Nodo penultimo=getLinkPosizione(elementi-1);
		penultimo.setLink(null);
		elementi--;
	}
	public void eliminaInPosizione(int posizione) throws AbbonamentoException
	{
		if (elementi==0) 
		{
			throw new AbbonamentoException("lista vuota");
		}
		if (elementi<=0||posizione>elementi) 
		{
			throw new AbbonamentoException("posizione non valida");
		}
		if (posizione==1)
		{
			eliminaInTesta();
			elementi--;
		}
		if (posizione==elementi)
		{
			eliminaInCoda();
			elementi--;
		}
		Nodo a=getLinkPosizione(posizione);
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(a.getLink());
		elementi--;
	}
	public String visita(int posizione) throws AbbonamentoException
	{
		if (elementi==0) 
		{
			throw new AbbonamentoException("lista vuota");
		}
		if (elementi<=0||posizione>elementi) 
		{
			throw new AbbonamentoException("posizione non valida");
		}
		Nodo a=getLinkPosizione(posizione);
		return (a.getInfo().toString());
	}
	public Abbonamento getInfo(int posizione) throws AbbonamentoException
	{
		if (elementi==0) 
		{
			throw new AbbonamentoException("lista vuota");
		}
		if (elementi<=0||posizione>elementi) 
		{
			throw new AbbonamentoException("posizione non valida");
		}
		Nodo a=getLinkPosizione(posizione);
		Abbonamento a1=new Abbonamento(a.getInfo());
		return(a1);
	}
	public Abbonamento[] arrayAbbonamento() throws AbbonamentoException
	{
		Abbonamento[] arrayAbbonamento = new Abbonamento[elementi];
		
		for (int i = 0; i < arrayAbbonamento.length; i++) 
		{
			Nodo a1=getLinkPosizione(i+1);
			arrayAbbonamento[i]=a1.getInfo();
		}
		return arrayAbbonamento;
	}
	public void registraAbbonamento(Abbonamento abbonamento) throws AbbonamentoException
	{
		if (elementi==0)
		{
			inserisciInTesta(abbonamento);
			return;
		}
			inserisciInCoda(abbonamento);
			System.out.println("prenotazione effetuata");
			return;
		}
	
	public void EliminaAbbonamento(int posizione) throws AbbonamentoException
	{
		if (elementi==0) 
		{
			throw new AbbonamentoException("lista vuota");
		}
		if (elementi<=0||posizione>elementi) 
		{
			throw new AbbonamentoException("posizione non valida");
		}
		if (posizione==1)
		{
			eliminaInTesta();
			elementi--;
		}
		if (posizione==elementi)
		{
			eliminaInCoda();
			elementi--;
		}
		Nodo abbonamento=getLinkPosizione(posizione);
		Nodo abbonamento1=getLinkPosizione(posizione-1);
		elementi--;
		
	}
}