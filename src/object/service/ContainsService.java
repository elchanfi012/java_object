package object.service;

import java.util.ArrayList;
import java.util.List;

import object.manager.ConsoleManager;
import object.model.Book;

public class ContainsService {
	
	public void run() {
		List<Book> books = new ArrayList<Book>();
		Book book1 = new Book(1,"Book1", "desc1");
		books.add(book1);
		Book book2 = new Book(2,"Book2", "desc2");
		books.add(book2);
		Book book3 = new Book(3,"Book3", "desc3");
		books.add(book3);
		Book book4 = new Book(4,"Book4", "desc4");
		books.add(book4);
		Book book5 = new Book(5,"Book5", "desc5");
		books.add(book5);
		
		for(Book book : books) {
			ConsoleManager.getInstance().printToConsole(book.toString(), true);
		}
		ConsoleManager.getInstance().consoleLineBreak();
		
		
		Book bookToRemove = new Book(3, "BookToRemove", "descToRemove");
		
		if(books.contains(bookToRemove)) {
			ConsoleManager.getInstance().printToConsole("book3 is here", true);
		}
		
		ConsoleManager.getInstance().printToConsole("Goodbye poor book3", true);
		books.remove(bookToRemove);
		
		if(!books.contains(bookToRemove)) {
			ConsoleManager.getInstance().printToConsole("book3 is not here", true);
		}
		
		ConsoleManager.getInstance().consoleLineBreak();
		for(Book book : books) {
			ConsoleManager.getInstance().printToConsole(book.toString(), true);
		}
	}
}
