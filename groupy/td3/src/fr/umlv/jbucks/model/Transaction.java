package fr.umlv.jbucks.model;

import java.util.*;

/**
 * @author Remi Forax
 *
 */
public interface Transaction extends Item {
  
  /** returns the the date of the transaction in milliseconds
   *  since January 1, 1970, 00:00:00 GMT.
   * @return the date of the transaction.
   * @see Date#getTime()
   */
  long getDate();
  
  /** returns the description of the transaction.
   * @return a textual description of the transaction.
   */
  String getDescription();
  
  /** changes the description of the transaction.
   * @param description the description
   */
  void setDescription(String description);
  
  /** returns the category of the transaction.
   * @return the category of the transaction.
   */
  Category getCategory();
  
  /** changes the category of the current transaction.
   * @param category the new category.
   */
  void setCategory(Category category);
  
  /** returns a list of splits (more than one) that compose
   *  the current transaction.
   * @return a read-only list of splits.
   */
  List getSplits();
}
