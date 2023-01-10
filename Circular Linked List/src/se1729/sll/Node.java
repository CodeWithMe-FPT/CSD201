/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1729.sll;

/**
 *
 * @author ManhComputer
 * @param <T>
 */
public class Node<T extends Comparable<T>>{
    T data;
    Node<T> next;

    public Node() {
    }

    
    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
    
    
    public Node(T data) {
        this.data = data;
    }
    
    public Node(Node<T> next){
        this.next = next;
    }
    
    
    
    
}
