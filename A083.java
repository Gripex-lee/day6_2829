package day6_28;

import java.util.Arrays;
import java.util.Scanner;

public class A083{
    public static int maximizeExpression(int[] A){
        int[] L1 = new int[A.length + 1];
        Arrays.fill(L1, Integer.MIN_VALUE);
        int[] L2 = new int[A.length];
        Arrays.fill(L2, Integer.MIN_VALUE);
        int[] L3 = new int[A.length - 1];
        Arrays.fill(L3, Integer.MIN_VALUE);
        int[] L4 = new int[A.length - 2];
        Arrays.fill(L4, Integer.MIN_VALUE);
        //A[l]的最大值
        for (int i = A.length - 1; i >= 0; i--) {
            L1[i] = Integer.max(L1[i + 1], A[i]);
        }
        //A[l]-A[k]的最大值
        for (int i = A.length - 2; i >= 0; i--) {
            L2[i] = Integer.max(L2[i + 1], L1[i + 1] - A[i]);
        }
        //A[l]-A[k]+A[j]的最大值
        for (int i = A.length - 3; i >= 0; i--) {
            L3[i] = Integer.max(L3[i + 1], L2[i + 1] + A[i]);
        }
        //A[l]-A[k]+A[j]-A[i]的最大值
        for (int i = A.length - 4; i >= 0; i--) {
            L4[i] = Integer.max(L4[i + 1], L3[i + 1] - A[i]);
        }
        return L4[0];
    }

    public static void main(String[] args){
    	Scanner br=new Scanner(System.in);
    	int[]A=new int[6];
        for(int i=0;i<A.length;i++) {
        	A[i]=br.nextInt();
        }
        if (A.length >= 4) {
            System.out.println(maximizeExpression(A));
        }
    }
}