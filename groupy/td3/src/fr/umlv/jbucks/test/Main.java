package fr.umlv.jbucks.test;

import java.util.*;

import fr.umlv.jbucks.model.*;
import fr.umlv.jbucks.model.event.*;
import fr.umlv.jbucks.model.impl.BuckFactoryImpl;

/**
 * @author Remi Forax
 *
 */
public class Main {

  public static void main(String[] args) {
    System.setProperty("fr.umlv.jbucks.factory", BuckFactoryImpl.class.getName());
    
    BuckFactory factory=BuckFactory.getFactory();
    Book book=factory.createBook("test");
    System.out.println(book.getName());
    
    book.setUserData("hello-UID", "12345");
    System.out.println("hello-UID "+book.getUserDataValue("hello-UID"));
    
    EventManager manager=factory.getEventManager();
    
    manager.addListener(Book.class, "accounts", 
      PropertyEvent.TYPE_PROPERTY_ADDED|PropertyEvent.TYPE_PROPERTY_REMOVED,
      new PropertyListener() {
        public void propertyChanged(PropertyEvent event) {
          System.out.println(event);
        }
      });
    
    Account account=factory.createAccount(book, "remi");
    factory.createAccount(book, "gilles");
    
    List list=book.getAccounts();
    
    System.out.println(list);
    
    SortedSet transactions=account.getTransactions();
    
    manager.addListener(Account.class, "transactions", 
      PropertyEvent.TYPE_PROPERTY_ADDED|PropertyEvent.TYPE_PROPERTY_REMOVED,
      new PropertyListener() {
        public void propertyChanged(PropertyEvent event) {
          System.out.println("transaction "+event);
        }
      });
      
    Transaction transaction=factory.createTransaction(new Date().getTime(),Collections.EMPTY_LIST);
    transactions.add(transaction);
    
    SortedSet tailSet=transactions.tailSet(transaction);
    
    System.out.println(tailSet);
    
    tailSet.add(factory.createTransaction(transaction.getDate()+1,
      Collections.EMPTY_LIST));
  }
}
