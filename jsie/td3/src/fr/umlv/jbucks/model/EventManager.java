package fr.umlv.jbucks.model;

import fr.umlv.jbucks.model.event.PropertyListener;

/** 
 * @author Remi Forax
 *
 */
public interface EventManager {
  /** register a listener on an item class property.
   * @param itemClass interface of the item (all Item subinterfaces).
   * @param property property name (property named foo is obtained with
   * getFoo method, and changed with setFoo).
   * @param eventType bitwise OR of events type the listener wants to be
   * notified of. Events type are PropertyEvent.TYPE_PROPERTY_CHANGED,
   *   PropertyEvent.TYPE_PROPERTY_ADDED and PropertyEvent.TYPE_PROPERTY_REMOVED.
   * @param listener the event listener.
   */
  public abstract void addListener(Class itemClass,String property,int eventType,PropertyListener listener);
  
  /** removes a previously registered listener.
   * @param itemClass the item class.
   * @param property the property name.
   * @param listener listener to unregister.
   * @see #addListener(Class,String,int,PropertyListener)
   */
  public abstract void removeListener(Class itemClass,String property,PropertyListener listener);
}
