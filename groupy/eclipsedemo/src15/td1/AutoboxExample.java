/*
 * Created on 5 déc. 2004
 *
 */
package fr.umlv.eclipsedemo.tiger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author remi
 *
 */
public class AutoboxExample {
  private static <T> Map<T,Integer> frequency(T... array) {
    HashMap<T,Integer> map=new HashMap<T,Integer>();
    for(T t:array) {
      Integer count=map.get(t);
      if (count==null)
        map.put(t,1);
      else
        map.put(t,count+1);
    }
    return map;
  }
  
  public static void main(String[] args) {
    System.out.println(frequency(args));
  }
}
