package fr.umlv.jbucks.model.impl.util;

import java.util.*;

/**
 * @author Remi Forax
 *
 */
class UnmodifiableSortedSet extends AbstractSet implements SortedSet,Unmodifiable {
  public UnmodifiableSortedSet(SortedSet set) {
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

  public Iterator iterator() {
    return set.iterator();
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
    return set.headSet(toElement);
  }

  public SortedSet tailSet(Object fromElement) {
    return set.tailSet(fromElement);
  }

  public SortedSet subSet(Object fromElement, Object toElement) {
    return set.subSet(toElement, fromElement);
  }

  private final SortedSet set;
}
