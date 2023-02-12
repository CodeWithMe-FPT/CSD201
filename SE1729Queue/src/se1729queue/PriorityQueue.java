/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1729queue;

/**
 *
 * @author ManhComputer
 * @param <T>
 */
public class PriorityQueue <T extends Comparable<T>> {
    SLL<T> st = new SLL<>();

    public PriorityQueue() {
    }
    
    int size(){
        return st.size();
    }
    
    boolean isEmpty(){
        return st.size() == 0;
    }
    
    void enqueue(T el){
        if(st.size==0){
            st.addFirst(el);
        } else{
            int size  = st.size;
            for(int i = 0; i< size; i++){
                    if(el.compareTo(st.get(i)) > 0){
                        st.addPos(i, el);
                        break;
                    }
            }
        }
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
