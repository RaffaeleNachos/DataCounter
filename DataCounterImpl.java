//public class DataCounterImpl<E extends Comparable<E>> extends TreeM<E>
public class DataCounterImpl<E extends Comparable<E>> extends HashT<E>{
	public DataCounterImpl(){ //metodo costruttore di DataCounterImpl
		super(); //richiamo il metodo costruttore di TreeM o HashT che inzializzano rispettivamente una TreeMap o HashTable
	}
}
