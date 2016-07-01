package pl.edu.pk.shop.command.modules;

import static pl.edu.pk.shop.staticfunctions.Functions.*;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import pl.edu.pk.shop.elements.category.Category;
import pl.edu.pk.shop.elements.item.Item;
import pl.edu.pk.shop.elements.item.ItemsList;
import pl.edu.pk.shop.request.Request;
import pl.edu.pk.shop.session.Session;

public class GuestViewBase extends Module {
	// vars {
	
	// } methods {
		// public {
			
			
			
		// } protected {
			
			protected void _execute(Request request){
				boolean p = false;
				mprintln(
					"",
					"Categories and items:"
				);
				
				int id = 1;
				int opt = 1;
				
				Scanner s = new Scanner(System.in);
				
				outter:
				do {
					mprintln(
						"",
						"___________________________________________________________________________________",
						"Categories:"
					);
					
					Category root = new Category(id); // Getting root from database
					root.initTree();
					
					ArrayList<Category> list = root.getSubCategories();
					if(list.isEmpty())
						println("Brak kategorii...");
					else {
						ListIterator<Category> iter = list.listIterator();
						while(iter.hasNext()){
							Category c = iter.next();
							println(
								"" + setWidth("" + c.data.id, 5) + "    | " + setWidth("" + c.data.categoryname, 25)
							);
						}
					}
					
					mprintln(
						"","Wybierz:", 
						" 1 - pokaz subkategorie,", 
						" 2 - wróæ do kategorii nadrzêdnej", 
						" 3 - pokaz przedmioty,", 
						" 4 - wyjdŸ"
					);
					
					do {
						opt = getInt("Wybierz: ", "Podaj opcjê z menu jeszcze raz: ", true);
						p = false;
						if(opt < 1 || opt > 4){
							println("Nie ma takiej opcji");
							p = true;
						}
					} while(p);
					
					switch(opt){
						case 1:
							id = getInt("Wybierz identyfikator: ", "Wybierz identyfikator jeszcze raz: ", true);
							break;
						case 2:
							id = root.data.id_parent;
							break;
						case 3:
							mprintln(
								"", 
								"___________________________________________________________________________________", 
								"Przedmioty:"
							);
							
							// Loading items:
							if(root.loadItems()){
								ItemsList itemList = root.getItems();
								
								if(itemList.isEmpty())
									println("Brak przedmiotów...");
								else {
									ListIterator<Item> itemIter = itemList.listIterator();
									while(itemIter.hasNext()){
										Item item = itemIter.next();
										println("" + setWidth("" + item.data.id, 4) + 
												"     | " + setWidth(item.data.itemname, 60) + 
												"     | " + setWidth("" + item.data.itemprice, 9) + 
												" PLN | " + item.data.quantity);
									}
								}
							}
							break;
						default: // (4)
							Session.getInstance().put(Request.MODULE, "Menu");
							break outter;
					}
					
				} while(true);
				
				return;
			}
			
		// } private {
			
		// }
	// }
}
