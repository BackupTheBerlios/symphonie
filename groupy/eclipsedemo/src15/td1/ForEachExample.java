/*
 * Created on 5 déc. 2004
 *
 */
package fr.umlv.eclipsedemo.tiger;

import java.util.Arrays;

/**
 * @author remi
 *
 */
public class ForEachExample {
  public static void main(String[] args) {
    for(String s:args)
      System.out.println(s);
    Iterable<String> list=Arrays.asList(args);
    for(String s:list)
      System.out.println(s);
  }
}
