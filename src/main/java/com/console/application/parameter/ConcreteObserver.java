package com.console.application.parameter;

interface ConcreteObserver {
    void addObserver(Observer observer);
    void notifyAllObservers();
}
