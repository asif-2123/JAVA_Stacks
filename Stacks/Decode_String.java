import java.util.*;

public class Decode_String {

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                // Handle multi-digit numbers
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    count = count * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
                continue; // prevent extra idx++
            }
            else if (s.charAt(idx) == '[') {
                strStack.push(sb);
                sb = new StringBuilder(); // reset for new substring
            }
            else if (Character.isLetter(s.charAt(idx))) {
                sb.append(s.charAt(idx));
            }
            else if (s.charAt(idx) == ']') {
                int count = countStack.pop();
                StringBuilder temp = strStack.pop();
                for (int i = 0; i < count; i++) {
                    temp.append(sb);
                }
                sb = temp;
            }
            idx++;
        }
        return sb.toString();
    }
    public static void main(String args[]) {
        String str = "3[a]2[bc]";
        System.out.println(decodeString(str));
    }
}