package fr.umlv.jbucks.model.impl.util;

import java.util.*;

/**
 * @author Remi Forax
 *
 */
class UnmodifiableSet extends AbstractSet implements Unmodifiable {
  public UnmodifiableSet(Set set) {
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

  private final Set set;
}
