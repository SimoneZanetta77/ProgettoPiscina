import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Abbonamento implements Serializable
{
	private int codice;
	private String abbonato;
	private String tipologia;
	private int dataVendita;
	private int dataScadenza;


	//costruttore 
	public Abbonamento(int codice, String abbonato, String tipologia, int dataVendita,int dataScadenza)
	{
		setCodice(codice);
		setAbbonato(abbonato);
		setTipologia(tipologia);
		setDataVendita(dataVendita);
		setDataScadenza(dataScadenza);
	}
	
	public Abbonamento(Abbonamento abbonamento)
	{
		setCodice(abbonamento.getCodice());
		setAbbonato(abbonamento.getAbbonato());
		setTipologia(abbonamento.getTipologia());
		setDataVendita(abbonamento.getDataVendita());
		setDataScadenza(abbonamento.getDataScadenza());
		
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
	public void setDataVendita(int dataVendita) 
	{
		this.dataVendita = dataVendita;
	}
	public int getDataScadenza() 
	{
		return dataScadenza;
	}
	public void setDataScadenza(int dataScadenza)
	{
		this.dataScadenza = dataScadenza;
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