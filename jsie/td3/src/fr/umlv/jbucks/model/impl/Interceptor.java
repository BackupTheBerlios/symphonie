package fr.umlv.jbucks.model.impl;

import java.lang.reflect.*;
import java.util.*;

import fr.umlv.jbucks.model.*;
import fr.umlv.jbucks.model.BuckFactory;
import fr.umlv.jbucks.model.event.PropertyEvent;
import fr.umlv.jbucks.model.impl.util.*;

/**
 * @author Remi Forax
 *
 */
public class Interceptor implements InvocationHandler {

  public Interceptor(Object impl,Class type) {
    this.impl=impl;
    this.type=type;
    
    if (!type.isInstance(impl))
      throw new IllegalArgumentException("impl ("+impl+" must be of type "+type);
  }
  
  
  
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (method.equals(equals)) {
      Object arg=args[0];
      if (!Proxy.isProxyClass(arg.getClass()))
        return Boolean.FALSE;
      
      InvocationHandler handler=Proxy.getInvocationHandler(arg);
      if (!(handler instanceof Interceptor))
        return Boolean.FALSE;
        
      args[0]=((Interceptor)handler).impl;
      }
    Object result=method.invoke(impl,args);
    
    String methodName=method.getName();
    if (methodName.startsWith("get")) {
      
      String property=extractProperty(methodName); 
      
      Class returnType=method.getReturnType();
      
      if (Collection.class.isAssignableFrom(returnType)) {
        
        Collection collection=(Collection)result;
        if (BucksCollections.isUnmodifiable(collection))
          return collection;
        
        return BucksCollections.modifiable((Item)proxy,type,property,collection);
      }
      
    } else
      if (methodName.startsWith("set")) {
    
        String property=extractProperty(methodName);  
        
        PropertyEvent event=new PropertyEvent((Item)proxy,property);
        getEventManager().firePropertyEvent(type, event);
      }
    
    return result;
  }
  
  private final Object impl;
  private final Class type;
  
  private static String extractProperty(String methodName) {
    String name=methodName.substring(3);
    return Character.toLowerCase(name.charAt(0))+name.substring(1);
  }
  
  private static EventManagerImpl getEventManager() {
    return ((BuckFactoryImpl)BuckFactory.getFactory()).getEventManagerImpl();
  }
  
  private static final Method equals;
  
  static {
   try {
    equals = Object.class
       .getDeclaredMethod("equals",new Class[] {Object.class});
    } catch (NoSuchMethodException e) {
      throw new AssertionError(e);
    } 
  }
}
