import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[5][5];
        int a = 0;
        int b = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int n = sc.nextInt();

                arr[i][j] = n;
                if (arr[i][j] == 1) {
                    a = i;
                    b = j;
                }
            }
        }
        int steps = Math.abs(2 - a) + Math.abs(2 - b);
        System.out.println(steps);
        sc.close();

    }

}
