/*
 * Created on 5 déc. 2004
 *
 */
package fr.umlv.eclipsedemo.tiger;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;


/**
 * @author remi
 *
 */
public class AnnotationExample {

  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.RUNTIME)
  @interface ThreadSafe {
    boolean value() default true;
  }
  
  static class Example {
    @ThreadSafe(false)
    public int frequency(String text) {
      Integer count=map.get(text);
      if (count==null)
        count=0;
      map.put(text,count++);
      return count;
    }
    private final HashMap<String,Integer> map=
      new HashMap<String,Integer>();
  }
  
  private static Object safeCall(Method method,Object receiver,Object... args) throws Throwable {
    ThreadSafe threadSafe=method.getAnnotation(ThreadSafe.class);
    if (threadSafe==null || !threadSafe.value()) {
      synchronized(receiver) {
        return method.invoke(receiver,args);
      }
    }
    return method.invoke(receiver,args);
  }
  
  public static void main(String[] args) throws Throwable {
    Method method=Example.class.getMethod("frequency",String.class);
    System.out.println(safeCall(method,new Example(),args[0]));
  }
}
