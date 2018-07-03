
Created at: a day ago

amby_leet_code
amby_leet_code
 0
We first put all the iterators in queue. After that, we exhaust the first iterator and remove it from the queue & so forth.

public class Vector2D implements Iterator<Integer> {

    Queue<Iterator<Integer>> queue;
    
    public Vector2D(List<List<Integer>> vec2d) {
        queue = new LinkedList<Iterator<Integer>>();
        for(List<Integer> list:vec2d){
            if(!list.isEmpty())
                queue.add(list.iterator());
        }        
    }

    @Override
    public Integer next() {
        
        Iterator<Integer> it = queue.peek();
        Integer result = it.next();
        if(!it.hasNext())
            queue.remove();
        return result;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}