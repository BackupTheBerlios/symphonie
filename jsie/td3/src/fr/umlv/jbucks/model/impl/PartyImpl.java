package fr.umlv.jbucks.model.impl;

import fr.umlv.jbucks.model.*;

/**
 * @author Remi Forax
 *
 */
public class PartyImpl extends ItemImpl implements Party {

  public PartyImpl(String name) {
    this.name=name;
  }
  
  public int hashCode() {
    return name.hashCode();
  }
  
  public boolean equals(Object o) {
    if (!(o instanceof Party))
      return false;
    
    return name.equals(((Party)o).getName());
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String toString() {
    return super.toString()+"["+getName()+']';
  }

  private String name;

}
