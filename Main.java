import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] strings = {"папа па па", "абвгд", "ха ха ха", "кар кар", "мама"};

        System.out.println("Unique chars: " + new String(stringsParser(strings)));
    }

    private static char[] stringsParser(String[] strings) {
        ArrayList<String> evenStrings = findEvenCharsString(strings, 2);
        System.out.println("Even char strings: " + evenStrings);

        char[] uniqueChars = findUniqueChars(evenStrings);
        return uniqueChars;
    }


    private static ArrayList<String> findEvenCharsString(String[] strings, int limit) {
        ArrayList<String> result = new ArrayList<String>();
        int size = strings.length;
        for (int i = 0; i < size; i++) {
            if (result.size() >= limit) break;
            if (hasEvenChars(strings[i])) {
                result.add(strings[i]);
            }
        }
        return result;
    }

    private static char[] findUniqueChars(ArrayList<String> strings) {
        HashSet<Character> uniqueChars = new HashSet<Character>();
        for (String s : strings) {
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == ' ') continue;
                uniqueChars.add(c);
            }
        }
        char[] result = new char[uniqueChars.size()];
        int i = 0;
        for (char c : uniqueChars) {
            result[i++] = c;
        }
        return result;
    }

    private static boolean hasEvenChars(String s) {
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            if (s.charAt(i) == ' ') continue;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}