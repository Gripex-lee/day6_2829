package day6_28;

public class A088{
    public static int longest(String X, int i, int j){
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (X.charAt(i) == X.charAt(j)){
            return longest(X, i + 1, j - 1) + 2;
        }
        return Integer.max(longest(X, i, j - 1),longest(X, i + 1, j));
    }

    public static void main(String[] args){
        String X = "ABBDCACB";
        int n = X.length();

        System.out.print(longest(X, 0, n - 1));
        System.out.println();
    }
}
