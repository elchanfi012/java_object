package object.service;

import object.manager.ConsoleManager;

public class MenuService {
	
	public void run() {
		handleActions();
	}
	
	public void handleActions() {
		
		boolean exit = false;
		
		
		
		while(!exit) {
			int answer = printMenu();
			
			if (answer == 0){
				exit = true;
			}
			
			if(answer == 1) {
				ContainsService contains = new ContainsService();
				contains.run();
			}
			 if(answer == 2) {
				CompareService compare = new CompareService();
				compare.run();
			}
			 if(answer == 3) {
				
			}
				
		}
	}
	
	public int printMenu() {
		
		int answer;
		
		do {
			ConsoleManager.getInstance().printToConsole("Which service do you want to call ?", true);
			ConsoleManager.getInstance().consoleLineBreak();
			
			ConsoleManager.getInstance().printToConsole("0 - Exit", true);
			ConsoleManager.getInstance().printToConsole("1 - Contains Service", true);
			ConsoleManager.getInstance().printToConsole("2 - Compare Service", true);
			ConsoleManager.getInstance().printToConsole("3 - Date Service", true);
			
			answer = ConsoleManager.getInstance().readUserInputInteger();
		}while(answer < 0 || answer > 3);
		
		return answer;
	}
}
