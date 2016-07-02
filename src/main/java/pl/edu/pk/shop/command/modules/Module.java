package pl.edu.pk.shop.command.modules;

import pl.edu.pk.shop.command.Command;
import pl.edu.pk.shop.request.Request;

public abstract class Module implements Command {
	// vars {
		
	// } methods {
		// public {
			
			public void execute(Request request){
				try {
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				} catch(Exception e){
					
				}
				this._execute(request);
				return;
			}
			
		// } protected {
			
			protected abstract void _execute(Request request);
			
		// } private {
			
		// }
	// }
}