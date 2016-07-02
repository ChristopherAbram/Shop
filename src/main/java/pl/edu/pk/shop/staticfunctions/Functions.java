package pl.edu.pk.shop.staticfunctions;

import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;

import pl.edu.pk.shop.database.Database;
import pl.edu.pk.shop.database.DatabaseException;
import pl.edu.pk.shop.database.Results;

/** Functions - a class containing methods not connected 
 * with specific responsibility. 
 * @author Christopher Abram
 **/
public final class Functions {
	// vars {
	
	// } methods {
		// public {
			
			/** Prints any object to standard output stream and append new line character.
			 * @author Christopher Abram
			 * @param Object - an object to be printed
			 **/
			public static void println(Object o){
				System.out.println(o);
				return;
			}// end println
			
			/** Prints any object to standard output stream.
			 * It does not add any characters, even new line feed.
			 * @author Christopher Abram
			 * @param Object - an object to be printed
			 **/
			public static void print(Object o){
				System.out.print(o);
				return;
			}// end print
			
			/** Prints objects to standard output stream adding new line 
			 * char after each object.
			 * @author Christopher Abram
			 * @param Object... - objects to be printed
			 **/
			public static void mprintln(Object... o){
				for(Object x : o)
					System.out.println(x);
				return;
			}// end mprintln
			
			/** Prints objects to standard output stream without new line character.
			 * @author Christopher Abram
			 * @param Object... - objects to be printed
			 **/
			public static void mprint(Object... o){
				for(Object x : o)
					System.out.print(x);
				return;
			}// end mprint
			
			public static int getNextUserId(){
				int id = -1;
				Database db = Database.getInstance();
				db.connect();
				db.query("SELECT MAX(id) as max FROM users");
				if(db.execute()){
					try {
						Results r = db.getResults();
						ListIterator<Results.Row> iter = r.listIterator();
						if(iter.hasNext()){
							Results.Row row = iter.next();
							id = Integer.parseInt(row.get("max")) + 1;
						}
					} catch(DatabaseException dbe){
						println("Error: Cannot get max id");
					}
				}
				return id;
			}
			
			public static int getNextAddressId(){
				int id = -1;
				Database db = Database.getInstance();
				db.connect();
				db.query("SELECT MAX(id) as max FROM address");
				if(db.execute()){
					try {
						Results r = db.getResults();
						ListIterator<Results.Row> iter = r.listIterator();
						if(iter.hasNext()){
							Results.Row row = iter.next();
							id = Integer.parseInt(row.get("max")) + 1;
						}
					} catch(DatabaseException dbe){
						println("Error: Cannot get max id");
					}
				}
				return id;
			}
			
			public static String setWidth(String str, int width){
				String tmp = str;
				if(tmp.length() < width){
					for(int i = tmp.length() + 1; i <= width; i++)
						tmp += " ";
				}
				return tmp;
			}// end setWidth
			
			public static int getInt(String inputMessage, String errorMessage, boolean doReapeat){
				String inputString = "";
				int integer = 0;
				boolean p = false;
				Scanner s = new Scanner(System.in);
				
				do {
					try{
						if(!p)
							print(inputMessage);
						
						if(s.hasNextLine())
							inputString = s.nextLine();
						
						integer = Integer.parseInt(inputString);
						p = false;
					} catch(NumberFormatException nfe){
						p = true;
						print(errorMessage);
					}
				} while(p && doReapeat);
				return integer;
			}// end getInt
			
			public static float getFloat(String inputMessage, String errorMessage, boolean doReapeat){
				String inputString = "";
				float _float = 0.f;
				boolean p = false;
				Scanner s = new Scanner(System.in);
				
				do {
					try{
						if(!p)
							print(inputMessage);
						
						if(s.hasNextLine())
							inputString = s.nextLine();
						
						_float = Float.parseFloat(inputString);
						p = false;
					} catch(NumberFormatException nfe){
						p = true;
						print(errorMessage);
					}
				} while(p && doReapeat);
				return _float;
			}// end getFloat
			
			public static String getString(String inputMessage, String errorMessage, int len, boolean doRepeat){
				String inputString = "";
				boolean p = false;
				Scanner s = new Scanner(System.in);
				do {
					if(!p)
						print(inputMessage);
					else
						print(errorMessage);
					
					if(s.hasNextLine())
						inputString = s.nextLine();
					p = false;
					
					if(inputString.length() > len)
						p = true;
				} while (p && doRepeat);
				return inputString;
			}// end getString
			
			public static String getStringLimited(String inputMessage, String errorMessage, int min, int max, boolean doRepeat){
				String inputString = "";
				boolean p = false;
				Scanner s = new Scanner(System.in);
				do {
					if(!p)
						print(inputMessage);
					else
						print(errorMessage);
					
					if(s.hasNextLine())
						inputString = s.nextLine();
					p = false;
					
					if(inputString.length() > max || inputString.length() < min)
						p = true;
				} while (p && doRepeat);
				return inputString;
			}// end getString
			
		// } protected {
		
		// } private {
		
		// }
	// }
}
