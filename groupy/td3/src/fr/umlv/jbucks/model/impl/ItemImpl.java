package fr.umlv.jbucks.model.impl;

import java.util.*;

import fr.umlv.jbucks.model.Item;

/**
 * @author Remi Forax
 *
 */
public class ItemImpl implements Item {

  public void setUserData(String userDataKey, Object userDataValue) {
    if (userDataKey==null)
      throw new IllegalArgumentException("userDataKey cannot be null");
    
    if (datas==null) {
      Object[] array=new Object[MAX_ARRAY_SIZE];
      array[0]=userDataKey;
      array[1]=userDataValue;
      datas=array;
      return;
    }
    if (datas instanceof Object[]) {
      Object[] array=(Object[])datas;
      for(int i=0;i<array.length;i+=2) {
        Object prop=array[i];
        if (prop==null) {
          array[i]=userDataKey;
          array[i+1]=userDataValue;
          return;
        }
        if (prop.equals(userDataKey)) {
          array[i+1]=userDataValue;
          return;
        }
      }
      HashMap map=new HashMap();
      for(int i=0;i<array.length;i+=2)
        map.put(array[i],array[i+1]);
      map.put(userDataKey,userDataValue);
      datas=map;
      return;
    }
    HashMap map=(HashMap)datas;
    map.put(userDataKey,userDataValue);
  }


  public Object getUserDataValue(String userDataKey) {
    if (userDataKey==null)
      throw new IllegalArgumentException("userDataKey cannot be null");
    
    if (datas==null)
      return null;
    if (datas instanceof Object[]) {
      Object[] array=(Object[])datas;
      for(int i=0;i<array.length;i+=2) {
        Object prop=array[i];
        if (prop==null)
          return null;
        if (prop.equals(userDataKey))
          return array[i+1];
      }
      return null;
    } else {
      HashMap map=(HashMap)datas;
      return map.get(userDataKey);
    }
  }

  
  public Object removeUserData(String userDataKey) {
    if (userDataKey==null)
      throw new IllegalArgumentException("userDataKey cannot be null");
    if (datas==null)
      return null;
    if (datas instanceof Object[]) {
      Object[] array=(Object[])datas;
      for(int i=0;i<array.length;i+=2) {
        Object prop=array[i];
        if (prop==null)
          return null;
        if (prop.equals(userDataKey)) {
          return removeAtIndex(i,array);
        }
      }
      return null;
    } else {
     return ((HashMap)datas).remove(userDataKey); 
    }
  }
  
  static Object removeAtIndex(int i,Object[] array) {
    Object found = array[i+1];
    if (i!=array.length-2)
      System.arraycopy(array, i+2, array, i, array.length-i-2);
    else {
      array[i]=null;
      array[i+1]=null;
    }
    return found;
  }
  
  /* implementation note: iterators are not fail-fast !!
   */
  public Set getUserDataKeys() {
    return new AbstractSet() {
      public int size() {
        if (datas==null)
          return 0;
        if (datas instanceof Object[])
          return ((Object[])datas).length/2;
        return ((HashMap)datas).size();
      }
      
      public boolean contains(Object userDataKey) {
        return getUserDataValue((String)userDataKey)!=null;   
			}

      public Iterator iterator() {
        if (datas==null)
          return Collections.EMPTY_SET.iterator();
        if (datas instanceof Object[]) {
          final Object[] array=(Object[])datas;
          return new Iterator() {
            public void remove() {
              removeAtIndex(index-2,array);
            }
            public boolean hasNext() {
              return index<array.length;
            }

            public Object next() {
              Object property=array[index];
              index+=2;
              return property;
            }
            private int index=0;
          };
        }
        HashMap map=(HashMap)datas;
        return map.keySet().iterator();
      }
    };
  }

  Object datas;
  
  private final static int MAX_ARRAY_SIZE=6;


}
