package fr.umlv.jbucks.model.impl;

import java.util.*;

import fr.umlv.jbucks.model.*;

/**
 * @author Remi Forax
 *
 */
public class SplitImpl extends ItemImpl implements Split {

  public SplitImpl(Party party,long amount,Currency currency) {
    this.party=party;
    this.amount=amount;
    this.currency=currency;
  }
  
  public Party getParty() {
    return party;
  }

  public long getAmount() {
    return amount;
  }

  public Currency getCurrency() {
    return currency;
  }
  
  public String toString() {
    return super.toString()+"[party="+party+
      " amount="+amount+
      " currency="+currency+']';
  }
  
  private final Party party;
  private final long amount;
  private final Currency currency;
}
