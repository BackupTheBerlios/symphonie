package fr.umlv.jbucks.model.event;

import java.util.EventListener;

/**
 * @author Remi Forax
 *
 */
public interface PropertyListener extends EventListener {
  void propertyChanged(PropertyEvent event); 
}
