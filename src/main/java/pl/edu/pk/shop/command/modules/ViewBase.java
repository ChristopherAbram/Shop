package pl.edu.pk.shop.command.modules;

import static pl.edu.pk.shop.staticfunctions.Functions.*;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import pl.edu.pk.shop.elements.category.Category;
import pl.edu.pk.shop.elements.item.Item;
import pl.edu.pk.shop.elements.item.ItemsList;
import pl.edu.pk.shop.elements.purchasebase.PurchaseBaseData;
import pl.edu.pk.shop.request.Request;
import pl.edu.pk.shop.session.Session;

import java.io.Console;

public class ViewBase extends Module {
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
						"Kategorie:"
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
						" 2 - wr�� do kategorii nadrz�dnej", 
						" 3 - pokaz przedmioty,", 
						" 4 - kup,",
						" 5 - wyjd�"
					);
					
					do {
						opt = getInt("Wybierz: ", "Podaj opcj� z menu jeszcze raz: ", true);
						p = false;
						if(opt < 1 || opt > 5){
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
									println("Brak przedmiot�w...");
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
						case 4:
							int itemID = getInt("Wybierz identyfikator przedmiotu: ", "Wybierz identyfikator przedmiotu: ", true);
							Item item = new Item(itemID);
							
							if(item.data != null){
								mprintln("", "", "Dane przedmiotu:");
								
								print(setWidth("Identyfikator:", 20));
								print(item.data.id);
								println("");
								
								print(setWidth("Nazwa:", 20));
								println(item.data.itemname);
								
								print(setWidth("Opis:", 20));
								println(item.data.itdescription);
								
								print(setWidth("Cena:", 20));
								println(item.data.itemprice + "  PLN");
								
								print(setWidth("Dost�pne sztuki:", 20));
								mprintln(item.data.quantity, "", "");
								
								if(item.data.quantity > 0){
									
									int q = getInt("Zamawiana liczba sztuk: ", "Zamawiana liczba sztuk: ", true);
									
									if(q <= item.data.quantity && q > 0){
										
										String confirm = getStringLimited("Czy na pewno chcesz zam�wi� ten przedmiot?(tak/nie): ","Czy na pewno chcesz zam�wi� ten przedmiot?(tak/nie): ", 3, 3, true);
										confirm = confirm.toLowerCase();
										
										if(confirm.equals("tak")){
											
											PurchaseBaseData pbd = new PurchaseBaseData();
											pbd.id_user = Session.getInstance().user.data.id;
											pbd.item = item;
											pbd.itemquantity = q;
											
											item.data.quantity = item.data.quantity - q;
											pbd.insert();
											item.data.update();
											//if(pbd.insert() && item.data.update())
											println("Poprawnie dokonano zakupu...");
											//else
											//	println("Co� posz�o nie tak, spr�buj ponownie p�niej...");
										}
									} else 
										println("Niepoprawna liczba sztuk...");
								}
								else
									mprintln("", "Brak dost�pnego towaru...");
							} 
							else
								println("Przedmiot nie istnieje...");
							
							break;
						default: // (5)
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
