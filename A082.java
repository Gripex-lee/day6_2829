package day6_28;

import java.util.Scanner;

public class A082 {
	public static int knap(int[] v,int[] w,int n,int W) {
		if(W<0) {
			return  Integer.MIN_VALUE;
		}
		if(n<0||W==0) {
			return 0;
		}
		int include =  v[n] + knap(v,w,n-1,W-w[n]);
		int unclude = knap(v,w,n-1,W);
		return Integer.max(include, unclude);
	}
	
	public static void main(String[] args) {
		int[] v= {20,5,10,40,15,25};
		int[] w= {1,2,3,8,7,4};
		Scanner br=new Scanner(System.in);
		int W=br.nextInt();
		
		System.out.println(knap(v,w,v.length-1,W));
	}
}
