package MyTest.exam;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class ChangeString {
    public static char[] drawChar(char[] text) {
        if (text.length < 2) {
            return text;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < text.length; i++) {
            if (hashMap.containsKey(text[i])) {
                hashMap.put(text[i], hashMap.get(text[i]) + 1);
            } else {
                hashMap.put(text[i], 0);
            }
        }
            Collection<Integer> count = hashMap.values();

            int maxCount = Collections.max(count);
            int maxNumber = 0;
            for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
                if (maxCount == entry.getValue()) {
                    maxNumber = entry.getKey();
                }
            }
            int index = 0;
            for (int j = 0; j < text.length; j++) {
                if (text[j] == maxNumber) {
                    swap(text, index++, j);
                }
            }


        return text;
    }

    public static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] text = in.next().toCharArray();
        System.out.print(drawChar(text));
    }
}
