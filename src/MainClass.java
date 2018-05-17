import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainClass {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		LocalDateTime dataOra1=LocalDateTime.of(2018 , 5, 14, 8, 0,0);
		LocalDateTime dataOra2=LocalDateTime.of(2018 , 5, 14, 9, 0,0);
		LocalDateTime dataOra3=LocalDateTime.of(2018 , 5, 14, 10, 0,0);
		
		Abbonamento p1=new Abbonamento(1,"zio","fabio",1,dataOra1);
		Abbonamento p2=new Abbonamento(2,"zio","andrea",1,dataOra2);
		Abbonamento p3=new Abbonamento(2,"zio","gio",1,dataOra3);
		
		GestioneAbbonamento abbonamento=new GestioneAbbonamento();
		
		
		try
		{
			Abbonamento a1 = null;
			abbonamento.registraAbbonamento(a1);
		} 
		catch (AbbonamentoException e) 
		{
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		try
		{
			Abbonamento a2 = null;
			abbonamento.registraAbbonamento(a2);
		} 
		catch (AbbonamentoException e) 
		{
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		try
		{
			Abbonamento a3 = null;
			abbonamento.registraAbbonamento(a3);
		} 
		catch (AbbonamentoException e) 
		{
			
			System.out.println(e.toString());
		}
	
	
	}

}

