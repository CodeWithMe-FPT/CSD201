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
public class Queue  <T extends Comparable<T>> {
    SLL<T> st = new SLL<>();

    public Queue() {
    }
    
    int size(){
        return st.size();
    }
    
    boolean isEmpty(){
        return st.size() == 0;
    }
    
    void enqueue(T el){
        st.addLast(el);
    }
    
    T dequeue(){
        return st.removeFirst();
    }
    
    T front(){
        return st.get(0);
    }
    
    void clear(){
        st.removeAll();
    }
    
}
