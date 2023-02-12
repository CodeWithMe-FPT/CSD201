/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1729stack;

/**
 *
 * @author ManhComputer
 */
public class MyStack1<T extends Comparable<T>>{
    SLL<T> st = new SLL<T>();

    public MyStack1() {
    }
    
    boolean isEmpty(){
        return st.size() == 0;
    }
    
    void push(T el){
       st.addLast(el);
    }
    
    T pop(){
        T result = st.get(st.size() - 1);
        st.removeLast();
        return result;
    }
    
    T peek(){
       return st.get(st.size() - 1);
    }
    
    void clear(){
        st.removeAll();
    }
}
