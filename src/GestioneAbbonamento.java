import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalTime;


/**
 * La classe rappresenta un processo che restituisce una serie di abboanmenti.
 * @versione 1.0.
 * @author Simone Zanetta.
 */

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
	 * @param abbonamento è la parte informativa del nodo.
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
	 * Metodo privato all'interno della classe per ottenere il nodo in una determinata posizione.
	 * @param posizione (cioè la posizione da cui ricavare il nodo).
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
			risultato+="-->"+a.getInfo().getAbbonato();
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
	 * Consente di ricavare un'abbonamento, in base alla posizione.
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
				getInfo(i).setOrario(ora, minuti);
			}
		}
		}
	
		/**
		 * 
		 * @param nomeFile nome del file su cui esportare abbonamenti.
		 * @throws IOException viene sollevata quando si verificano errori durante la scrittura su file.
		 * @throws AbbonamentiException viene sollevata quando GestioneAbbonamenti è vuota.
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
				abbonamentoCSV=abbonamento.getCodice()+";"+abbonamento.getAbbonato()+";"+abbonamento.getData()+";";
				file.toFile(abbonamentoCSV);
			}
			file.closeFile();
			
		}
		
		/**
		 * Metodo che consente di salvare gli elementi in GestioneAbbonamenti e di salvare gli abbonamenti su file binario.
		 * @param nomeFile nome del file su cui vengono salvati gli abbonamenti.
		 * @throws IOException viene sollevata quando si verificano errori durante la scrittura su file.
		 */
		public void salvaLista(String nomeFile) throws IOException
		{
			FileOutputStream file =new FileOutputStream(nomeFile);
			ObjectOutputStream writer=new ObjectOutputStream(file);
			writer.writeObject(this);
			writer.flush();					//funzione utilizzata per pulire il buffer
			file.close();
		}
		
		/**
		 * Metodo che consente di caricare gli elementi salvati in precedenza su file binario(abbonamenti.bin) 
		 * per ricaricarli in GestioneAbbonamenti.
		 * @param nomeFile nome del file dove si salva la lista GestioneAbbonamenti.
		 * @return abbonamento: ritorna un abbonamento.
		 * @throws IOException viene sollevata quando si verificano errori durante la lettura del file.
		 * @throws ClassNotFoundException viene sollevata quando si verifica un'errore di casting.
		 */
		public GestioneAbbonamento caricaLista (String nomeFile) throws IOException, ClassNotFoundException
		{
			FileInputStream file=new FileInputStream(nomeFile);
			ObjectInputStream reader= new ObjectInputStream(file);
			
			GestioneAbbonamento abbonamento;
			
			abbonamento=(GestioneAbbonamento)(reader.readObject());
			file.close();
			return abbonamento;
		}

		public void setCodice(int readInt)
		{
			// TODO Auto-generated method stub
			
		}

		public void setAbbonato(String readString)
		{
			// TODO Auto-generated method stub
			
		}

		public void setTipologia(String readString)
		{
			// TODO Auto-generated method stub
			
		}

		public void setOrario(LocalTime oraAttuale) 
		{
			// TODO Auto-generated method stub
			
		}

		public Abbonamento getAbbonamento(int pos1) 
		{
		
			return null;
		}

		public void registraAbbonamento(GestioneAbbonamento a1) {
			// TODO Auto-generated method stub
			
		}


		
		
		
		
		
		
		
		
		
		
	}


	
