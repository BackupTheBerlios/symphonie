package fr.umlv.jbucks.model.impl;

import java.util.*;

import fr.umlv.jbucks.model.EventManager;
import fr.umlv.jbucks.model.event.*;
import fr.umlv.jbucks.model.event.PropertyListener;

/**
 * @author Remi Forax
 *
 */
public class EventManagerImpl implements EventManager {
  public void addListener(Class bucksClass, String property, int eventType, PropertyListener listener) {
    HashMap properties=(HashMap)map.get(bucksClass);
    if (properties==null) {
      properties=new HashMap();
      map.put(bucksClass,properties);
    }
    
    Entry entry=(Entry)properties.get(property);
    if (entry==null) {
      entry=new Entry();
      properties.put(property,entry);
    }
    entry.add(eventType,listener);
  }

  public void removeListener(Class bucksClass, String property, PropertyListener listener) {
    HashMap properties=(HashMap)map.get(bucksClass);
    if (properties==null) {
      return;
    }
    
    Entry entry=(Entry)properties.get(property);
    if (entry==null) {
      return;
    }
    entry.remove(listener);
  }
  
  public void firePropertyEvent(Class bucksClass,PropertyEvent event) {
    HashMap properties=(HashMap)map.get(bucksClass);
    if (properties==null) {
      return;
    }
    
    Entry entry=(Entry)properties.get(event.getPropertyName());
    if (entry==null) {
      return;
    }
    entry.fire(event);
  }
  
  static class Entry {
    public Entry() {
      events=new int[3];
      listeners=new PropertyListener[3];
    }
    
    public void fire(PropertyEvent event) {
      int eventType=event.getEventType();
      int i=0;
      int length=events.length;
      for(;i<length;i++)
        if ((events[i] & eventType)!=0) {
          listeners[i].propertyChanged(event);
        }
    }
    
    public void remove(PropertyListener listener) {
      int i=0;
      int length=events.length;
      for(;i<length;i++)
        if (listeners[i]==listener) {
          events[i]=0;
          listeners[i]=null;
          break;
        }
    }
    
    public void add(int eventType,PropertyListener listener) {
      int i=0;
      int length=events.length;
      for(;i<length && events[i]!=0;i++);
      if (i==events.length) {
        enlarge(length*2+1);  
      }
      events[i]=eventType;
      listeners[i]=listener;
    }
    
    private void enlarge(int newLength) {
      int[] newEvents=new int[newLength];
      PropertyListener[] newListeners=new PropertyListener[newLength];
      
      for(int i=0;i<events.length;i++) {
        newEvents[i]=events[i];
        newListeners[i]=listeners[i];
      }
      this.events=newEvents;
      this.listeners=newListeners;
    }
    
    private int[] events;
    private PropertyListener[] listeners;
  }
  
  private final IdentityHashMap map=new IdentityHashMap();
}
