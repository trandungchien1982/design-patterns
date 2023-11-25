package demo.impls;

import demo.base.Observer;

import java.util.LinkedList;
import java.util.List;

public class SubjectTopic {

  private List<Observer> observers = new LinkedList<>();
  public void attach(Observer observer) {
    observers.add(observer);
  }
  public void detach(Observer observer) {
    observers.remove(observer);
  }
  public void publish(String message) {
    for(Observer observer : observers) {
      observer.consume(message);
    }
  }

}