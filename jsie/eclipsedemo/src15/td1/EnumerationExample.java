/*
 * Created on 5 déc. 2004
 *
 */
package fr.umlv.eclipsedemo.tiger;

import java.util.AbstractSequentialList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author remi
 *
 */
public class EnumerationExample {
  enum Option {
    wordcount {
      Integer performs(List<? extends CharSequence> values) {
        return values.size();
      }
    }, lettercount {
      Integer performs(List<? extends CharSequence> values) {
        int count=0;
        for(CharSequence c:values)
          count+=c.length();
        return count;
      }
    }, reverse { 
      Object performs(List<? extends CharSequence> values) {
        Collections.reverse(values);
        return values();
      }
    };
    abstract Object performs(List<? extends CharSequence> values);
  }
  
  public static void main(String[] args) {
    System.out.println("available options "+Arrays.toString(Option.values()));
    Option option=Option.valueOf(args[0]);
    System.out.printf("option %s(%d)\n",option,option.ordinal());
    Object result=option.performs(Arrays.asList(args).subList(1,args.length));
    System.out.println(result);
  }
}
