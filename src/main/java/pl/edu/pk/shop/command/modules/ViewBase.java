package pl.edu.pk.shop.command.modules;

import static pl.edu.pk.shop.staticfunctions.Functions.*;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import pl.edu.pk.shop.elements.category.Category;
import pl.edu.pk.shop.request.Request;
import pl.edu.pk.shop.session.Session;

import java.io.Console;

public class ViewBase extends Module {
	// vars {
	
	// } methods {
		// public {
			
			
			
		// } protected {
			
			protected void _execute(Request request){
				
				mprintln(
					"",
					"Categories and items:",
					"___________________________________________________________________________________",
					"",
					"Categories:"
				);
				
				int id = 1;
				int opt = 1;
				
				Scanner s = new Scanner(System.in);
				
				do {
					Category root = new Category(id); // Getting root from database
					root.initTree();
					
					ArrayList<Category> list = root.getSubCategories();
					ListIterator<Category> iter = list.listIterator();
					int i = 1;
					while(iter.hasNext()){
						
						Category c = iter.next();
						println(
							"" + c.data.id + "    | " + c.data.categoryname
						);
						
					}
					
					println("Wybierz: 1 - pokaz subkategorie, 2 - pokaz przedmioty, 3 kup przedmiot");
					print("Wybierz: ");
					opt = s.nextInt();
					
					if(opt == 1){
						print("Wybierz identyfikator: ");
						
					}
					
				} while(opt == 1);
				
				//if(opt)
				
				return;
			}
			
		// } private {
			
		// }
	// }
}
