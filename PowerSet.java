public class PowerSet<T> {
	
    private Set<T>[] set; // set initialization
    
    
    public PowerSet(T[] elements){
        int n = elements.length;	    
        int setSize = (int) Math.pow(2, n);
        set = (Set<T>[]) new Set[setSize]; // set declaration - size of 2^n
        
        // looping through every item in the 
        for (int i = 0; i < setSize; i++){
            set[i] = new Set<T>();
            String binary = Integer.toBinaryString(i);
            int length = binary.length();
            
            if (length < n){ // using n because n is all encompassing, no binary will be larger than the number of elements itself
                for (int j = 0; j < n - length; j++){
                    binary = "0" + binary; // pads the binary with a lot of zeros
                } // for j
            } // if
            
            // looping through all of set and adding it to elements one by one
            for (int j = 0; j < n; j++){
                if (binary.charAt(j) ==  '1'){
                    set[i].add(elements[j]);
                } // if
            } // for j  
            
        } // for i
        
    } // method PowerSet
    
    
    public int getLength(){
        return set.length;
    } // method getLength
    
    
    public Set<T> getSet(int i){
        return set[i];
    } // method getSet
}