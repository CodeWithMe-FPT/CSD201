/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1729stack;

import sll.SLL;

/**
 *
 * @author ManhComputer
 * @param <T>
 */
public class MyStack <T extends Comparable<T>>{
    SLL<T> st = new SLL<>();

    public MyStack() {
    }
    
    
    int size(){
        return st.size();
    }
    
    boolean isEmpty(){
        return st.size() == 0;
    }
    
    void push(T el){
       st.addFirst(el);
    }
    
    T pop(){
        T result = st.get(0);
        st.removeFirst();
        return result;
    }
    
    T peek(){
       return st.get(0);
    }
    
    void clear(){
        st.removeAll();
    }
    
}
