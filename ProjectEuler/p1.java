/**
 * Created by Alex on 7/29/17.
 */
public class p1 {
    public static String answer(String s) {
        char[] ans = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                ans[i] = (char) ((int)'z' - ((int) c - (int)'a'));
            } else {
                ans[i] = c;
            }
        }
        return new String(ans);
    }
}
