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
					"Zadaniem aplikacji jest przedstawienie logiki dzia³ania sklepu elektronicznego,",
					"minimalizuj¹c interfejs u¿ytkownika do wystarczaj¹cego minimum, wprowadzaj¹c",
					"modu³y konieczne do realizacji przêgl¹dania przedmiotów sprzedarzy, przeprowadzenia",
					"transakcji, przegl¹dania historii sk³adanych zamówieñ.",
					"",
					"Do realizacji projektu zastosowano s³awny wzorzec Front Controller, którego urzycie",
					"mo¿na uzasadniæ faktem, i¿ aplikacja w dzia³aniu jest bardzo podobna do aplikacji",
					"internetowej. Poza tym zastosowano takie wzorce jak: Singleton, Composite, Command",
					"oraz Adapter.",
					"",
					"Projekt zosta³ ca³kowicie wykonany w javie. Do przechowywania danych u¿yto warstwy",
					"trwa³oœci JDBC.",
					"",
					"Uczestnicy projektu:",
					"Krzysztof Abram,",
					"Daria Gruszczyñska,",
					"Agata Czerwiñska",
					"",
					"___________________________________________________________________________________",
					"(c) 2016 All right reserved"
				);
				
				mprintln("", "Naciœnij enter, aby przejœæ do menu ");
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
