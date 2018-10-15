package Offer;

public class num04ReplaceSpace {
    public static String replaceSpace(String string) {
        char[] s   =string.toCharArray();
        if (s == null) {
            return string;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length; i++) {
            if (String.valueOf(s[i]).equals(" ")){
                sb.append("%20");
            }else {
               sb.append(s[i]);
            }
        }
             return sb.toString();
    }

    public static void main(String[] args) {
        String string = "We are happy";
        System.out.print(replaceSpace(string));
    }
}
