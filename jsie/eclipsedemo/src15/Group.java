
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Group {
	private String name;
	private Group parent;
	Collection<Group> subGroups;
	
    public Group(String name){
    	this.name = name;
    	parent = null;
    	subGroups = new ArrayList<Group>();
    }
    public Group(Group parent,String name){
    	this.name = name;
    	this.parent = parent;
    	parent.addSubGroup(this);
    	subGroups = new ArrayList<Group>();
    }
    public String getName(){
    	return name;
    }
    public Group getParent(){
    	return parent;
    }
    public void addSubGroup(Group group){
        group.parent = this;
    	subGroups.add(group);
    }
    public Collection<Group> getSubGroups(){
    	return Collections.unmodifiableCollection(subGroups);
    }
    /*to implement*/
    public Collection<Group> getSubGroups(final String startPattern){
        Collection<Group> col = new AbstractCollection<Group>(){
            
            public Iterator<Group> iterator(){
                return new Iterator<Group>(){
                    private Group current = null;
                    private Iterator<Group> iterator = subGroups.iterator();
                    
                    public boolean hasNext(){
                        if(!iterator.hasNext())
                            return false;
                        if(current != null)
                            return true;
                        
                        while(iterator.hasNext()){
                            current = iterator.next();
                            if(current.getName().startsWith(startPattern))
                               return true;
                        }                       
                        return false;
                    }
                    
                    public Group next(){
                        if(!iterator.hasNext())
                           throw new NoSuchElementException();
                        Group next = current;
                        current = null;
                        return next;
                    }
                    
                    public void remove(){
                        System.out.println("call remove method");
                        throw new UnsupportedOperationException();
                    }
                };
               
            }
            
            public int size(){
                int i = 0;
                Iterator<Group> iterator = iterator();
                while(iterator.hasNext()){
                    iterator.next();
                    i++;
                }
                return i;
            }
        };
        return col;
    }
  }
