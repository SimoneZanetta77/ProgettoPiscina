
import java.io.Serializable;
/**
 * Classe Nodo rappresenta tutti i nodi che costruiscono un abbonamento, gli attributi rappresentano
 * la componente informativa, cioè, il processo con il quale è possibile creare l'abbonamento con i suoi relativi parametri.
 * e la componente link con il nodo successivo.
 * 
 * @version 1
 * @author Zanetta Simone
 *
 */

public class Nodo implements Serializable
{
	//ATTRIBUTI
	private Abbonamento info;
	private Nodo link;
	/**
	 * @param info contiene la parte informativa, cioè l'abbonamento.
	 * @param link contiene l'indirizzo al nodo successivo.
	 */
	
	/**
	 * COSTRUTTORE. Quando si instanzia un nuovo nodo la componente link viete settata a null.
	 * @param abbonamento oggetto di tipo Abbonamento che va a costituire la parte informativa del nodo.
	 */

	
	public Nodo (Abbonamento abbonamento)
	{
		setInfo(abbonamento);
		link=null;
	}
	/**
	 * Metodo getter che restituisce la componente.
	 * @return info oggetto di tipo Abbonamento.
	 */

	public Abbonamento getInfo() 
	{
		return info;
	}
	/**
	 * Metodo setter (1): consente di settare la componenete informativa del nodo.
	 * @param info oggetto di tipo Abbonamento.
	 */
	
	public void setInfo(Abbonamento info) 
	{
		this.info = new Abbonamento(info);
	}
	/**
	 * Metodo getter: restituisce la componente link del nodo.
	 * @return link reference del prossimo oggetto nodo.
	 */
	
	public Nodo getLink() 
	{
		return link;
	}
	/**
	 * Metodo setter (2) : setta la componente link del nodo.
	 * @param link reference del prossimo oggetto nodo.
	 */
	
	public void setLink(Nodo link) 
	{
		this.link = link;
	}

}
