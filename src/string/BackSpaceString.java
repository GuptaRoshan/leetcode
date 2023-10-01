package string;

public class BackSpaceString {

    public static String removeLastString(String st) {
        if (st.isEmpty()) {
            return st;
        } else {
            return st.substring(0, st.length() - 1);
        }
    }

    public static boolean backspaceCompare(String s, String t) {
        String sb = "";
        String tb = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                sb = removeLastString(sb);
            } else {
                sb = sb + s.charAt(i);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                tb = removeLastString(tb);
            } else {
                tb = tb + t.charAt(i);
            }
        }

        return sb.equals(tb);
    }

    public static String getEditorString(String st) {
        StringBuilder stringBuilder = new StringBuilder();

        int hashCount = 0;
        for (int i = st.length() - 1; i >= 0; i--) {
            if (st.charAt(i) == '#') {
                hashCount++;
                continue;
            }

            if (hashCount == 0) {
                stringBuilder.insert(0, st.charAt(i));
            }else {
                hashCount--;
            }

        }
        return stringBuilder.toString();
    }



    public static void main(String[] args) {
        String s = "bxj##tw", t = "bxj###tw";
        System.out.println(backspaceCompare(s, t));

        System.out.println(getEditorString(s).equals(getEditorString(t)));
    }

}
