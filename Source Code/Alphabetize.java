/*
 * Decompiled with CFR 0_114.
 */
package archgame2;

import java.io.PrintStream;
import java.util.ArrayList;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Alphabetize {
    public static String[] alphaint(String[] o, String[] s1) {
        int x;
        ArrayList<String> s = new ArrayList<String>();
        ArrayList<String> other = new ArrayList<String>();
        String[] other2 = new String[o.length];
        String[] a = new String[s1.length];
        int check = 0;
        int z = 0;
        char charr = '\u0000';
        boolean found = false;
        for (x = 0; x < s1.length; ++x) {
            s.add(x, s1[x].toLowerCase());
            other.add(x, o[x]);
        }
        while (s.size() != 0) {
            charr = '\u03e8';
            for (x = 0; x < s.size(); ++x) {
                if (((String)s.get(x)).charAt(0) >= charr) continue;
                charr = ((String)s.get(x)).charAt(0);
                check = x;
            }
            a[z] = (String)s.get(check);
            other2[z] = (String)other.get(check);
            s.remove(check);
            other.remove(check);
            ++z;
            check = 1000;
        }
        Alphabetize.alphax(other2, a);
        return other2;
    }

    public static String[] alpha(String[] s1) {
        int x;
        ArrayList<String> s = new ArrayList<String>();
        String[] a = new String[s1.length];
        int check = 0;
        int z = 0;
        char charr = '\u0000';
        boolean found = false;
        for (x = 0; x < s1.length; ++x) {
            System.out.println(x);
            s.add(x, s1[x].toLowerCase());
        }
        while (s.size() != 0) {
            charr = '\u03e8';
            for (x = 0; x < s.size(); ++x) {
                if (((String)s.get(x)).charAt(0) >= charr) continue;
                charr = ((String)s.get(x)).charAt(0);
                check = x;
            }
            a[z] = (String)s.get(check);
            s.remove(check);
            ++z;
            check = 1000;
        }
        Alphabetize.alphax(a);
        return a;
    }

    public static boolean intcontains(int a, ArrayList<Integer> arr) {
        boolean ans = false;
        for (int x = 0; x < arr.size(); ++x) {
            if (a != arr.get(x)) continue;
            ans = true;
            break;
        }
        return ans;
    }

    public static void alphax(String[] o, String[] s) {
        String switcher = "";
        String switcher2 = "";
        boolean perfect = true;
        do {
            for (int x = 1; x < s.length; ++x) {
                if (s[x].charAt(0) != s[x - 1].charAt(0) || Alphabetize.before(s[x - 1], s[x]) != 1) continue;
                perfect = false;
                switcher = s[x - 1];
                s[x - 1] = s[x];
                s[x] = switcher;
                switcher2 = o[x - 1];
                o[x - 1] = o[x];
                o[x] = switcher2;
            }
            perfect = false;
        } while (false);
    }

    public static void alphax(String[] s) {
        String switcher = "";
        boolean perfect = true;
        do {
            perfect = true;
            for (int x = 1; x < s.length; ++x) {
                if (s[x].charAt(0) != s[x - 1].charAt(0) || Alphabetize.before(s[x - 1], s[x]) != 1) continue;
                perfect = false;
                switcher = s[x - 1];
                s[x - 1] = s[x];
                s[x] = switcher;
                switcher = "";
                break;
            }
            if (perfect) break;
            perfect = true;
        } while (true);
    }

    public static int before(String a, String b) {
        int ans = 0;
        for (int x = 1; x < Alphabetize.smaller(a, b); ++x) {
            if (a.charAt(x) != b.charAt(x)) {
                if (a.charAt(x) > b.charAt(x)) {
                    return 1;
                }
                if (a.charAt(x) >= b.charAt(x)) continue;
                return 0;
            }
            if (x + 1 != Alphabetize.smaller(a, b) || b.length() >= a.length()) continue;
            return 1;
        }
        return ans;
    }

    public static int smaller(String a, String b) {
        if (a.length() > b.length()) {
            return b.length();
        }
        return a.length();
    }
}
