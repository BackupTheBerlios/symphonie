package fr.umlv.jbucks.model;

import java.util.Currency;

/** Represents a part of a transaction.
 * @author Remi Forax
 */
public interface Split extends Item {
  /** returns the party of the split.
   * @return the party of the split.
   */
  Party getParty();
  
  /** returns the amount of the split in cents
   *  of the currency.
   * @return the amount in cents of the currency.
   * @see #getCurrency()
   */
  long getAmount();
  
  /** returns the currency of the split.
   * @return the currency of the amount of the split.
   */
  Currency getCurrency();
}
