package fr.umlv.jbucks.model;

import java.util.List;

/** Category.
 * @author Remi Forax
 */
public interface Category extends Item {
  /** returns the name of the category.
   * @return the name of the category.
   */
  String getName();
  
  /** changes the name of the category.
   *  @param name the new name.
   */
  void setName(String name);
  
  /** returns a description of the category.
   * @return a textual description of the category.
   */
  String getDescription();
  
  /** changes the description of the category.
   * @param description the new textual description of the category.
   */
  void setDescription(String description);
  
  /** returns the parent category of this catagory.
   * @return the parent category of this catagory.
   *  @see Book#getRootCategory()
   */
  Category getParent();
  
  /** returns all sub-categories of this category.
   *  Each sub-category has the same category as parent.
   * @return a add/remove list of category.
   */
  List getSubCategories();
}
