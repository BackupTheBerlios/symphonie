import java.util.ArrayList;

/**
 * Created on 28 janv. 2005
 *@author jsie
 */

public class MyStack<V> implements Stack<V> {
    private final ArrayList<V> stack;
    
    public MyStack(){
        stack = new ArrayList<V>();
    }
    
    public boolean isEmpty(){
        assert stack!=null : "unable to test size on null list";
        return (stack.size() == 0);
    }
    
    public void push(V value){
        if(value == null)
            throw new IllegalArgumentException("unable to add a null value into the stack");
        
        assert isEmpty() == false : "stack is empty"; 
        
        int oldSize = stack.size();
        
        stack.add(value);
        
        assert (stack.size() == (oldSize+1)) : "value cannot be added";
        
        if(stack.contains(value) == false)
            throw new IllegalStateException("method push() did not add value into the stack");
    }
    
    public V pop(){
       if(isEmpty())
           throw new IllegalStateException("cannot pop something from an empty stack");
       
       int oldSize = stack.size();
       
       V value = stack.remove(stack.size()-1);
       
       assert stack.size() == oldSize-1 : "value cannot be removed";
       
       return value;
       
    }
}
