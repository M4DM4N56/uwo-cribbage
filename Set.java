
public class Set <T>{
	private LinearNode<T> setStart;
	
	
	public Set() {
		setStart = null;
	} // method set - constructor
	
	
	public void add(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);

        if (setStart ==  null) {
            setStart = newNode; // creating node to head of link
        } // if
        
        else {
            LinearNode<T> current = setStart;
            
            while (current.getNext() !=  null) {
            	current = current.getNext(); 
            } // while
            
            current.setNext(newNode); // appends to very end of list
        } // else
    
	} // method add
	
	
    public int getLength() {
        int length = 0;
        LinearNode<T> current = setStart;
        
 
        while (current !=  null) {
            length++; // accumulating the list length
            current = current.getNext();
        } // while

        return length;
    } // method getLength
    
    
    public T getElement(int i) {
        LinearNode<T> current = setStart;
        
        for (int count = 0; count < i; count++) {
            current = current.getNext(); // loops to the desired element
        } // for

        return current.getElement();
    } // method getElement
    
    
    public boolean contains(T element) {
        LinearNode<T> current = setStart;
        
        // cycles through all nodes, trying to find one that equals element
        while (current !=  null) { 
            if (current.getElement().equals(element)) {
                return true;
            } // if
            current = current.getNext();
        } // while
        
        return false;
    } // method contains
    
    
    public String toString() {
        StringBuilder stringbit = new StringBuilder();
        LinearNode<T> current = setStart;
        
        // goes through whole linked list, appends it all
        while (current !=  null) {
        	stringbit.append(current.getElement().toString()).append(" "); 
            current = current.getNext();
        } // while
        return stringbit.toString();
    } // method toString
	


} // class set
