package fr.umlv.jbucks.model.impl;

import java.util.*;

import fr.umlv.jbucks.model.*;

/**
 * @author Remi Forax
 *
 */
public class AccountImpl extends PartyImpl implements Account {

  public AccountImpl(Book book,String name) {
    super(name);
    this.book=book;
  }

  public Book getBook() {
    return book;
  }
  
  public SortedSet getTransactions() {
    return transactions;
  }

  private final Book book;
  private final TreeSet transactions=new TreeSet(new Comparator() {
    public int compare(Object o1, Object o2) {
      Transaction t1=(Transaction)o1;
      Transaction t2=(Transaction)o2;
      long diff = t1.getDate()-t2.getDate();
      if (diff < 0)
        return -1;
      else
        if (diff>0)
          return 1;
        else 
          return t1.hashCode() - t2.hashCode();
    }
  });
}
