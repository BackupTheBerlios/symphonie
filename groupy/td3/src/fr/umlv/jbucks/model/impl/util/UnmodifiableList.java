package fr.umlv.jbucks.model.impl.util;

import java.util.*;

/**
 * @author Remi Forax
 *
 */
class UnmodifiableList extends AbstractList implements Unmodifiable {
  public UnmodifiableList(List list) {
    this.list=list;
  }
  
  public Object get(int index) {
    return list.get(index);
  }

  public int size() {
   return list.size();
  }
  
  public Iterator iterator() {
		return list.iterator();
	}
  
  private final List list;
}
