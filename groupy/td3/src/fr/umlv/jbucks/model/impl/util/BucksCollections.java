package fr.umlv.jbucks.model.impl.util;

import java.util.*;

import fr.umlv.jbucks.model.Item;

/**
 * @author Remi Forax
 *
 */
public class BucksCollections {
  public static boolean isUnmodifiable(Collection collection) {
    return collection instanceof Unmodifiable;
  }
  
  public static Collection modifiable(Item item,Class bucksClass,String property,Collection collection) {
    if (collection instanceof List) {
      return modifiableList(item,bucksClass,property,(List)collection);
    }
    else
      if (collection instanceof SortedSet) {
        return modifiableSortedSet(item,bucksClass,property,(SortedSet)collection);
      }
      else
        if (collection instanceof Set) {
          return modifiableSet(item,bucksClass,property,(Set)collection);
        } else {
          return modifiableCollection(item,bucksClass,property,collection);
        }
  }
  
  public static Collection modifiableCollection(Item item,Class bucksClass,String property,Collection collection) {
    return new ModifiableCollection(item,bucksClass,property,collection);
  }
  
  public static List modifiableList(Item item,Class bucksClass,String property,List list) {
    return new ModifiableList(item,bucksClass,property,list);
  }
  
  public static Collection modifiableSet(Item item,Class bucksClass,String property,Set set) {
    return new ModifiableSet(item,bucksClass,property,set);
  }
  
  public static Collection modifiableSortedSet(Item item,Class bucksClass,String property,SortedSet set) {
    return new ModifiableSortedSet(item,bucksClass,property,set);
  }
  
  public static List unmodifiableList(List list) {
    return new UnmodifiableList(list);
  }
  
  public static Collection unmodifiableCollection(Collection collection) {
    return new UnmodifiableCollection(collection);
  }
  
  public static Collection unmodifiableSet(Set set) {
    return new UnmodifiableSet(set);
  }
  
  public static Collection unmodifiableSortedSet(SortedSet set) {
    return new UnmodifiableSortedSet(set);
  }
}
