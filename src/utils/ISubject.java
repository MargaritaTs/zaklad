/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author xzenj02
 */
public interface ISubject {
    
    void registerObserver(IObserver iObserver);
    
    void removeObserver(IObserver observer);
    
    void notifyAllObservers();
    
}
