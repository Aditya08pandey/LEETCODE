class NumberContainers {
    private class NumberContainer implements Comparable<NumberContainer> {
        int index;
        int number;
        
        public NumberContainer(int index, int number) {
            this.index = index;
            this.number = number;
        }
        
        public int compareTo(NumberContainer numberContainer) {
            return Integer.compare(this.index, numberContainer.index);
        }
    }
    
    private HashMap<Integer, NumberContainer> indexCache;
    private HashMap<Integer, PriorityQueue<NumberContainer>> numberHeapCache; 
    
    public NumberContainers() {
        indexCache = new HashMap<>();
        numberHeapCache = new HashMap<>();
    }
    
    // T = O(log(n)) | S = O(1)
    public void change(int index, int number) {
        if (!numberHeapCache.containsKey(number)) {
            numberHeapCache.put(number, new PriorityQueue<>());
        }
        
        NumberContainer numberContainer;
        if (indexCache.containsKey(index)) {
            numberContainer = indexCache.get(index);
            
            if (numberContainer.number == number) {
                return;
            }
            
            numberHeapCache.get(numberContainer.number).remove(numberContainer);
            numberContainer.number = number;
        } else {
            numberContainer = new NumberContainer(index, number);
            indexCache.put(index, numberContainer);
        }
        
        numberHeapCache.get(number).add(numberContainer);
    }
    
    // T = O(1) | S = O(1)
    public int find(int number) {
        if (!numberHeapCache.containsKey(number) || numberHeapCache.get(number).isEmpty()) {
           return -1; 
        }
        
        return numberHeapCache.get(number).peek().index;
    }
}