/*
    Filename   InterchangeNumbers.java
    Written by Christopher Sigouin
    Written on 09/15/2014

*/


/**
 *
 * @author krys
 */
public class InterchangeNumbers {
    
    public static void main(String[] args)
    {
        // TWO VARIABLES WITH INITIALIZED VALUES
        int first = 2, second = 3; 

        
        // X( Exclusive )OR SWAP ALGORITHM
        /* 2 = 0010 in binary 
           3 = 0011 in binary
        */
        
        /*
        When you take A XOR 0, then you always get A back: if A is 1, 
        you get 1, and if A is 0, you get 0. On the other hand, when you take A XOR 1, 
        you flip A. If A is 0, you get 1; if A is 1, you get 0. 
        REF: http://www.cprogramming.com/tutorial/bitwise_operators.html
        */
        
        // DISPLAYS VALUES BEFORE SWAP
        System.out.println(" Using XOR Bitwise Operator [ first ] = " + first + " and [ second ] = " + second);
        
        first ^= second; // 0010 ^= 0011 Changes first to 0001
        System.out.println(" [ first ] is now = " + first + " [ second ] is now = " + second );
        second ^= first; // 0011 ^= 0001 First then changes second back to the orig. first 0010
        System.out.println(" [ first ] is now = " + first + " [ second ] is now = " + second );
        first ^= second; // 0001 ^= 0010 Second then changes first to the orig. second 0011
        System.out.println(" [ first ] is now = " + first + " [ second ] is now = " + second );
        
        // DISPLAYS VALUES AFTER SWAP
        System.out.println(" Using XOR Bitwise Operator [ first ] = " + first + " and [ second ] = " + second);
        
        // Restate what first and second is
        System.out.println("");
        System.out.println(" Using Arithmetic first = " + first + " and second = " + second);
        
        first = first * second; // Makes " first " equal 6
        System.out.println(" [ first ] is now = " + first + " [ second ] is now = " + second );
        second = first / second; // Makes " second " equal 2
        System.out.println(" [ first ] is now = " + first + " [ second ] is now = " + second );
        first = first / second; // Makes " first " equal 3
        System.out.println(" [ first ] is now = " + first + " [ second ] is now = " + second );
        
        System.out.println(" Using Arithmetic first = " + first + " and second = " + second);
        
    }
    
}

