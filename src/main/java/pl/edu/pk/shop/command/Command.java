package pl.edu.pk.shop.command;

import pl.edu.pk.shop.request.*;

public interface Command {
	public void execute(Request request);
}
