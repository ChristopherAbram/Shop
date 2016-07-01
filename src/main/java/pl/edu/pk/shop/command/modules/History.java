package pl.edu.pk.shop.command.modules;

import static pl.edu.pk.shop.staticfunctions.Functions.*;

import java.util.ListIterator;
import java.util.Scanner;

import pl.edu.pk.shop.database.Database;
import pl.edu.pk.shop.database.Results;
import pl.edu.pk.shop.elements.item.Item;
import pl.edu.pk.shop.elements.purchasebase.PurchaseBase;
import pl.edu.pk.shop.request.Request;
import pl.edu.pk.shop.session.Session;

public class History extends Module {
	// vars {
		
	// } methods {
		// public {
			
		// } protected {
			
			protected void _execute(Request request){
				
				Scanner s = new Scanner(System.in);
				
				mprintln(
					"",
					"Historia zamówieñ",
					""
				);
				
				Database db = Database.getInstance();
				db.connect();
				db.query("SELECT id FROM purchase_base WHERE id_user = ? ORDER BY b_date DESC");
				db.prepare(Session.getInstance().user.data.id);
				if(db.execute()){
					
					float sum = 0.f;
					
					Results res = db.getResults();
					ListIterator<Results.Row> iter = res.listIterator();
					while(iter.hasNext()){
						Results.Row row = iter.next();
						int pID = Integer.parseInt(row.get("id"));
						
						PurchaseBase pb = new PurchaseBase(pID);
						String order = showOrder(pb);
						
						sum += pb.data.itemquantity * pb.data.item.data.itemprice;
						
						println(order);
					}
					println("-----------------------------------------------------------------------------------");
					println("£¹czna cena zamówieñ: " + sum);
					println("-----------------------------------------------------------------------------------");
				}
				else
					println("Nast¹pi³ nieoczekiwany b³¹d...");
				
				
				mprintln("", "Naciœnij enter, aby przejœæ do menu ");
				if(s.hasNextLine())
					s.nextLine();
				Session.getInstance().put(Request.MODULE, "Menu");
				
				return;
			}// end _execute
			
		// } private {
			
			public String showOrder(PurchaseBase pb){
				String str;
				Item item = pb.data.item;
				
				str = "--| " + pb.data.b_date + " |-------------------------------------------------------------\n\n";
				
				str += "Dane przedmiotu:\n";
				str += setWidth("Identyfikator:", 25) + item.data.id + "\n";
				str += setWidth("Nazwa:", 25) + item.data.itemname + "\n";
				str += setWidth("Opis:", 25) + item.data.itdescription + "\n";
				str += setWidth("Cena:", 25) + item.data.itemprice + "\n\n";
				
				str += setWidth("Zamówiona liczba sztuk:", 25) + pb.data.itemquantity + "\n";
				str += setWidth("£¹czna cena:", 25) + pb.data.itemquantity * item.data.itemprice + "\n";
				
				return str;
			}// end showOrder
			
		// }
	// }
}
