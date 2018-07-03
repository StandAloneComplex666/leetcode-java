//version 1:

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

//version 2:
public class Vector2D implements Iterator<Integer> {
    
    private int indexElement;
    private int indexList;
    private List<List<Integer>> list;
    
    public Vector2D(List<List<Integer>> vec2d) {
        list = vec2d;
        indexElement = 0;
        indexList = 0;
    }

    @Override
    public Integer next() {
        return list.get(indexList).get(indexElement++);
    }

    @Override
    public boolean hasNext() {
        while(indexList < list.size()){
            if(indexElement < list.get(indexList).size()){
                return true;
            }
            else{
                indexList++;
                indexElement = 0;
            }
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */