package MyTest.exam;

import java.util.Scanner;

public class IsTwoN {
    public static Boolean checkNum(int num) {
        if (num <= 0) {
            return false;
        }
        String s = Integer.toBinaryString(num - 1);
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != '1') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = Integer.toBinaryString(in.nextInt());
        char[] text = s.toCharArray();
        System.out.print(text);

    }
}
