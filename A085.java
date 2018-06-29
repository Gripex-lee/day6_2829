package day6_28;

import java.util.Scanner;

public class A085{
    public static boolean isMatching(String str, String pattern){
        int n = str.length();
        int m = pattern.length();
        boolean[][] T = new boolean[n+1][m+1];
        T[0][0] = true;

        for (int j = 1; j <= m; j++) {
            if (pattern.charAt(j - 1) == '*') {
                T[0][j] = T[0][j - 1];
            }
        }

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (pattern.charAt(j-1) == '*') {
                    T[i][j] = T[i - 1][j] || T[i][j - 1];
                }
                else if (pattern.charAt(j-1) == '?' ||
                        str.charAt(i-1) == pattern.charAt(j-1)) {
                    T[i][j] = T[i - 1][j - 1];
                }
            }
        }
        return T[n][m];
    }

    public static void main(String[] args){
        Scanner br=new Scanner(System.in);
        String s=br.nextLine();
    	String str = s.split(" ")[0];
        String pattern =s.split(" ")[1];
        if (isMatching(str, pattern)) {
            System.out.print("yes");
        }
        else {
            System.out.print("no");
        }
    }
}

