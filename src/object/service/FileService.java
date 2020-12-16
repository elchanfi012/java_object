package object.service;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import object.manager.ConsoleManager;
import object.model.Library;

public class FileService {
	
	private String currentPath;
	
	public FileService() {
		this.currentPath = "D:\\Documents\\CDA\\java_se\\java_object\\";
	}
	
	
	public Library readFile() {
		File file = new File(currentPath + "library.txt");
		
		
		int counter = 0;
		Library library = new Library("library");
		
		
		try(FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			){
			
				if((library = (Library) ois.readObject()) != null){
					library = (Library) ois.readObject();
					counter++;
				}
				
				/*while((library = (Library) ois.readObject()) != null) {
					clubs.add(club);
					counter++;
				}*/
				
				ConsoleManager.getInstance().consoleLineBreak();
			}catch(IOException | ClassNotFoundException e){
				if( e instanceof EOFException) {
					ConsoleManager.getInstance().printToConsole(
							"Lecture du fichier terminée, clubs lus : " + counter, true);
				}
				else {
					e.printStackTrace();
				}
		}
		
		return library != null ? library : new Library("new library");
		
	}
	
	public String getCurrentPath() {
		return currentPath;
	}


	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}


	public void writeFile(Library library) {
		
		

		
		File file = new File(currentPath + "library.txt");
		
		try(FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				){
				
				if(!file.exists()) {
					file.createNewFile();
				}
				
				 
				
				
				oos.writeObject(library);
	            

	            oos.flush();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
	}
	
}
