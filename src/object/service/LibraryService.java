package object.service;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import object.manager.ConsoleManager;
import object.model.Emprunt;
import object.model.Library;
import object.model.Livre;
import object.service.interfaces.MenuInterface;
import object.service.interfaces.RunnableInterface;

public class LibraryService implements RunnableInterface, MenuInterface{
	
	private FileService fileService;
	
	public LibraryService() {
		this.fileService = new FileService();
	}
	public void run() {
		
		handleActions();
		
	}
	
	public void handleActions() {
		
		boolean exit = false;
		File file = new File(this.fileService.getCurrentPath() + "library.txt");
		Library library;
		
		if(file.exists()) {
			library = this.fileService.readFile();
		}
		else {
			library = new Library("Library");
		}
		
		
		while(!exit) {
			int answer = printMenu();
			
			if (answer == 0){
				exit = true;
			}
			
			if(answer == 1) {
				listBooks(library);
			}
			 if(answer == 2) {
				 createBook(library);
				 this.fileService.writeFile(library);
			}
			 
			if(answer == 3) {
				borrowBook(library);
				this.fileService.writeFile(library);
			}
			
			if(answer == 4) {
				renderBook(library);
				this.fileService.writeFile(library);
			}
			
			if(answer == 5) {
				searchBorrowings(library);
			}
				
		}
	}
	
	public int printMenu() {
		
		int answer;
		
		do {
			ConsoleManager.getInstance().consoleLineBreak();
			ConsoleManager.getInstance().printToConsole("What do you want to do ?", true);
			ConsoleManager.getInstance().consoleLineBreak();
			
			ConsoleManager.getInstance().printToConsole("0 - Exit", true);
			ConsoleManager.getInstance().printToConsole("1 - List books", true);
			ConsoleManager.getInstance().printToConsole("2 - Create Book", true);
			ConsoleManager.getInstance().printToConsole("3 - Borrow book", true);
			ConsoleManager.getInstance().printToConsole("4 - Render book", true);
			ConsoleManager.getInstance().printToConsole("5 - Search borrowings in a period", true);
			
			
			answer = ConsoleManager.getInstance().readUserInputInteger();
		}while(answer < 0 || answer > 5);
		
		return answer;
	}
	
	public void listBooks(Library library) {
		int position = 0;
		if (library.getLivres().size() == 0) {
			ConsoleManager.getInstance().printToConsole("You do not have any registered books !", true);
		}
		else {
			for(Livre livre : library.getLivres()) {
				ConsoleManager.getInstance().printToConsole(position + " - " + livre.toString(), true);
				position++;
			}
		}
	}
	
	public void createBook(Library library) {
		
		int id, year, month, day;
		String title;
		LocalDate publishedAt;
		
		ConsoleManager.getInstance().printToConsole("What is the id of the book ?", true);
		id = ConsoleManager.getInstance().readUserInputInteger();
		
		ConsoleManager.getInstance().printToConsole("What is the title of the book ?", true);
		title = ConsoleManager.getInstance().readUserInput();
		
		ConsoleManager.getInstance().printToConsole("what is the year of publication of the book ?", true);
		year = ConsoleManager.getInstance().readUserInputInteger();
		
		ConsoleManager.getInstance().printToConsole("what is the month of publication of the book ?", true);
		month = ConsoleManager.getInstance().readUserInputInteger();
		
		ConsoleManager.getInstance().printToConsole("what is the day of publication of the book ?", true);
		day = ConsoleManager.getInstance().readUserInputInteger();
		
		publishedAt = LocalDate.of(year, month, day);
		
		library.addLivres(new Livre(id, title, publishedAt));
	}
	
	public void borrowBook(Library library) {
		int answer, nbEmprunts;
		int nbBooks = library.getLivres().size();
		Livre bookSelected;
		String name;
		
		
		
		do {
			ConsoleManager.getInstance().printToConsole("Which book will you borrow ?", true);
			listBooks(library);
			answer = ConsoleManager.getInstance().readUserInputInteger();
		}while(answer < 0 || answer > nbBooks);
		
		bookSelected = library.getLivres().get(answer);
		nbEmprunts = bookSelected.getEmprunts().size();
		
		if( nbEmprunts == 0 || bookSelected.getEmprunts().get(nbEmprunts - 1).getRenderedAt() != null) {
			ConsoleManager.getInstance().printToConsole("What is the name of borrower ?", true);
			name = ConsoleManager.getInstance().readUserInput();
			bookSelected.addEmprunt(new Emprunt(LocalDateTime.now(), null, name));
			ConsoleManager.getInstance().printToConsole(name + " borrowed the book " 
														+ "'" + bookSelected.getTitle() + "'", true);
		}
		else {
			ConsoleManager.getInstance().printToConsole("This book is not available !",true);
		}
		
		
		
	}
	
	public void renderBook(Library library) {
		int answer, nbEmprunts;
		int nbBooks = library.getLivres().size();
		Livre bookSelected;
		
		do {
			ConsoleManager.getInstance().printToConsole("Which book will you borrow ?", true);
			listBooks(library);
			answer = ConsoleManager.getInstance().readUserInputInteger();
		}while(answer < 0 || answer > nbBooks);
		
		bookSelected = library.getLivres().get(answer);
		nbEmprunts = bookSelected.getEmprunts().size();
		
		bookSelected.getEmprunts().get(nbEmprunts - 1).setRenderedAt(LocalDateTime.now());
		
		ConsoleManager.getInstance().printToConsole("The book " 
				+ "'" + bookSelected.getTitle() + "' has been rendered" , true);
		
	}
	
	public void searchBorrowings(Library library) {
		LocalDateTime startedAt, endedAt;
		int yearStart, yearEnd, monthStart, monthEnd, dayStart, dayEnd;
		boolean isDisplayable = false;
		int counter = 0;
		
		
		ConsoleManager.getInstance().printToConsole("What is the starting year ?", true);
		yearStart = ConsoleManager.getInstance().readUserInputInteger();
		
		ConsoleManager.getInstance().printToConsole("What is the starting month ?", true);
		monthStart = ConsoleManager.getInstance().readUserInputInteger();
		
		ConsoleManager.getInstance().printToConsole("What is the starting day ?", true);
		dayStart = ConsoleManager.getInstance().readUserInputInteger();
		
		startedAt = LocalDateTime.of(yearStart, monthStart, dayStart, 0, 0, 0);
		
		ConsoleManager.getInstance().printToConsole("What is the ending year ?", true);
		yearEnd = ConsoleManager.getInstance().readUserInputInteger();
		
		ConsoleManager.getInstance().printToConsole("What is the ending month ?", true);
		monthEnd = ConsoleManager.getInstance().readUserInputInteger();
		
		ConsoleManager.getInstance().printToConsole("What is the ending day ?", true);
		dayEnd = ConsoleManager.getInstance().readUserInputInteger();
		
		endedAt = LocalDateTime.of(yearEnd, monthEnd, dayEnd, 23, 59, 59);
		
		for(Livre livre : library.getLivres()) {
			for(Emprunt emprunt: livre.getEmprunts()) {
				if(emprunt.getBorrowedAt().isAfter(startedAt) && emprunt.getBorrowedAt().isAfter(endedAt)) {
					isDisplayable = true;
				}
			}
			if(isDisplayable) {
				ConsoleManager.getInstance().printToConsole(counter + " - " + livre.getTitle(), true);
				counter++;
			}
		}
	}
}
