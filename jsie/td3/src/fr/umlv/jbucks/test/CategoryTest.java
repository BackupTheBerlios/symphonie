package fr.umlv.jbucks.test;

import java.util.List;

import fr.umlv.jbucks.model.*;
import fr.umlv.jbucks.model.impl.BuckFactoryImpl;

/**
 * @author Remi Forax
 *
 */
public class CategoryTest {

  public static void main(String[] args) {
    
    System.setProperty("fr.umlv.jbucks.factory", BuckFactoryImpl.class.getName());
    
    BuckFactory factory=BuckFactory.getFactory();
    
    Book book=factory.createBook("test");
    
    Category root=book.getRootCategory();
    
    Category sub1=factory.createCategory(root, "sub1");
    factory.createCategory(root, "sub2");
    
    List categories=root.getSubCategories();
    System.out.println(categories);
    
    // change category name
    sub1.setName("new name (was sub1)");
    System.out.println(categories);
  }
}
