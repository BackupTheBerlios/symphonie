package fr.umlv.jbucks.model;

import java.util.List;

/** account's book.
 * @author Remi Forax
 *
 */
public interface Book extends Item {
  /** returns the name of the book.
   * @return the name of the book.
   */
  String getName();
  
  /** changes the name of the book.
   *  @param name the new name.
   */
  void setName(String name);

  /** returns a modifiable list of accounts contains in the book.
   * @return a read-write list of accounts.
   */
  List getAccounts();
  
  /** returns the root category.
   *  by default, this category has no name and
   *  is the parent category of primary categories.
   * @return the root category.
   */
  Category getRootCategory();
}
