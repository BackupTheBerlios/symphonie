package fr.umlv.jbucks.model.impl.util;

import java.util.*;

import fr.umlv.jbucks.model.*;
import fr.umlv.jbucks.model.event.PropertyEvent;
import fr.umlv.jbucks.model.impl.*;

/**
 * @author Remi Forax
 *
 */
class ModifiableList extends AbstractList {
  public ModifiableList(Item item,Class bucksClass,String property,List list) {
    this.item=item;
    this.property=property;
    this.bucksClass=bucksClass;
    this.list=list;
  }
  
  public Object get(int index) {
    return list.get(index);
  }

  public int size() {
   return list.size();
  }
  
  public void add(int index, Object element) {
    list.add(index,element);
    firePropertyEvent(element,index,PropertyEvent.TYPE_PROPERTY_ADDED);
  }
  
  public Object remove(int index) {
    Object element=list.remove(index);
    firePropertyEvent(element,index,PropertyEvent.TYPE_PROPERTY_REMOVED);
    return element;
  }
  
  public Object set(int index, Object element) {
    Object previous=list.set(index, element);
    firePropertyEvent(element,index,PropertyEvent.TYPE_PROPERTY_CHANGED);
    return previous;
  }
  
  void firePropertyEvent(Object element,int index,int eventType) {
    PropertyEvent event=new PropertyEvent(item,property,
      eventType,new Object[] {element},new int[]{index});
    getEventManager().firePropertyEvent(bucksClass,event);
  }
  
  public ListIterator listIterator(int index) {
    final ListIterator it=list.listIterator(index);
    return new ListIterator() {
      public int nextIndex() {
        return it.nextIndex();
      }
      public int previousIndex() {
        return it.previousIndex();
      }
      public boolean hasNext() {
        return it.hasNext();
      }
      public boolean hasPrevious() {
        return it.hasPrevious();
      }
      public Object next() {
        currentIndex=it.nextIndex();
        current=it.next();
        return current;
      }
      public Object previous() {
        currentIndex=it.previousIndex();
        current=it.previous();
        return current;
      }
      public void remove() {
        it.remove();
        firePropertyEvent(current,currentIndex,PropertyEvent.TYPE_PROPERTY_REMOVED);
        currentIndex=-1;
        current=null;
      }
      public void add(Object o) {
        it.add(o);
        firePropertyEvent(o,currentIndex,PropertyEvent.TYPE_PROPERTY_REMOVED);
        currentIndex=-1;
        current=null;
      }
      public void set(Object o) {
        it.set(o);
        firePropertyEvent(o,currentIndex,PropertyEvent.TYPE_PROPERTY_CHANGED);
        currentIndex=-1;
        current=null;
      }
      private Object current;
      private int currentIndex;
    };
  }

  
  public Iterator iterator() {
    return listIterator();
  }

  
  private final Item item;
  private final String property;
  private final Class bucksClass;
  
  private final List list;
  
  private static EventManagerImpl getEventManager() {
    return ((BuckFactoryImpl)BuckFactory.getFactory()).getEventManagerImpl();
  }
}
