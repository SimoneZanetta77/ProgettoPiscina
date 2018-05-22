import java.io.FileInputStream;
import java.time.LocalTime;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * La classe Abbonamento rappresenta la registrazione di un abbonamento, costituito dai seguenti attributi:
 * un codice, un abbonato, l'orario dell'arrivo e la tipologia di abbonamento.
 * @version 1.0
 * @author Simone Zanetta
 *
 */

public class Abbonamento implements Serializable
{
	//Attributi
	private int codice;
	private String abbonato;
	private LocalTime orario;
	private String tipologia;
	private String nome;
	private String cognome;
	/**
	 * 
	 * @param codice Indica il codice dell'abbonamento registrata
	 * @param abbonato Indica la persona proprietaria di quell'abbonamento
	 * @param orario Indica l'orario di registrazione dell'abbonamento
	 * @param tipologia Indica se l'abbonamento è annuale, mensile o settimanale
	 */
	
	/**
	 * Metodo Abbonamento che ti permettere di istanziare gli oggetti
	 */
	
	public Abbonamento(int codice, String abbonato,int ore,int minuti,String tipologia)
	{
		setCodice(codice);
		setAbbonato(abbonato);
		setOrario(ore, minuti);
		setTipologia(tipologia);
	}
	/**
	 * Costruttore del metodo Abbonamento.
	 */
	public Abbonamento(Abbonamento abbonamento)
	{
		setCodice(abbonamento.getCodice());
		setAbbonato(abbonamento.getAbbonato());
		setOrario(abbonamento.getOrario());
		setTipologia(abbonamento.getTipologia());
	}
	/**
	 * Metodo getter che restituisce l'attributo codice
	 * @return codice 
	 */
	public int getCodice() 
	{
		return codice;
	}
	/**
	 * Metodo setter che consente di impostare l'attributo codice
	 */
	public void setCodice(int codice) 
	{
		this.codice = codice;
	}
	/**
	 * Metodo getter che restituisce Abbonato
	 * @return abbonato
	 */
	public String getAbbonato() 
	{
		return abbonato;
	}
	/**
	 * Metodo setter che consente di impostare Abbonato
	 */
	public void setAbbonato(String Abbonato) 
	{
		this.abbonato = abbonato;
	}
	/**
	 * Metodo setter consente di impostare l'attributo orario
	 */
	public void setOrario(LocalTime orario) 
	{
		this.orario = orario;
	} 


	/**
	 * Metodo getter che restituisce l'attributo orario
	 * @return orario
	 */
	public LocalTime getOrario() 
	{
		return orario;
	}
	/**
	 * Metodo setter consente di impostare l'attributo orario
	 */
	public void setOrario(int ore, int minuti) 
	{
		orario=LocalTime.of(ore, minuti);
	}
	/**
	 * Metodo getter che restituisce la Tipologia
	 * @return tipologia
	 */
	public String getTipologia() 
	{
		return tipologia;
	}
	/**
	 * Metodo setter che consente di impostare la tipologia
	 */
	public void setTipologia(String tipologia) 
	{
		this.tipologia = tipologia;
	}
	/**
	 * Metodo toString per visualizzare i valori degli attributi
	 */
	public String toString()
	{
		return("codice= "+getCodice()+'\t'+"Abbonato= "+getAbbonato()+'\t'+"orario="+getOrario().getHour()+":"+getOrario().getMinute());
	}
	public int getData() 
	{
		return 0;
	}
	public int getElementi() 
	{
		return 0;
	}
	public Abbonamento getAbbonamento(int i)
	{
	
		return null;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public static void EliminaAbbonamento(int readInt) 
	{
		// TODO Auto-generated method stub
		
	}
	public static void salvaLista(String nomeFile) {
		// TODO Auto-generated method stub
		
	}
}


