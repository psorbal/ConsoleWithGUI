package com.console.application.parameter;

import java.util.ArrayList;
import java.util.List;
/**
 * Class for parameter using in commands.
 * This class has implemented observer pattern.
 * Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified,
 * its dependent objects are to be notified automatically.
 */

public class Parameter implements ConcreteObserver {
    private List<Observer> observers = new ArrayList<>();
    private String parameter = "$";
    private String path = System.getProperty("user.dir");

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
        notifyAllObservers();
    }

    public String getPath(){
        return path;
    }

    public void setPath(String parameter){
        this.path = parameter;
        notifyAllObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        observers.forEach(Observer::update);
    }
}
