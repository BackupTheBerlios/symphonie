package fr.umlv.jbucks.model.impl;

import java.util.*;

import fr.umlv.jbucks.model.*;
import fr.umlv.jbucks.model.impl.util.BucksCollections;

/**
 * @author Remi Forax
 *
 */
public class TransactionImpl extends ItemImpl implements Transaction {

  public TransactionImpl(long date,List splits) {
    this.date=date;
    this.splits=Arrays.asList(splits.toArray());
  }
  
  public long getDate() {
    return date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description=description;
  }
  
  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category=category;
  }

  public List getSplits() {
    return BucksCollections.unmodifiableList(splits);
  }
  
  public String toString() {
    return super.toString()+"["+new Date(date)+']';
  }
  
  private final long date;
  private String description;
  private Category category;
  private List splits;
}
