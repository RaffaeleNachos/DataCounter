import java.util.Iterator;

public interface DataCounter<E> {
	// OVERVIEW: DataCounter<E> è una collezione associa un valore numerico intero naturale a ogni oggetto di tipo E.
	// La collezione non accetta oggetti null. Non accetta inoltre valori minori o uguali di zero oppure null. 
	// DataCounter non ha dimensione fissa ma aumenta all'aumentare degli oggetti (unbounded) 
	// quindi è di tipo mutable.  
	// Typical Element : insieme [chiave1]->valore1 .... [chiaven]->valoren
	
	// _ @requires: data!=null
	// _ @modifies: this
	// _ @throws: NullPointerException se data=null
	// _ @effects: incrementa di 1 il contatore associato a data, se data non e' presente nela collezione
	// viene inizializzato a 1
	// _ @return: None
	public void incCount(E data);
	
	// _ @requires: None
	// _ @modifies: None
	// _ @throws:  None
	// _ @effects: None
	// _ @return: restituisce il numero degli elementi della collezione
	public int getSize();
	
	// _ @requires: data!=null
	// _ @modifies: None
	// _ @throws: NullPointerException se data=null
	// _ @effects: None
	// _ @return: if data è presente nella collezione return Val associato a data else 0
	public int getCount(E data);
	
	// _ @requires: None
	// _ @modifies: None 
	// _ @throws: None 
	// _ @effects: None
	// _ @return: return iteratore per la collezione senza metodo remove. Restituisce gli oggetti ordinati secondo il valore e
	// nel caso in cui i valori siano uguali ordina secondo le chiavi
	public Iterator<E> getIterator();
}