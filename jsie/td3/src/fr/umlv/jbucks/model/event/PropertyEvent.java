package fr.umlv.jbucks.model.event;

import java.util.*;

import fr.umlv.jbucks.model.Item;

/** Event sended to PropertyListener.
 * @author Remi Forax
 * @see PropertyListener
 */
public class PropertyEvent extends EventObject {
  
  /** Event delivered whenever the state of an item's property change. 
   * @param item the object that originated the event.
   * @param propertyName the name of the property that was changed.
   */
  public PropertyEvent(Item item,String propertyName) {
    this(item,propertyName,TYPE_PROPERTY_CHANGED,EMPTY_OBJECT_ARRAY,EMPTY_INTEGER_ARRAY);
  }
  
  /** Event delivered whenever objects of a Collection or a Set
   *  are added, removed or whenever their states changed. 
   * @param item the object that originated the event.
   * @param propertyName the name of the property that was changed.
   * @param eventType one of TYPE_PROPERTY_CHANGED, TYPE_PROPERTY_ADDED
   *        or TYPE_PROPERTY_REMOVED.
   * @param subItems objetcs that was changed/added/removed.
   */
  public PropertyEvent(Item item,String propertyName,int eventType, Object[] subItems) {
    this(item,propertyName,eventType,subItems,EMPTY_INTEGER_ARRAY);
  }
  
  /** Event delivered whenever objects of a List
   *  are added, removed or whenever their states changed.
   * @param item the object that originated the event.
   * @param propertyName the name of the property that was changed.
   * @param eventType one of the following choices : TYPE_PROPERTY_CHANGED,
   *        TYPE_PROPERTY_ADDED or TYPE_PROPERTY_REMOVED
   * @param subItems objetcs that was changed/added/removed.
   * @param subIndicies indicies of the objects  that was changed/added/removed
   *        in the List.
   */
  public PropertyEvent(Item item,String propertyName,int eventType, Object[] subItems, int[] subIndicies) {
    super(item);
    this.propertyName=propertyName;
    this.eventType=eventType;
    this.subItems=subItems;
    this.subIndicies=subIndicies;
  }
  
  /** the object on which the property changes.
   * @return the object on which the property changes.
   */
  public Item getItem() {
    return (Item)getSource();
  }
  
  /** returns the name of the property that was changed.
   * @return the name of the property that was changed.
   */
  public String getPropertyName() {
    return propertyName;
  }
  
  /** returns the event type of this event.
   * @return the event type of this event.
   *  One of the following choices : TYPE_PROPERTY_CHANGED,
   *   TYPE_PROPERTY_ADDED or TYPE_PROPERTY_REMOVED
   */
  public int getEventType() {
    return eventType;
  }
  
  /** returns objects that that was added, removed or changed.
   * @return an array of objects that was added/removed/changed
   *  or an empty array.
   */
  public Object[] getSubItems() {
    return subItems;
  }
  
  /** returns indices of objects returned by {@link #getSubItems() getSubItems}.
   *  indices are defined for List and undefined for Collection or Set. 
   * @return an array of index of sub item objects or an empty array.
   */
  public int[] getSubIndicies() {
    return subIndicies;
  }
  
  /** returns a string representation of this event.
   * @return a string representation of this event.
   */
  public String toString() {
    return getClass().getName()+"[item="+getItem()+" property="+propertyName+
      " eventType="+eventType+" subItems="+Arrays.asList(subItems)+
      " subIndicies="+toString(subIndicies)+']';
  }
  
  private static String toString(int[] array) {
    StringBuffer buffer=new StringBuffer();
    buffer.append('[');
    for(int i=0;i<array.length;i++)
      buffer.append(array[i]).append(' ');
    if (array.length!=0)
      buffer.setLength(buffer.length()-1);
    return buffer.append(']').toString();
  }
    
  private final String propertyName;
  private final int eventType;
  private final Object[] subItems;
  private final int[] subIndicies;
  
  private static final int[] EMPTY_INTEGER_ARRAY=new int[0];
  private static final Object[] EMPTY_OBJECT_ARRAY=new Object[0];
  
  public final static int TYPE_PROPERTY_CHANGED=1;
  public final static int TYPE_PROPERTY_ADDED=2;
  public final static int TYPE_PROPERTY_REMOVED=4;
}
