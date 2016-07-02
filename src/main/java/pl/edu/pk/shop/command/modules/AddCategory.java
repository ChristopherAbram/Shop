package pl.edu.pk.shop.command.modules;

import static pl.edu.pk.shop.staticfunctions.Functions.getInt;
import static pl.edu.pk.shop.staticfunctions.Functions.getStringLimited;
import static pl.edu.pk.shop.staticfunctions.Functions.mprintln;
import static pl.edu.pk.shop.staticfunctions.Functions.println;
import static pl.edu.pk.shop.staticfunctions.Functions.setWidth;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import pl.edu.pk.shop.elements.category.Category;
import pl.edu.pk.shop.elements.category.CategoryData;
import pl.edu.pk.shop.request.Request;
import pl.edu.pk.shop.session.Session;

public class AddCategory extends Module {
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
					"Dodaj kategoriê:",
					"__________________________________________________________________________",
					"",
					"Drzewo kategorii:",
					""
				);
				
				Category root = new Category(1); // getting root
				root.initTree();
				String tree = __showCategoryTree(root, 0);
				
				println(tree);
				
				// Nowa kategoria:
				mprintln(
					"Podaj dane kategorii:", 
					"Jeœli chcesz dodaæ kategoriê g³ówn¹, jako ID rodzica podaj: 1",
					""
				);
				
				CategoryData data = new CategoryData();
				
				int category = getInt(setWidth("ID rodzica: ", width), setWidth("ID rodzica: ", width), true);
				data.id_parent = category;
				
				String categoryname = getStringLimited(setWidth("Nazwa: ", width), setWidth("Niepoprawna, Nazwa: ", width), 3, 20, true);
				data.categoryname = categoryname;
				
				String catdescription = getStringLimited(setWidth("Opis: ", width), setWidth("Niepoprawny, Opis: ", width), 3, 500, true);
				data.catdescription = catdescription;
				
				if(data.insert())
					mprintln("","Poprawnie dodano kategoriê!");
				else
					mprintln("", 
						"Nast¹pi³ b³¹d w trakcie dodawania nowej kategorii.", 
						"SprawdŸ, czy podajesz poprawny identyfikator rodzica (kategorii nadrzêdnej)."
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
