package pl.edu.pk.shop.command.modules;

import static pl.edu.pk.shop.staticfunctions.Functions.*;

import java.util.Scanner;
import pl.edu.pk.shop.request.Request;
import pl.edu.pk.shop.session.Session;

public class AboutUs extends Module {
	// vars {
	
	// } methods {
		// public {
			
		// } protected {
			
			protected void _execute(Request request){
				
				Scanner s = new Scanner(System.in);
				
				mprintln(
					"",
					"O nas",
					"___________________________________________________________________________________",
					"",
					"Aplikacja Sklep",
					"",
					"Zadaniem aplikacji jest przedstawienie logiki dzia�ania sklepu elektronicznego,",
					"minimalizuj�c interfejs u�ytkownika do wystarczaj�cego minimum, wprowadzaj�c",
					"modu�y konieczne do realizacji prz�gl�dania przedmiot�w sprzedarzy, przeprowadzenia",
					"transakcji, przegl�dania historii sk�adanych zam�wie�.",
					"",
					"Do realizacji projektu zastosowano s�awny wzorzec Front Controller, kt�rego urzycie",
					"mo�na uzasadni� faktem, i� aplikacja w dzia�aniu jest bardzo podobna do aplikacji",
					"internetowej. Poza tym zastosowano takie wzorce jak: Singleton, Composite, Command",
					"oraz Adapter.",
					"",
					"Projekt zosta� ca�kowicie wykonany w javie. Do przechowywania danych u�yto warstwy",
					"trwa�o�ci JDBC.",
					"",
					"Uczestnicy projektu:",
					"Krzysztof Abram,",
					"Daria Gruszczy�ska,",
					"Agata Czerwi�ska",
					"",
					"___________________________________________________________________________________",
					"(c) 2016 All right reserved"
				);
				
				mprintln("", "Naci�nij enter, aby przej�� do menu ");
				if(s.hasNextLine())
					s.nextLine();
				
				Session.getInstance().put(Request.MODULE, "Menu");
				
				/*if(Session.getInstance().user.data.function.data.access_level == 0)
					Session.getInstance().put(Request.MODULE, "GuestMenu");
				else if(Session.getInstance().user.data.function.data.access_level == 1)
					Session.getInstance().put(Request.MODULE, "UserMenu");
				else if(Session.getInstance().user.data.function.data.access_level == 2)
					Session.getInstance().put(Request.MODULE, "AdminMenu");*/
				
				return;
			}// end _execute
			
		// } private {
			
		// }
	// }
}
