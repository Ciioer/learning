package MyTest.exam;

import java.util.Scanner;

public class Maze {

    public static int getRoad(int[][] num, int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        int res =0;
        if(num[x-1][y]==0){
            res+=getRoad(num,x-1,y);
        }
        if(num[x][y-1]==0){
            res+=getRoad(num,x,y-1);
        }
        return res;

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int x;
        int y;
        x = in.nextInt();
        y = in.nextInt();
        int[][] num = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                num[i][j] = in.nextInt();
            }
        }
        System.out.print(getRoad(num, x - 1, y - 1));

    }
}
