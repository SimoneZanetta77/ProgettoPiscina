import java.io.IOException;
import java.io.Serializable;

public class GestioneAbbonamento implements Serializable
{
	private Nodo head;
	private int elementi;
	ConsoleInput tastiera=new ConsoleInput();
	
	/**
	 * Costruttore. Istanzia un elenco di abbonamenti vuoto.
	 */
	
	public GestioneAbbonamento()
	{
		head=null;
		elementi=0;
	}
	
	 /**
	 * Metodo getter che restituisce il numero di elementi inseriti.
	 * @return elementi.
	 */
	
	public int getElementi()
	{
		return elementi;
	}
	
	/**
	 * Metodo privato utilizzato all'interno della classe per aggiungere all'elenco.
	 * @param barca è la parte informativa del nodo.
	 * @param link contiene il reference del nodo successivo(collegamento).
	 * @return nodo restituisce il nodo creato.
	 */
	
	private Nodo creaNodo(Abbonamento abbonamento, Nodo link)
	{
		Nodo nodo= new Nodo(abbonamento);
		nodo.setLink(link);
		return nodo;
	}
	/**
	 * Metodo privato all'interno della classe per ottenere il nodo in una determinata posione.
	 * @param posizione (coiè la posizione da cui ricavare il nodo).
	 * @return a il collegamento ottenuto nella posizione richiesta.
	 * @throws AbbonamentoException: viene sollevata la seguente eccezione nel caso venisse inserito una posizione non valida.
	 */
	
	
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
	
	/**
	 * In questo metodo inserisci un nodo in testa alla lista Abbonamento.
	 * @param abbonamento : è la parte informativa del nodo.
	 */
	public void inserisciInTesta(Abbonamento a)
	{
		Nodo a1=creaNodo(a, head);
		head=a1;
		elementi++;
	}
	
	/**
	 * Metodo che inserisce un nuovo Abbonamento in coda.
	 * @param abbonamento.
	 * @throws AbbonamentoException: viene sollevata quando non c'è nessun abbonamento, quindi quando GestioneAbbonamenti è vuota.
	 */
	
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
	
	/**
	 * Metodo che elimina il nodo che si trova in testa alla lista GestioneAbbonamenti.
	 * @throws AbbonamentoException viene sollevata quando GestioneAbbonamenti è vuota.
	 */
	
	public void eliminaInTesta() throws AbbonamentoException
	{
		if (elementi==0) 
		{
			throw new AbbonamentoException("lista vuota");
		}
		head=head.getLink();
		elementi--;
	}
	
	/**
	 * Metodo che elimina il nodo che in coda alla lista GestioneAbbonamenti.
	 * @throws AbbonamentoException viene sollevata quando GestioneAbbonamenti è vuota.
	 */
	
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
	/**
	 * Metodo con il quale possiamo aggiungere una nuovo abbonamento nella posizione prestabilita.
	 * @param abbonamento indica il nodo che stiamo aggiungendo.
	 * @param posizione indica la posizione all'interno della lista.
	 * @throws AbbonamentoException viene sollevata se il GestioneAbbonamenti è vuota.
	 */
	
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

	/**
	 * Metodo che elimina il nodo in posizione inserita.
	 * @param posizione serve per verificare se la posizione inserita è valida.
	 * @throws AbbonamentoException viene sollevata quando GestioneAbbonamenti è vuota o la posizione inserita non esiste.
	 */
	
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
	/**
	 /**
	 * Consente di ricavare un'abbonamento, in base alla posione.
	 * @param posizione indica la posizione all'interno del nodo.
	 * @throws AbbonamentoException viene sollevata se la posizione non è valida.
	 */
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
	
	/**
	 * Metodo che serve per mettere una lista in un array
	 */
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
	
	/**
	 * Metodo che serve per registrare le informazioni di un'abbonamento all'interno di GestioneAbbonamenti
	 * @param info contiene le informazioni dell'abbonamento.
	 */
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
	/**
	 * Metodo che serve per modificare l'orario di un abbonamento, per selezionare a quale abbonamento si vuole cambiare orario inserendo il codice identificativo.
	 * @param codice viene inserito per riconoscere di quale abbonamento si vuole modificare l'orario.
	 * @throws AbbonamentoException viene sollevata quando GestioneAbbonamenti è vuota.
	 * @throws NumberFormatException
	 * @throws IOException viene sollevata quando si verificano errori sulla scrittura del file.
	 */
	
		public void modificaOrario(int codice) throws AbbonamentoException, NumberFormatException, IOException
		{
		int ora=0;
		int minuti=0;
		for (int i = 1; i < this.getElementi()+1; i++) 
		{
			if (getInfo(i).getCodice()==codice) 
			{
				System.out.println("inserire ora: ");
				ora=tastiera.readInt();
				System.out.println("inserire minuti: ");
				minuti=tastiera.readInt();
				getInfo(i).setOrarioArrivo(ora, minuti);
			}
		}
		}
	
		/**
		 * 
		 * @param nomeFile nome del file su cui esportare le barche.
		 * @throws IOException viene sollevata quando si verificano errori durante la scrittura su file.
		 * @throws PortoException viene sollevata quando il porto è vuoto.
		 * @throws FileException
		 */
		public void esportaCSV (String nomeFile) throws IOException, AbbonamentoException, FileException
		{
			TextFile file= new TextFile (nomeFile,'W');
			String abbonamentoCSV;
			Abbonamento abbonamento;
			
			for (int i = 1; i <= getElementi(); i++) 
			{
				abbonamento=getInfo(i);
				abbonamentoCSV=abbonamento.getCodice()+";"+abbonamento.getAbbonato()+";"+abbonamento.getDataVendita()+";")
				file.toFile(abbonamentoCSV);
			}
			file.closeFile();
			
		}
		
		
		
	}


	
