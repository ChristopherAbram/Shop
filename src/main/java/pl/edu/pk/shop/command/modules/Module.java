package pl.edu.pk.shop.command.modules;

import pl.edu.pk.shop.command.Command;
import pl.edu.pk.shop.request.Request;
import java.io.Console;

public abstract class Module implements Command {
	// vars {
		
	// } methods {
		// public {
			
			public void execute(Request request){
				this._execute(request);
				return;
			}
			
		// } protected {
			
			protected abstract void _execute(Request request);
			
		// } private {
			
		// }
	// }
}