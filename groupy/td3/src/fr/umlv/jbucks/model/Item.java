package fr.umlv.jbucks.model;

import java.util.Set;

/** Base interface of all business objects.
 *  provides a way to add and remove user datas.
 * @author Remi Forax
 */
public interface Item {
  /** sets a user data key/value pair.
   * @param userDataKey the key.
   * @param userDataValue the value.
   */
  void setUserData(String userDataKey,Object userDataValue);
  
  /** retrieves a user data value by key.
   * @param userDataKey the key.
   * @return the user data value or null.
   */
  Object getUserDataValue(String userDataKey);
  
  /** removes a user data key/value pair.
   * @param userDataKey the key
   * @return the value of the corresponding key.
   */
  Object removeUserData(String userDataKey);
  
  /** returns a set of all user data keys.
   * for debug only
   * @return a read-only set of keys, remove() works on this set.
   */
  Set getUserDataKeys();
}
