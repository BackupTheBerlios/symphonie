/*
 * Created on 9 f�vr. 2004
 * this source is under Gnu Public Licence
 */
package fr.umlv.jbucks.test;

import java.util.*;

import fr.umlv.jbucks.model.*;
import fr.umlv.jbucks.model.impl.BuckFactoryImpl;

/**
 * @author prasad
 *
 */
public class TestEquals {
  public static void main(String[] args) {
    System.setProperty(
      "fr.umlv.jbucks.factory",
      BuckFactoryImpl.class.getName());

    BuckFactory factory = BuckFactory.getFactory();
    BuckFactory factory1 = BuckFactory.getFactory();
    System.out.println("FACTORY " + factory.equals(factory));
    System.out.println("FACTORIES diff�rentes " + factory.equals(factory1));

    Book book = factory.createBook("Test");
    Book book1 = factory.createBook("Test1");
    System.out.println("BOOK " + book.equals(book));
    System.out.println("BOOKS diff�rents " + book.equals(book1));

    Account account = factory.createAccount(book, "compte");
    Account account1 = factory.createAccount(book, "compte1");
    System.out.println("ACCOUNT " + account.equals(account));
    System.out.println("ACCOUNTS diff�rents " + account.equals(account1));

    Party extParty = factory.createExternalParty("M�re grand");
    System.out.println("PARTY " + extParty.equals(extParty));
    System.out.println("PARTIES diff�rentes " + extParty.equals(account));

    Split split[] = new Split[2];
    split[0] =
      factory.createSplit(account, 1000000, Currency.getInstance("EUR"));
    split[1] =
      factory.createSplit(
        extParty,
        -1000000,
        Currency.getInstance("EUR"));

    System.out.println("SPLIT " + split[0].equals(split[0]));
    System.out.println("SPLITS diff�rents " + split[0].equals(split[1]));

    Transaction trans =
      factory.createTransaction(
        new Date().getTime(),
        Arrays.asList(split));
    System.out.println("TRANSACTION " + trans.equals(trans));

    Transaction trans1 =
      factory.createTransaction(
        new Date(0).getTime(),
        Collections.EMPTY_LIST);

    System.out.println("TRANSACTIONS diff�rentes " + trans.equals(trans1));

    Category category =
      factory.createCategory(book.getRootCategory(), "magot");
    Category category1 =
      factory.createCategory(book.getRootCategory(), "magot1");
    System.out.println("CATEGORY " + category.equals(category));
    System.out.println(
      "CATEGORIES diff�rentes " + category.equals(category1));

  }
}
