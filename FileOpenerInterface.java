public interface FileOpenerInterface {
	/* OVERVIEW: FileOpener è una classe in grado di aprire un file e ottenere svariati dati su di esso. Ad esempio
	 * il numero di caratteri oppure il numero di parole (che possono ripetersi) contenute nel file. E' possibile
	 * inoltre ottenere l'iesima parola del file.
	 */
		
	// _ @requires: none
	// _ @modifies: none
	// _ @throws: I/O Exception
	// _ @effects: prende in input (da terminale) un file di testo e inserisce ogni parola normalizzata in una struttura dati
	public void readFile();
	
	// _ @requires: none
	// _ @modifies: none
	// _ @throws: none
	// _ @effects: none
	// _ @return: restituisce il numero di caratteri compresi i caratteri speciali
	public int getWCountSpace();
	
	// _ @requires: none
	// _ @modifies: none
	// _ @throws: none
	// _ @effects: none
	// _ @return: restituisce il numero di caratteri compresi esclusi gli spazi
	public int getWCountnotSpace();
	
	// _ @requires: none
	// _ @modifies: none
	// _ @throws: none
	// _ @effects: none
	// _ @return: restituisce il numero di parole differenti contenute nel file
	public int getFsize();
	
	// _ @requires: none
	// _ @modifies: none
	// _ @throws: none
	// _ @effects: none
	// _ @return: restituisce la i-esima stringa della struttura dati
	public String getElem(int i);
	
}
