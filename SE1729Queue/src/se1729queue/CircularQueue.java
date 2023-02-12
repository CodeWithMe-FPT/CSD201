/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1729queue;

/**
 *
 * @author ManhComputer
 */
public class CircularQueue <T extends Comparable<T>> {
    CLL<T> q = new CLL<>();

    public CircularQueue() {
    }
    
    int size(){
        return q.size();
    }
    
    boolean isEmpty(){
        return q.size() == 0;
    }
    
    void enqueue(T el){
        q.addLast(el);
    }
    
    T dequeue(){
        return q.removeFirst();
    }
    
    T front(){
        return q.get(0);
    }
    
    void clear(){
        q.removeAll();
    }
    
    
    
    
}
