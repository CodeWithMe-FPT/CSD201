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
public class SE1729CircularQueue {
    public static void main(String[] args) {
        CircularQueue<Integer> q = new CircularQueue<>();
        q.enqueue(5);
        q.enqueue(7);
        q.enqueue(9);
        System.out.println(q.dequeue());
    }
}
