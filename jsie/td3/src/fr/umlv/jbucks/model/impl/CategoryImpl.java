package fr.umlv.jbucks.model.impl;

import java.util.*;

import fr.umlv.jbucks.model.*;

/**
 * @author Remi Forax
 *
 */
public class CategoryImpl extends ItemImpl implements Category {

  public CategoryImpl(Category parent,String name) {
    this.name=name;
    this.parent=parent;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name=name;
  }
  
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description=description;
  }

  public List getSubCategories() {
    return subCategories;
  }

  public Category getParent() {
    return parent;
  }
 
  public String toString() {
    StringBuffer buffer=new StringBuffer();
    for(Category cat=this;cat!=null;cat=cat.getParent())
      buffer.insert(0, cat.getName()+':');
    buffer.setLength(buffer.length()-1);
    
    return super.toString()+" ["+buffer+']';
  }
 
  private String name;
  private String description;
  private final Category parent;
  private final ArrayList subCategories=new ArrayList();
}
