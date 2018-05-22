import java.io.IOException;
import java.io.NotSerializableException;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.Scanner;

public class MainClass 
{

	public static void main(String[] args) throws IOException 
	{
		
		
		ConsoleInput tastiera=new ConsoleInput();
		int ora,minuti;
		
		String[] elenco= {"1--->Registra Nuovo Abbonamento",
						  "2--->Rimozione di abbonamenti in scadenza",
						  "3--->Visualizza abbonamenti in ordine di data di scadenza",
						  "4--->Visualizza abbonamenti in ordine alfabetico",
						  "5--->ESCI", 
						 };

		System.out.println("Benvenuto all'AcquaPlanet di Darfo B.T.,\n Cosa desidera fare? \n Seleziona una delle voci del menu.\n");
		GestioneAbbonamento a1=new GestioneAbbonamento();
		
		Menu menu1=new Menu(elenco);
		String nomeFile = "abbonamenti.bin";
		LocalTime oraAttuale = null;
		String pp=null;
		int sceltamenu=0;
		
		
		try 
		{
			a1.caricaLista("abbonamenti.bin");
		} 
		catch (ClassNotFoundException | IOException e) 
		{
			System.out.println("Impossibile caricare la lista");
		}
		
		do
		{
		sceltamenu=menu1.scelta();
		switch (sceltamenu) 
		{
			case 1:
			System.out.println("Vuoi registrare un nuovo abbonamento? 1=Si, 2=No");
			int entrata=0;
			entrata=tastiera.readInt();
			
						
			switch (entrata) 
			{
			case 1:
				
				System.out.println("Inserisci codice abbonamento (di soli numeri): ");
				try 
				{
					a1.setCodice(tastiera.readInt());
				}
				catch(NumberFormatException n)
				{
					System.out.println('\n'+"Formato non disponibile, riprova..."+'\n');	
				}
				
				System.out.println("Inserisci credenziali dell'abbonato: ");
				try
				{
					a1.setAbbonato(tastiera.readString());
				}
				catch(NumberFormatException n)
				{
					System.out.println('\n'+"Formato non disponibile, riprova..."+'\n');	
				}
				
				System.out.println("Inserisci la tipologia dell'abbonamento");
				try
				{
					a1.setTipologia(tastiera.readString());
				}
				catch(NumberFormatException n)
				{
					System.out.println('\n'+"Formato non disponibile, riprova..."+'\n');
					
				}
				System.out.println("Inserisci orario di registrazione: ");
				System.out.print('\t'+"-Ora:");
				ora=tastiera.readInt();
				System.out.print('\t'+"-Minuti:");
				minuti=tastiera.readInt();
				
				try
				{
					oraAttuale=LocalTime.of(ora,minuti,0);
					a1.setOrario(oraAttuale);
				}
				catch(DateTimeException dt)
				{
					System.out.println('\n'+"Orario non inserito correttamente, torna al menu peincipale..."+'\n');
				}

					a1.registraAbbonamento(a1);
					System.out.println('\n'+"Abbonamento registrato correttamente, desidera altro?: "+'\n');
				try
				{
					a1.salvaLista("abbonamenti.bin");
				}
				catch(NotSerializableException n)
				{
					System.out.println("\n"+"Salvataggio non avvenuto con successo"+'\n');
				}
				default:
				break;
			}
				
			break;
			case 2:
			{
				
				System.out.println("Inserisci il codice che vuoi eliminare: ");
				try 
				{
					Abbonamento.EliminaAbbonamento(ConsoleInput().readInt());
				} 
				catch (NumberFormatException e) 
				{
					System.out.println("Formato dato inserito non corretto, eliminazione fallita");
					break;
				} 
				catch (IOException e) 
				{
					System.out.println("Errore di lettura o scrittura");
					break;
				}
				Abbonamento.salvaLista(nomeFile);
				System.out.println("Salvataggio avvenuto con successo");
				break;
				}
			
			case 3:
				
				if(	a1.getElementi()==0)
					System.out.println("Nessun abbonamento...");
				else
				{
					System.out.println("Visualizza abbonamenti in base all'ordine alfabetico");
					try 
					{
						a1=Ordinatore.selectionSortCrescenteAlfabetoNodi(a1);
						
						System.out.println(a1.toString());
					}
					catch (AbbonamentoException e) 
					{
						System.out.println(e.toString());
					} 
					catch (ClassNotFoundException e) 
					{
						System.out.println("Impossibile caricare oggetti");
					}
					catch (IOException e) 
					{
						System.out.println("Impossibile completare il caricamento delle visite");
					}
					catch (FileException e) 
					{
						System.out.println("File non trovato");
					}
				}
				
				break;	
			
				
				
			
		case 4:
			
			System.out.println("Visualizza elenco abbonamenti in base agli orari: "+'\n');
			try
			{
				a1=Ordinatore.selectionSortCrescenteNodi(a1);
				System.out.println("visualizzazione abbonamenti in ordine di tempo:");
				Object abbonCopia = null;
				System.out.println(abbonCopia.toString());
			} 
			catch (AbbonamentoException e)
			{
				System.out.println(e.toString());
			} catch (ClassNotFoundException e) 
			{
				System.out.println("Impossibile caricare oggetti di tipo abbonamento");
			} catch (IOException e) 
			{
				System.out.println("Impossibile completare il caricamento di abbonamenti");
			} catch (FileException e) 
			{
				System.out.println("File non trovato");
			}
			
		
			break;
		}
		}
		
		while(sceltamenu!=0);
		
	}

	private static ConsoleInput ConsoleInput() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

	
		
		

