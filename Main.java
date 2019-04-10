import java.util.Iterator;

public class Main {
	
	public static void main(String[] args) {
		FileOpener FileArr = new FileOpener(); //crea un nuovo oggetto di tipo FileOpener 
		FileArr.readFile(); //richiama la funzione che legge il file
		DataCounterImpl<String> Table = new DataCounterImpl<>();
		for (int i=0; i<FileArr.getFsize(); i++) {
			Table.incCount(FileArr.getElem(i)); //aggiunge gli elementi nella struttura dati DataCounter
		}
		Iterator<String> stringIterator = Table.getIterator(); //ottengo l'iteratore per iterare sulla struttura dati DataCounter
		System.out.println("Number of characters with whitespaces " + FileArr.getWCountSpace());
		System.out.println("Number of characters without whitespaces " + FileArr.getWCountnotSpace());
		System.out.println("Number of words " + FileArr.getFsize());
		while (stringIterator.hasNext()){
			String parola = stringIterator.next();
			System.out.println(parola + "\t" + Table.getCount(parola));
		}
	}
	
}
