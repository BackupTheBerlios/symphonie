package fr.umlv.jbucks.model.impl;

import java.lang.reflect.Proxy;
import java.util.*;

import fr.umlv.jbucks.model.*;
import fr.umlv.jbucks.model.BuckFactory;

/**
 * @author Remi Forax
 *
 */
public class BuckFactoryImpl extends BuckFactory {

  public Book createBook(String name) {
    Category rootCategory=(Category)createProxy(Category.class,new CategoryImpl(null,"root"));
    return (Book)createProxy(Book.class,new BookImpl(name,rootCategory));
  }

  public Category createCategory(Category parent, String name) {
    if (parent==null)
      throw new IllegalArgumentException("parent must be non null");
    
    Category category=(Category)createProxy(Category.class,new CategoryImpl(parent,name));
    parent.getSubCategories().add(category);
    return category;
  }

  public Account createAccount(Book book, String name) {
    if (book==null)
      throw new IllegalArgumentException("book must be non null");
    
    Account account=(Account)createProxy(Account.class,new AccountImpl(book,name));
    book.getAccounts().add(account);
    return account;
  }

  public Transaction createTransaction(long date,List splits) {
    if (splits==null)
      throw new IllegalArgumentException("splits must be non null");
    
    return (Transaction)createProxy(Transaction.class,new TransactionImpl(date,splits));
  }

  public Split createSplit(Party party, long amount, Currency currency) {
    if (party==null || currency==null)
      throw new IllegalArgumentException("party and currency must be non null");
    
    return (Split)createProxy(Split.class,new SplitImpl(party,amount,currency));
  }
  
  public ExternalParty createExternalParty(String name) {
    return (ExternalParty)createProxy(ExternalParty.class,new ExternalPartyImpl(name));
  } 

  private Object createProxy(Class buckClass,Object impl) {
    return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
      new Class[]{buckClass}, new Interceptor(impl,buckClass));
  }
  
  public EventManager getEventManager() {
    return eventManager;
  }
  
  public EventManagerImpl getEventManagerImpl() {
    return eventManager;
  }
 
  private final EventManagerImpl eventManager=new EventManagerImpl();
}
