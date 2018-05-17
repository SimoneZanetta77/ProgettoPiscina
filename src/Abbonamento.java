import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Abbonamento implements Serializable
{
	private int codice;
	private String abbonato;
	private String tipologia;
	private int dataVendita;
	private int dataScadenza;
	private int nome;
	private int cognome;
	
	


	//costruttore 
	public Abbonamento(int codice, String abbonato, String tipologia,int i, LocalDateTime dataOra1, LocalDateTime dataOra2, LocalDateTime dataOra3)
	{
		setCodice(codice);
		setAbbonato(abbonato);
		setTipologia(tipologia);
		setDataVendita(i);
		setDataScadenza(i);
	}
	
	public Abbonamento(Abbonamento abbonamento)
	{
		setCodice(abbonamento.getCodice());
		setAbbonato(abbonamento.getAbbonato());
		setTipologia(abbonamento.getTipologia());
		setDataVendita(abbonamento.getDataVendita());
		setDataScadenza(abbonamento.getDataScadenza());
		
	}
	



	public Abbonamento(int i, String string, String string2, int j, LocalDateTime dataOra2) {
		// TODO Auto-generated constructor stub
	}

	public int getCodice()
	{
		return codice;
	}
	public void setCodice(int codice) 
	{
		this.codice = codice;
	}
	public String getAbbonato() 
	{
		return abbonato;
	}
	public void setAbbonato(String abbonato) 
	{
		this.abbonato = abbonato;
	}
	public String getTipologia()
	{
		return tipologia;
	}
	public void setTipologia(String tipologia) 
	{
		this.tipologia = tipologia;
	}
	public int getDataVendita()
	{
		return dataVendita;
	}
	 public void setDataVendita( int dataVendita) 
	{
		this.dataVendita = dataVendita;
	}
	public int getDataScadenza() 
	{
		return dataScadenza;
	}
	public void setDataScadenza(int i)
	{
		this.dataScadenza = i;
	}

	public int getNome() 
	{
		return nome;
	}

	public void setNome(int nome)
	{
		this.nome = nome;
	}

	public int getCognome() 
	{
		return cognome;
	}

	public void setCognome(int cognome) 
	{
		this.cognome = cognome;
	}

	public String toString()
	{
		return(getCodice()+" "+getAbbonato()+" "+getTipologia()+" "+getDataVendita()+" "+getDataScadenza());
	}

	public Abbonamento caricaAbbonamento (String nomeFile) throws IOException, ClassNotFoundException
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		
		Abbonamento abbonamento;
		
		abbonamento=(Abbonamento)(reader.readObject());
		file.close();
		return abbonamento;
	}



	
	



}