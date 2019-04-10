import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
//import java.util.Arrays;

public class FileOpener implements FileOpenerInterface {
	
	private String[] words = new String[0];
	private String list = "";
	private int dim = 0;
	private String word;
	
	public void readFile()
	{
	  try {
		  String Path = null;
		  Scanner scan = new Scanner(System.in); //inizializzo Scanner che è un semplice lettore di stringhe in input (fa il parsing dei dati)
		  System.out.println("Inserire la Path completa con nome del file (Ex: /Users/nome/cartella/file.txt)");
		  Path = scan.nextLine();
		  scan.close();
		  BufferedReader reader = new BufferedReader(new FileReader(Path)); //inizializzo BufferReader che è un lettore di stringhe complesso (non fa parsing dei dati)
		  String line;
		  while ( (line = reader.readLine()) != null) {
	      list = list + line + "\n"; //stringa contenente l'intero file
	    }
	    reader.close(); 
	    if (list!="") {
	    //System.out.println(list); se si vuole stampare l'intera stringa
	    //raplaceAll sostituisce tutto cioè che non è un carattere di una parola o _ con uno spazio
	    //split divide la stringa in un array di stringhe se trova uno o più spazi
	    words = list.trim().replaceAll("[^0-9a-zA-Zàèéìòù]"," ").toLowerCase().split("\\s+");
	    //System.out.println(Arrays.toString(words)); se si vuole stampare l'array di stringhe
	    }
	  }
	  catch (Exception e)
	  {
	    System.out.println("Exception occurred trying to read the file");
	    e.printStackTrace(); //stampa informazioni necessarie ad esempio dove avviene l'eccezione durante l'esecuzione
	    }
	}
	
	public int getWCountSpace() {
		return list.length(); //stampa la lunghezza della stringa cioè il numero di caratteri compresi quelli speciali
	}
	
	public int getWCountnotSpace() {
		String listcopied = list; //le stringhe sono immutable ne creo una copia
		listcopied = listcopied.replaceAll("\\h","").toLowerCase(); //sostituisco tutti gli spazi (\\h) con il carattere vuoto
		//System.out.println(listcopied); se voglio stampare la stringa contenente solo lettere
		return listcopied.length(); //restituisco il numero di lettere
		
	}
	
	public int getFsize() {
		dim = words.length;
		return dim; //restituisco il numero di elementi dell'array
	}
	
	public String getElem(int i) {
		word = words[i];
		return word; //restituisco l'iesimo elemento dell'array
	}
	
}
