package pl.edu.pk.shop.command.modules;

import static pl.edu.pk.shop.staticfunctions.Functions.*;
import java.util.Scanner;

import pl.edu.pk.shop.elements.user.*;
import pl.edu.pk.shop.request.Request;
import pl.edu.pk.shop.session.Session;

public class Login extends Module {
	
	// vars {
	
	// } methods {
		// public {
				
				
				
		// } protected {
				
			protected void _execute(Request request){
				
				// Ekran powitalny:
				mprintln(
					" Aby sie zalogowac wpisz swoj login i haslo",
					" Aby skorzystaæ z aplikacji jako gosc, wpisz jako login: guest (nie wymaga hasla)",
					"___________________________________________________________________________________"
				);
				
				Scanner s = new Scanner(System.in);
				
				// Enter login and password:
				int id = -1;
				do {
					String login = "";
					String password = "";
					
					println("");
					print("Login: ");
					login = new String(s.nextLine().trim());
					
					if(!login.equals(new String("guest"))){
						print("password: ");
						password = new String(s.nextLine().trim());
						
						// Autoryzacja:
						id = User.authentication(login, password);
					} else 
						id = 0;
					
					if(id == -1)
						println("Nie ma takiego uzytkownika, sprobuj ponownie");
					
				} while (id < 0);
				
				//s.close();
				
				// Konkretyzacja u¿ytkownika:
				UserData data = new UserData(id);
				
				if(data.function != null){
					if(data.function.data.access_level == 2)
						Session.getInstance().user = new Admin(id);
					else if(data.function.data.access_level == 1)
						Session.getInstance().user = new Client(id);
					else if(data.function.data.access_level == 0)
						Session.getInstance().user = new Guest(id);
					else {
						println("Error: unknown user");
						this._execute(request);
					}
					
					Session.getInstance().put(Request.GUEST, "0");
					if(data.function.data.access_level == 0){
						Session.getInstance().put(Request.MODULE, "GuestMenu");
						Session.getInstance().put(Request.GUEST, "1");
					}
					else {
						Session.getInstance().put(Request.LOGGED, "1");
						Session.getInstance().put(Request.MODULE, "UserStart");
					}
				} else {
					println("Error: Can not resolve user type");
					this._execute(request);
				}
				return;
			}
				
		// } private {
				
		// }
	// }
}
