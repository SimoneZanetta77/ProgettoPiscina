import java.io.IOException;

public class Ordinatore 
{
	//NODI
	public static void scambia(GestioneAbbonamento abbonamento, int pos1, int pos2) throws AbbonamentoException 
	{
		if(pos1<=0 || pos1>abbonamento.getElementi() || pos2<=0 ||pos2>abbonamento.getElementi())
			throw new AbbonamentoException("Posizioni non valide");
		Abbonamento r1,r2;
		r1=new Abbonamento(abbonamento.getAbbonamento(pos1));
		r2=new Abbonamento(abbonamento.getAbbonamento(pos2));
	
		abbonamento.inserisciInPosizione(r1, pos2);
		abbonamento.inserisciInPosizione(r2, pos1);
		
		abbonamento.eliminaInPosizione(pos2+2);
		abbonamento.eliminaInPosizione(pos1+1);
	}
	private static GestioneAbbonamento copia(GestioneAbbonamento abbonamento) throws IOException, ClassNotFoundException 
	{
		GestioneAbbonamento l2=new GestioneAbbonamento();
		abbonamento.salvaLista("abbonamenti.bin");
		l2=l2.caricaLista("abbonamenti.bin");
		return l2;
	}
	public static GestioneAbbonamento selectionSortCrescenteNodi(GestioneAbbonamento abbonamento) throws ClassNotFoundException, IOException, FileException, AbbonamentoException
	{
		GestioneAbbonamento abbonCopia=copia(abbonamento);
		boolean scambioOK;
		do
		{
			scambioOK=false;
			for (int i = 1; i < abbonCopia.getElementi(); i++) 
			{
				if(abbonCopia.getAbbonamento(i).getOrario().isAfter(abbonCopia.getAbbonamento(i+1).getOrario()))
				{
					scambia(abbonCopia,i,i+1);
					scambioOK=true;
				}
						
					
			}
		} 
		while (scambioOK==true);
		return abbonCopia;
	}
	public static GestioneAbbonamento selectionSortDecrescenteNodi(GestioneAbbonamento porto) throws ClassNotFoundException, IOException, FileException, AbbonamentoException
	{
		GestioneAbbonamento abbonamento = null;
		GestioneAbbonamento abbonCopia=copia(abbonamento);
		boolean scambioOK;
		do
		{
			scambioOK=false;
			for (int i = 1; i < abbonCopia.getElementi(); i++) 
			{
				if(abbonCopia.getAbbonamento(i).getOrario().isBefore(abbonCopia.getAbbonamento(i+1).getOrario()))
				{
					scambia(abbonCopia,i,i+1);
					scambioOK=true;
				}
						
					
			}
		} 
		while (scambioOK==true);
		return abbonCopia;
	}
	public static Abbonamento[] copiaInArray(GestioneAbbonamento abbonamento) throws AbbonamentoException 
	{
		Abbonamento[] arrayCopia=new Abbonamento[abbonamento.getElementi()];
		for (int i = 1; i < abbonamento.getElementi()+1; i++) 
		{
			arrayCopia[i-1]=abbonamento.getAbbonamento(i);	
		}
		
		return arrayCopia;
	}
	
	public static Abbonamento[] copia(Abbonamento[] array)
	{
		Abbonamento[] arrayCopia=new Abbonamento[array.length];
		
		for (int i = 0; i < arrayCopia.length; i++) 
		{
		arrayCopia[i]=array[i];	
		}
		
		return arrayCopia;
	}
	public static GestioneAbbonamento creaLista(Abbonamento[] array)
	{
		GestioneAbbonamento l1=new GestioneAbbonamento();
		for (int i = 0; i < array.length; i++) 
		{
			try 
			{
				l1.registraAbbonamento(array[i]);
			} 
			catch (AbbonamentoException e)
			{
				
				e.printStackTrace();
			}
		}
		
		return l1;
	}
	
	//ARRAY
	public static int scambia(Abbonamento[] array, int pos1, int pos2)
	{
		Abbonamento a;
		if(pos1<0 || pos1>=array.length || pos2<0 ||pos2>=array.length)
			return -1;
		a=new Abbonamento(array[pos1]);
		array[pos1]=new Abbonamento(array[pos2]);
		array[pos2]=new Abbonamento(a);
		return 0;
	}
	
	public static GestioneAbbonamento selectionSortCrescente(GestioneAbbonamento abbonamento) throws AbbonamentoException
	{
		Abbonamento[] array=copiaInArray(abbonamento);
		Abbonamento[] arrayOrdinato=copia(array);
		for (int i = 0; i < arrayOrdinato.length-1; i++) 
		{
			for (int j = i+1; j < arrayOrdinato.length; j++) 
			{
				if(arrayOrdinato[j].getOrario().isAfter(arrayOrdinato[i].getOrario()))
					scambia(arrayOrdinato, i, j);
				
			}
		}
		
		GestioneAbbonamento abbOrdinato=creaLista(arrayOrdinato);
		return abbOrdinato;
	}
	
	public static GestioneAbbonamento selectionSortDecrescente(GestioneAbbonamento abbonamento) throws AbbonamentoException
	{
		Abbonamento[] array=copiaInArray(abbonamento);
		Abbonamento[] arrayOrdinato=copia(array);
		for (int i = 0; i < arrayOrdinato.length-1; i++) 
		{
			for (int j = i+1; j < arrayOrdinato.length; j++) 
			{
				if(arrayOrdinato[j].getOrario().isBefore(arrayOrdinato[i].getOrario()))
					scambia(arrayOrdinato, i, j);
				
			}
		}
		
		GestioneAbbonamento abbonOrdinato=creaLista(arrayOrdinato);
		return abbonOrdinato;
	}
	

	public static GestioneAbbonamento selectionSortCrescenteAlfabetoNodi(GestioneAbbonamento abbonamento) throws ClassNotFoundException, IOException, FileException, AbbonamentoException
	{
		GestioneAbbonamento abbonCopia=copia(abbonamento);
		boolean scambioAvvenuto;
		do
		{
			scambioAvvenuto=false;
			for (int i = 1; i < abbonCopia.getElementi(); i++) 
			{
				if(abbonCopia.getAbbonamento(i).getNome().compareTo(abbonCopia.getAbbonamento(i+1).getNome())==0)
				{
					if(abbonCopia.getAbbonamento(i).getCognome().compareTo(abbonCopia.getAbbonamento(i+1).getCognome())==0)
					{						
					}
					else if(abbonCopia.getAbbonamento(i).getCognome().compareTo(abbonCopia.getAbbonamento(i+1).getCognome())<0)
					{
					}
					else if(abbonCopia.getAbbonamento(i).getCognome().compareTo(abbonCopia.getAbbonamento(i+1).getCognome())>0)
					{
						scambia(abbonCopia,i,i+1);
						scambioAvvenuto=true;
					}
				}
				else if(abbonCopia.getAbbonamento(i).getNome().compareTo(abbonCopia.getAbbonamento(i+1).getNome())<0)
				{
				}
				else if(abbonCopia.getAbbonamento(i).getNome().compareTo(abbonCopia.getAbbonamento(i+1).getNome())>0)
				{
					scambia(abbonCopia,i,i+1);
					scambioAvvenuto=true;
				}
					
			}
		} while (scambioAvvenuto==true);
		return abbonCopia;
	}
}
