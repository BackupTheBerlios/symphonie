package fr.umlv.jbucks.model.impl.util;

import java.util.*;

import fr.umlv.jbucks.model.*;
import fr.umlv.jbucks.model.event.PropertyEvent;
import fr.umlv.jbucks.model.impl.*;

/**
 * @author Remi Forax
 *
 */
public class ModifiableSortedSet extends AbstractSet implements SortedSet {

  public ModifiableSortedSet(Item item,Class bucksClass,String property,SortedSet set) {
    this.item=item;
    this.property=property;
    this.bucksClass=bucksClass;
    this.set=set;
  }

  public int size() {
    return set.size();
  }

  public boolean contains(Object o) {
    return set.contains(o);
  }
  
  public boolean containsAll(Collection c) {
    return set.containsAll(c);
  }

  public boolean add(Object o) {
    boolean result=set.add(o);
    if (result)
      firePropertyEvent(o, PropertyEvent.TYPE_PROPERTY_ADDED);
    return result;
  }

  public boolean remove(Object o) {
    boolean result=set.remove(o);
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
    final Iterator it=set.iterator();
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

  public Object first() {
    return set.first();
  }

  public Object last() {
    return set.last();
  }

  public Comparator comparator() {
    return set.comparator();
  }

  public SortedSet headSet(Object toElement) {
    return new ModifiableSortedSet(item,bucksClass,property,set.headSet(toElement));
  }

  public SortedSet tailSet(Object fromElement) {
    return new ModifiableSortedSet(item,bucksClass,property,set.tailSet(fromElement));
  }
  
  public SortedSet subSet(Object fromElement, Object toElement) {
    return new ModifiableSortedSet(item,bucksClass,property,set.subSet(fromElement, toElement));
  }

  private final Item item;
  private String property;
  private Class bucksClass;
  private SortedSet set;
  
  private static EventManagerImpl getEventManager() {
    return ((BuckFactoryImpl)BuckFactory.getFactory()).getEventManagerImpl();
  }
}
