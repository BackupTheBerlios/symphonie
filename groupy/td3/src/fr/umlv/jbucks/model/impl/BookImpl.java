package fr.umlv.jbucks.model.impl;

import java.util.*;

import fr.umlv.jbucks.model.*;

/**
 * @author Remi Forax
 *
 */
public class BookImpl extends ItemImpl implements Book {

  public BookImpl(String name,Category rootCategory) {
    this.name=name;
    this.rootCategory=rootCategory;
  }

  public String getName() {
    return name;
  }
  
  public void setName(String name) {
   this.name = name; 
  }

  public List getAccounts() {
    return accounts;
  }
  
  public Category getRootCategory() {
    return rootCategory;
  }
  
  public String toString() {
    return super.toString()+"["+name+']';
  }

  private String name;
  private final Category rootCategory;
  private final List accounts=new ArrayList();
}
