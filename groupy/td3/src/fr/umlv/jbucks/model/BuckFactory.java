package fr.umlv.jbucks.model;

import java.util.*;

/** factory that permits to create a lot of bucks items.
 * @author Remi Forax
 */
public abstract class BuckFactory {
  
  /** creates a book with a name from nowhere.
   * @param name name of the created book.
   * @return the created book.
   */
  public abstract Book createBook(String name);
  
  /** creates a new category with a name form a parent one.
   * @param parent parent catagory, must be non null,
   *  @see Book#getRootCategory()
   * @param name the name of the created category.
   * @return the created category.
   */
  public abstract Category createCategory(Category parent,String name);
  
  /** creates an account with a name from a book.
   * @param book the book where the account is listed.
   * @param name name of the created account.
   * @return the created account.
   */
  public abstract Account createAccount(Book book,String name);
  
  /** creates a transaction with a date and a list of splits.
   *  Note: the transaction is not registered anywhere by default.
   * @param date date of the transaction in in miliseconds
   *  since January 1, 1970, 00:00:00 GMT.
   * @param splits list of splits that compose the tranaction.
   * @see Date#getTime()
   * @return the created transaction.
   */
  public abstract Transaction createTransaction(long date,List splits);
  
  /** creates a split with a party, an amount and the currency
   *  of this amount.
   * @param party the party of the split.
   * @param amount the amount of the split in cents of the currency.
   * @param currency the currency of the amount.
   * @return the created split.
   */
  public abstract Split createSplit(Party party,long amount,Currency currency);
  
  /** creates an external party with a name.
   * @param name name of the external party.
   * @return the newly created external party.
   */
  public abstract ExternalParty createExternalParty(String name);
  
  /** returns the event manager.
   *  The event manager permit to register/unregister listeners
   *  on all items events.
   * @return the event manager.
   */
  public abstract EventManager getEventManager();
  
  /** returns the default item factory.
   *  there are two ways to set the default factory :
   *  <ol>
   *   <li>use {@link #setFactory(BuckFactory) setFactory()}
   *   <li>set the system property fr.umlv.jbucks.factory
   *       with the name of a BuckFactory class.
   *  </ol> 
   * @return the default factory.
   * @see System#setProperty(String,String)
   */
  public static BuckFactory getFactory() {
    if (factory!=null)
      return factory;
    
    String factoryName=System.getProperty("fr.umlv.jbucks.factory");
    if (factoryName==null)
      throw new IllegalStateException("property fr.umlv.jbucks.factory not found");
    
    try {
      factory=(BuckFactory)Class.forName(factoryName).newInstance();
      return factory;
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  
  /** sets the default factory.
   * @param factory the factory.
   */
  public static void setFactory(BuckFactory factory) {
    BuckFactory.factory=factory;
  }
  
  private static BuckFactory factory;
}
