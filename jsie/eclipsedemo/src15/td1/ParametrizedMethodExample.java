/*
 * Created on 5 déc. 2004
 *
 */
package fr.umlv.eclipsedemo.tiger;

/**
 * @author remi
 *
 */
public class ParametrizedMethodExample {
  private static <T extends Comparable<T>> T min(T... array) {
    T min=null;
    for(T t:array) {
      if (min==null)
        min=t;
      else
        if (t.compareTo(min)<0)
          min=t;
    }
    return min;
  }
  
  public static void main(String[] args) {
    String min=min(args);
    System.out.println("min in lexical order "+min);
  }
}
