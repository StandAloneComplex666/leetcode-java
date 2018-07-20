class MyHashSet {

    /** Initialize your data structure here. */
    boolean[] set;
    
    public MyHashSet() {
        set = new boolean[1000000];
    }
    
    public void add(int key) {
        set[key] = true;
    }
    
    public void remove(int key) {
        set[key] = false;
    }
    
    /** Returns true if this set did not already contain the specified element */
    public boolean contains(int key) {
        return set[key];
    }
}