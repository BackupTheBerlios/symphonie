/*
 * Created on 5 déc. 2004
 *
 */
package fr.umlv.eclipsedemo.tiger;

import java.util.ArrayList;

/**
 * @author remi
 *
 */
public class ParametrizedTypeExample {

  public static class Stack<T> {
    public boolean isEmpty() {
      return list.isEmpty();
    }
    public void push(T o) {
      list.add(o);
    }
    public T pop() {
      return list.remove(list.size()-1);
    }
    private final ArrayList<T> list=new ArrayList<T>();
  }
  
  public static void main(String[] args) {
    Stack<String> stack=new Stack<String>();
    stack.push("toto");
    //stack.push(3);
    System.out.println(stack.pop().length());
  }
}
