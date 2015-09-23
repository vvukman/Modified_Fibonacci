import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/* 

Given the nth and (n+1)th terms, the (n+2)th can be computed by the following relation 
Tn+2 = (Tn+1)^2 + Tn 

Given three integers A, B and N, such that the first two terms of the series (1st and 2nd terms) are A and B respectively, compute the Nth term of the series. 

Input Format:
Given three space separated integers A, B and N on one line. 

Output Format 

One integer. 
 This integer is the Nth term of the given series when the first two terms are A and B respectively. 
 Some output may even exceed the range of 64 bit integer.

*/

public class Solution {

        public static void main(String[] args) {
    	Scanner scn = new Scanner(System.in);
    	String input = scn.nextLine();
    	StringTokenizer stok = new StringTokenizer(input, " ");
    	int number = stok.countTokens();
    	if (number != 3) return;
    	BigInteger fA = new BigInteger(stok.nextToken());
    	BigInteger fB = new BigInteger(stok.nextToken());
    	BigInteger fN = new BigInteger(stok.nextToken());
    	getFib(fA, fB, fN);
        scn.close();
    }

	private static void getFib(BigInteger fA, BigInteger fB, BigInteger fN) {
    	BigInteger[] mem = new BigInteger[3];
    	BigInteger N = BigInteger.ONE;
    	for (N.add(BigInteger.ZERO); N.compareTo(fN.add(BigInteger.ZERO))<=0; N = N.add(BigInteger.ONE)){
    		if (N.compareTo(BigInteger.ONE) == 0){
    			mem[0] = fA.add(BigInteger.ZERO);
    			mem[1] = BigInteger.ZERO;
    			mem[2] = fA.add(BigInteger.ZERO);
    		}
    		else if (N.compareTo(BigInteger.ONE.add(BigInteger.ONE)) == 0){
    			mem[1] = fB.add(BigInteger.ZERO);	
    			mem[2] = fB.add(BigInteger.ZERO);
    		}
    		else {
    			mem[2] = mem[0].add(mem[1].pow(2));
    			mem[0] = mem[1].add(BigInteger.ZERO);	
    			mem[1] = mem[2].add(BigInteger.ZERO);
    		}
    	}
		System.out.println(mem[2].toString());
	}
}