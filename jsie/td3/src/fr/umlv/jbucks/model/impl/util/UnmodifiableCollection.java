package fr.umlv.jbucks.model.impl.util;

import java.util.*;

/**
 * @author Remi Forax
 *
 */
class UnmodifiableCollection extends AbstractCollection implements Unmodifiable {
  public UnmodifiableCollection(Collection collection) {
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

  public Iterator iterator() {
    return collection.iterator();
  }

  private final Collection collection;
}
