package com.willkernel.app.javadesignmode.controller;

import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

/**
 * Created by willkernel on 2017/1/21.
 * mail:willkerneljc@gmail.com
 */

public abstract class AbstractSubscribe implements Subscribe {
    private Vector<Observer> observers = new Vector<>();

    @Override
    public String add(Observer observer) {
        return String.valueOf(observers.add(observer));
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> observerEnumeration = observers.elements();
        while (observerEnumeration.hasMoreElements()) {
            Observer observer = observerEnumeration.nextElement();
            Observable observable = new Observable();
            observer.update(observable, "A");
        }
    }
}