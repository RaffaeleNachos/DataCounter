import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.Comparator;

public class HashT<E extends Comparable<E>> implements DataCounter<E>{
	
	private Hashtable<E,Integer> tab;
	private int size; //dichiaro il contatore privato in modo che l'utente non sia in grado di poterlo modificare
	
	public HashT() {
		tab = new Hashtable<>(); //attraverso il costruttore si inizializza la HashTable a valori di default
	}
			
	public void incCount(E data) {
		if (data==null) throw new NullPointerException();
		if (tab.containsKey(data)==false) tab.put(data,1); //se la chiave non è contenuta viene inserita nella tabella hash e il suo contatore inizializzato a 1
		else {
			tab.put(data, tab.get(data) + 1); //se la chiave è contenuta aumento il suo contatore di 1
		}
	};
	
	public int getSize() {
		size = tab.size();
		return size; //restituisco il numero di chiavi presenti nella hashtable
	}
	
	public int getCount(E data) {
		if (data==null) throw new NullPointerException();
		if (tab.containsKey(data)==true) {
			return tab.get(data); //se la chiave è presente restituisco il contatore
		}
		else {
			return 0;
		}
	}
	
	@Override
	public Iterator<E> getIterator(){
		return new NewIterator();
	}
	
	protected class NewComp implements Comparator<E> { 
		//nuovo comparatore che fa ovverride del metodo compare secondo il metodo di ordinamento scelto
		
		@Override
		public int compare(E str1, E str2) {
			   if (tab.get(str1)>tab.get(str2)) return -1;
			   if (tab.get(str1)<tab.get(str2)) return 1;
			   if (tab.get(str1).equals(tab.get(str2))) return (str1).compareTo(str2); //a parità di contatore ordino secondo la chiave
			   else return 0;
			  }
	}
	
	
	protected class NewIterator implements Iterator<E>{
		
		Set<E> KeySet = tab.keySet(); //salvo l'insieme delle chiavi della tabella hash in un oggetto di tipo Set
		ArrayList<E> listael = new ArrayList<E>(KeySet); //sposto le chiavi in un arraylist così da poterci iterare
		
		int Index;
		
		public NewIterator() {
			Index = 0;
			listael.sort(new NewComp()); //ordino la lista utilizzando il comparatore che mi sono definito precedentemente
		}
		
		@Override
        public boolean hasNext() {
            return Index < listael.size();
        }

        @Override
        public E next() {
            return listael.get(Index++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
	}
}

// IR: Per ogni x | x ∈ tab.get(data) sia >0 && !=null && Integer. HashTable!=null  && dim Hashtable>=0. 
// Per ogni (chiaveN;valoreN),(chiaveM;valoreM) -> chiaveN!=chiaveM 
// AF: Insieme di coppie di elementi chiave,valore. f(chiave)->valore