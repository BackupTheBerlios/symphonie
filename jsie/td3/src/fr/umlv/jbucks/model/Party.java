package fr.umlv.jbucks.model;

/** Represents a party of a split.
 *  may be a {@link Account Account}
 *  or an {@link ExternalParty ExternalParty}
 * @author Remi Forax
 * @see Party
 */
public interface Party extends Item {
  /** returns the name of the party.
   * @return the name of the party.
   */
  String getName();
  
  /** changes the name of the party.
   *  @param name the new name.
   */
  void setName(String name);
}
