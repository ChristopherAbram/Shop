package pl.edu.pk.shop;

import java.lang.reflect.Constructor;

import pl.edu.pk.shop.command.*;
import pl.edu.pk.shop.command.modules.*;
import pl.edu.pk.shop.request.*;
import static pl.edu.pk.shop.staticfunctions.Functions.*;

public class CommandResolver {
	// vars {
	
	// } methods {
		// public {
			
			public CommandResolver(){
				
			}// end CommandResolver
			
			/**
			 **/
			public Command getCommand(Request request){
				
				if(request.hasProperty(Request.MODULE)){
					String runString = request.getProperty(Request.MODULE);
					try {
						Class<?> c = Class.forName("pl.edu.pk.shop.command.modules." + runString);
						Constructor<?> construct = c.getConstructor();
						Command cmd = (Command)construct.newInstance();
						
						return cmd;
						
					} catch(Exception cnfe){
						println("CommandResolver: Can not find module...");
					}
				}
				return new Start();
			}
			
		// } protected {
			
			
			
		// } private {
			
		// }
	// }
}
