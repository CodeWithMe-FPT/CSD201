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
public class SE1729PriorityQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PriorityQueue <Patient> q = new PriorityQueue<>();
        q.enqueue(new Patient("A", 10));
        q.enqueue(new Patient("B", 12));
        q.enqueue(new Patient("C", 11));
        System.out.println(q.dequeue());
        System.out.println(q.front());
    }
    
}
