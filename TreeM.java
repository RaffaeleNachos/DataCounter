import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Comparator;

public class TreeM<E extends Comparable<E>> implements DataCounter<E>{
	
	private TreeMap<E,Integer> tree;
	private int size; //dichiaro il contatore privato in modo che l'utente non sia in grado di poterlo modificare
	
	public TreeM() {
		tree = new TreeMap<>(); //attraverso il costruttore si inizializza la TreeMap a valori di default
	}
			
	public void incCount(E data) {
		if (data==null) throw new NullPointerException();
		if (tree.containsKey(data)==false) tree.put(data,1); //se la chiave non è contenuta viene inserita nell'albero e il suo contatore inizializzato a 1
		else {
			tree.put(data, tree.get(data) + 1); //se la chiave è contenuta aumento il suo contatore di 1
		}
	};
	
	public int getSize() {
		size = tree.size();
		return size; //restituisco il numero di chiavi presenti nell'albero
	}
	
	public int getCount(E data) {
		if (data==null) throw new NullPointerException();
		if (tree.containsKey(data)==true) {
			return tree.get(data); //se la chiave è presente restituisco il contatore
		}
		else {
			return 0;
		}
	}
	
	@Override
	public Iterator<E> getIterator(){
		return new NewIterator();
	}
	
	protected class NewComp implements Comparator<E> { //nuovo comparatore che fa ovverride del metodo compare secondo il metodo di ordinamento scelto
		
		@Override
		public int compare(E str1, E str2) {
			   if (tree.get(str1)>tree.get(str2)) return -1;
			   if (tree.get(str1)<tree.get(str2)) return 1;
			   //non devo comparare le due chiavi a parità di contatore perchè il metodo kesySet di TreeMap
			   //restituisce le chiavi ordinate in modo ascendente
			   else return 0;
			  }
		
	}
	
	protected class NewIterator implements Iterator<E>{
		
		Set<E> OrdSet = tree.keySet(); //salvo l'insieme delle chiavi in un oggetto di tipo Set
		ArrayList<E> listael = new ArrayList<E>(OrdSet); //sposto le chiavi in un arraylist così da poterci iterare
		
		public NewIterator() {
			listael.sort(new NewComp()); //ordino la lista utilizzando il comparatore che mi sono definito precedentemente
		}
		
		int Index=0;
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


//IR: Per ogni x | x ∈ tree.get(data) sia >0 && !=null && Integer. TreeMap!=null  && dim TreeMap>=0. 
//Per ogni (chiaveN;valoreN),(chiaveM;valoreM) -> chiaveN!=chiaveM 
//AF: Insieme di coppie di elementi chiave,valore. f(key)->val