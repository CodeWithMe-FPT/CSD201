/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1729stack;

import java.util.Scanner;
import java.util.Stack;


/**
 *
 * @author ManhComputer
 */

class Caculate{
    
    private boolean checkNum;
    private boolean isNeg1 = false;
    private boolean isNeg2 = false;
    private boolean isSum = false;
    private boolean isSub = false;

    public Caculate(MyStack<Integer> msc1, MyStack<Integer> msc2) {
        this.compareNum(msc1, msc2);
    }
    
    
    private boolean compareNum (MyStack<Integer> msc1, MyStack<Integer> msc2){
        checkNum = true;
        while(!msc1.isEmpty()){
            int num1 = msc1.pop();
            int num2 = msc2.pop();
            if(num1 > num2){
                checkNum = true;
            } else if(num1<num2){
                checkNum = false;
            }
        }     
        return checkNum;
    }

    public void setIsNeg1(boolean isNeg) {
        this.isNeg1 = isNeg;
    }

    public void setIsNeg2(boolean isNeg) {
        this.isNeg2 = isNeg;
    }    
    
    
    
    public  MyStack<Integer> sum(MyStack<Integer> ms1, MyStack<Integer> ms2){
        MyStack<Integer> result = new MyStack<>();
        int m = 0;
        
        if(this.isNeg1 && !this.isNeg2  && !this.isSub){
            // call sub and retun result of sub
            this.isNeg1 = false;
            if(!this.checkNum){
                this.checkNum = true;
            } else{
                this.checkNum = false;
            }
            return sub(ms2, ms1);
        }
        
        if(this.isNeg2 && !this.isNeg1 && !this.isSub){
            this.isNeg2 = false;       
            return sub(ms1, ms2);
        }
            
        
        while(!ms1.isEmpty()){
            int sum = ms1.pop() + ms2.pop();
            if(m!=0 && sum>=0){
                sum+=m;
                m = 0;
            }
            if(sum>=10 && !ms1.isEmpty()){
                sum = sum%10;
                m = 1;
            } else{
                if(ms1.isEmpty() && isNeg1 &&isNeg2 && sum<= -10){
                    sum = sum-1;
                }
            }
            result.push(sum);
        }        
        
        if(isNeg1 && isNeg2){
            result.push(-result.pop());
        }
        return result;
    }
    
    public MyStack<Integer> sub(MyStack<Integer> ms1, MyStack<Integer> ms2){
        MyStack<Integer> result = new MyStack<>();
        MyStack<Integer> resultTmp = new MyStack<>();

        int m = 0;
        int num1, num2;
        int countCheckZero = 0;
        int countCheckNum = 0;
        
        if(this.isNeg2 && !this.isNeg1){
            this.isSub = true;
            result = this.sum(ms1, ms2);
            this.isSub = false;
            return result;
        }
        
        if(this.isNeg1 && !this.isNeg2){
            this.isSub = true;
            this.isNeg2 = true;
            result = this.sum(ms1, ms2);
            this.isSub = false;
            return result;
        }
                  
        
        if(!checkNum){
            MyStack <Integer> tmp = ms1;
            ms1 = ms2;
            ms2= tmp;
        }
        
        if(this.isNeg1 && this.isNeg2){
            this.checkNum = !this.checkNum;
        }        
        
          
        while(!ms1.isEmpty()){
            num1 = ms1.pop();
            num2 = ms2.pop();
            int sub = 0;
            

            
            if(m!=0){
                sub-=m;
                m = 0;
            }            
            if(num1<num2 || (num1==num2) && sub<0){
                num1 = num1 + 10;
                m = 1;
            }
            
            sub += num1 - num2;
            
            if(sub<0){
                sub +=1;
                m = 1;
            }           
            
            result.push(sub);
        }
       
        
        while(!result.isEmpty()){
            int num = result.pop();
            if(num!=0){
                if(countCheckZero==0 && !checkNum ){
                    num = -num;
                    countCheckZero++;
                }
                countCheckNum++;
                resultTmp.push(num);
            } else if(countCheckNum!=0){
                    resultTmp.push(num);
            }

            
            
        } 
        
        while(!resultTmp.isEmpty()){
            result.push(resultTmp.pop());
        }
        
        if(result.isEmpty()){
            result.push(0);
        }
        return result;
    }
    
//    public MyStack<Integer> mul(MyStack<Integer> ms1, MyStack<Integer> ms2){
//        
//    }
}


public class Operator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();
        String operator = sc.nextLine();
        int num1Start  = 0, num2Start = 0;
        
        MyStack<Integer> result = null;
        MyStack<Integer> ms1 = new MyStack<>();
        MyStack<Integer> ms2 = new MyStack<>();
        MyStack<Integer> msc1 = new MyStack<>();
        MyStack<Integer> msc2 = new MyStack<>();
        


        if(Character.toString(num1.charAt(0)).equals("-")){
            num1Start = 1;
            num1 = num1.split("-")[1];
        }
        
        if(Character.toString(num2.charAt(0)).equals("-")){
            num2 = num2.split("-")[1];            
            num2Start = 1;
        }
        
        if(num1.length()<num2.length()){
            String stringZero="";
            for(int i = num1.length(); i<num2.length(); i++){
                stringZero += "0";
            }
            num1 = stringZero.concat(num1);
        } else{
            String stringZero="";
            for(int i = num2.length(); i<num1.length(); i++){
                stringZero += "0";
            }
            num2 = stringZero.concat(num2);
        }                
        
        for(int i = 0; i<num1.length(); i++){
            int num = Integer.parseInt(Character.toString(num1.charAt(i)));
            ms1.push(num);
            msc1.push(num);
        }
        
        for(int i = 0; i<num2.length();i++){
            int num = Integer.parseInt(Character.toString(num2.charAt(i)));
            ms2.push(num);
            msc2.push(num);         
        }
        

        
        Caculate c = new Caculate(msc1, msc2);
        
        if(num1Start != 0 ){
            c.setIsNeg1(true);
        }
        
        if(num2Start != 0){
            c.setIsNeg2(true);
        }
        
        
        System.out.println();
        
        switch(operator){
            case "+":   result = c.sum(ms1, ms2);
                        break;
            case "-":   result = c.sub(ms1, ms2);
                        break;
            default: break;
        }
        
        if(result != null){
            while(!result.isEmpty()){
                System.out.print(result.pop());
            }
        }
        System.out.println("");
    }
}
