package fr.umlv.jbucks.model.impl.util;

import java.util.*;

import fr.umlv.jbucks.model.*;
import fr.umlv.jbucks.model.BuckFactory;
import fr.umlv.jbucks.model.event.PropertyEvent;
import fr.umlv.jbucks.model.impl.*;

/**
 * @author Remi Forax
 *
 */
public class ModifiableCollection extends AbstractCollection {

  public ModifiableCollection(Item item,Class bucksClass,String property,Collection collection) {
    this.item=item;
    this.property=property;
    this.bucksClass=bucksClass;
    this.collection=collection;
  }

  public int size() {
    return collection.size();
  }

  public boolean contains(Object o) {
    return collection.contains(o);
  }
  
  public boolean containsAll(Collection c) {
    return collection.containsAll(c);
  }

  public boolean add(Object o) {
    boolean result=collection.add(o);
    if (result)
      firePropertyEvent(o, PropertyEvent.TYPE_PROPERTY_ADDED);
    return result;
  }

  public boolean remove(Object o) {
    boolean result=collection.remove(o);
    if (result)
      firePropertyEvent(o, PropertyEvent.TYPE_PROPERTY_REMOVED);
    return result;
  }

  void firePropertyEvent(Object element,int eventType) {
    PropertyEvent event=new PropertyEvent(item,property,
      eventType,new Object[] {element});
    getEventManager().firePropertyEvent(bucksClass,event);
  }
  
  public Iterator iterator() {
    final Iterator it=collection.iterator();
    return new Iterator() {
      public void remove() {
        it.remove();
        firePropertyEvent(current,PropertyEvent.TYPE_PROPERTY_REMOVED);
        current=null;
      }
      public boolean hasNext() {
        return it.hasNext();
      }

      public Object next() {
        current=it.next();
        return current;
      }
      private Object current;
    };
  }

  private final Item item;
  private String property;
  private Class bucksClass;
  private Collection collection;
  
  private static EventManagerImpl getEventManager() {
    return ((BuckFactoryImpl)BuckFactory.getFactory()).getEventManagerImpl();
  }
}
