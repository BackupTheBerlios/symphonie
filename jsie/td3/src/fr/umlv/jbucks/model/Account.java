package fr.umlv.jbucks.model;

import java.util.SortedSet;

/** Bank account.
 * @author Remi Forax
 */
public interface Account extends Party {
  
  /** returns the book in wich the account is registered.
   * @return the book in which the account is registered.
   */
  Book getBook();
  
  /** returns all transactions of the account sorted by date.
   * @return a read/write sorted set of all transactions
   *  associated to the this account.
   */
  SortedSet getTransactions();
}
