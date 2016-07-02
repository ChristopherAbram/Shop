package pl.edu.pk.shop.command.modules;

import static pl.edu.pk.shop.staticfunctions.Functions.*;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import pl.edu.pk.shop.elements.category.Category;
import pl.edu.pk.shop.elements.item.Item;
import pl.edu.pk.shop.elements.item.ItemData;
import pl.edu.pk.shop.request.Request;
import pl.edu.pk.shop.session.Session;

public class AddItem extends Module {
	// vars {
	
	// } methods {
		// public {
			
			
			
		// } protected {
			
			protected void _execute(Request request){
				
				Scanner s = new Scanner(System.in);
				boolean p = false;
				int width = 25;
				mprintln(
					"",
					"Dodaj przedmiot:",
					"__________________________________________________________________________",
					"",
					"Lista kategorii:",
					""
				);
				
				Category root = new Category(1); // getting root
				root.initTree();
				String tree = __showCategoryTree(root, 0);
				
				println(tree);
				
				// Dodawanie przedmiotu:
				mprintln("", "", "Podaj dane przedmiotu:","");
				
				ItemData data = new ItemData();
				
				int category = getInt(setWidth("ID kategorii: ", width), setWidth("ID kategorii: ", width), true);
				data.id_category = category;
				
				String itemname = getStringLimited(setWidth("Nazwa: ", width), setWidth("Niepoprawna, Nazwa: ", width), 3, 100, true);
				data.itemname = itemname;
				
				String itdescription = getStringLimited(setWidth("Opis: ", width), setWidth("Niepoprawny, Opis: ", width), 3, 500, true);
				data.itdescription = itdescription;
				
				float price = 0.f;
				do {
					price = getFloat(setWidth("Cena: ", width), setWidth("Niepoprawna, Cena: ", width), true);
					p = false;
					if(price <= 0.f){
						p = true;
						println("Niepoprawna cena...");
					}
				} while(p);
				data.itemprice = price;
				
				int q = 0;
				do {
					q = getInt(setWidth("Liczba sztuk: ", width), setWidth("Liczba sztuk: ", width), true);
					p = false;
					if(q <= 0){
						p = true;
						println("Niepoprawna liczba sztuk...");
					}
				} while(p);
				data.quantity = q;
				
				// Inserting item to database:
				if(data.insert())
					println("Dodano nowy przedmiot do bazy!");
				else
					mprintln(
						"Dodanie przedmiotu do bazy siê nie powiod³o. Spróbuj jeszcze raz.",
						"SprawdŸ, czy podajesz poprawny identyfikator kategorii."
					);
				
				mprintln("","Naciœnij enter, aby przejœæ do menu ");
				if(s.hasNextLine())
					s.nextLine();
				Session.getInstance().put(Request.MODULE, "Menu");
				
				return;
			}
			
		// } private {
			
			private String __showCategoryTree(Category root, int level){
				String tree = "";
				
				String sep = "";
				for(int i = 0; i < level; ++i)
					sep += "  ";
				
				if(root.data.id != 1) // excluding root
					tree += sep + setWidth("" + root.data.id, 4) + " | " + setWidth("" + root.data.categoryname, 25) + "\n";
				
				ArrayList<Category> list = root.getSubCategories();
				ListIterator<Category> iter = list.listIterator();
				while(iter.hasNext()){
					Category sub = iter.next();
					tree += __showCategoryTree(sub, level + 1);
				}
				
				return tree;
			}// end showCategoryTree
			
		// }
	// }
}
