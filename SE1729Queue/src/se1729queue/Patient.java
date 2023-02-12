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
public class Patient implements Comparable<Patient>{
    String name; 
    int prior;
    
    public Patient(){
        
    }

    public Patient(String name, int prior) {
        this.name = name;
        this.prior = prior;
    }

    @Override
    public int compareTo(Patient o) {
        if(this.prior> o.prior){
            return 1;
        } else{
            if(this.prior == o.prior){
                return 0;
            } else{
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        return name + ' ' + prior;
    }
    
    
    
}
