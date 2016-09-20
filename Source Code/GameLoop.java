/*
 * Decompiled with CFR 0_114.
 */
package archgame2;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class GameLoop {
    public static String setDate() {
        Date d = new Date();
        String month = "" + (d.getMonth() + 1);
        String day = "" + d.getDate();
        String yr = ("" + d.getYear()).substring(1);
        String ans = month + "/" + day + "/" + yr;
        return ans;
    }

    public static void addScore(int posspts1, int cluesused1, int nclues1, int totalscore1, boolean right) {
        if (right) {
            int possminus = (int)Math.round((double)posspts1 * 0.8);
            double perminus = Math.floor((double)possminus * 1.0 / ((double)nclues1 * 1.0));
            int totalminus = (int)((double)cluesused1 * perminus);
            int totaladd = posspts1 - totalminus;
            totalscore1 += totaladd;
        }
    }

    public static int getMinusPerClue(int posspts1, int nclues1) {
        int possminus = (int)Math.round((double)posspts1 * 0.8);
        int ans = (int)Math.floor((double)possminus * 1.0 / ((double)nclues1 * 1.0));
        return ans;
    }

    public static boolean isRight(String rightanswer, String answer, int step) {
        String ans;
        String right = rightanswer;
        if (step == 0) {
            right = rightanswer;
        }
        if ((ans = answer).contains("A.") || ans.contains("B.") || ans.contains("C.") || ans.contains("D.")) {
            ans = ans.substring(2);
        }
        if (right.contains("A.") || right.contains("B.") || right.contains("C.") || right.contains("D.")) {
            right = right.substring(2);
        }
        if (right.equals(ans)) {
            return true;
        }
        return false;
    }

    public static int[] SortBySpot(int[] spots, int[] content) {
        int[] ans = new int[content.length];
        for (int x = 0; x < content.length; ++x) {
            ans[x] = content[spots[x]];
        }
        return ans;
    }

    public static int[] Randomize(int[] a) {
        int[] ans = new int[a.length];
        GameLoop.FillArray(a.length, ans);
        int random = 0;
        for (int x = 0; x < a.length; ++x) {
            while (!GameLoop.notTaken(random = GameLoop.RandomNum(a.length), ans)) {
            }
            ans[x] = random;
            random = 0;
        }
        return ans;
    }

    public static int RandomNum(int a) {
        int ans = 0;
        while ((ans = (int)Math.round(Math.random() * (double)a)) == a) {
        }
        return ans;
    }

    public static boolean notTaken(int a, int[] taken) {
        for (int x = 0; x < taken.length; ++x) {
            if (taken[x] != a) continue;
            return false;
        }
        return true;
    }

    public static void FillArray(int a, int[] ans) {
        for (int x = 0; x < ans.length; ++x) {
            ans[x] = a;
        }
    }

    public static int[] toInt(String[] scores) {
        int x;
        String[] ss = new String[scores.length];
        for (x = 0; x < scores.length; ++x) {
            ss[x] = scores[x];
            System.out.println("" + ss[x]);
        }
        block1 : for (x = 0; x < ss.length; ++x) {
            for (int y = 0; y < (ss[x] + "").length(); ++y) {
                if (("" + ss[x].charAt(y) + "").equals("0")) continue;
                ss[x] = ss[x].substring(y);
                continue block1;
            }
        }
        int[] ans = new int[ss.length];
        for (int z = 0; z < ss.length; ++z) {
            ans[z] = Integer.parseInt(ss[z] + "");
        }
        return ans;
    }

    public static boolean Sorted(int[] a) {
        boolean all0 = true;
        for (int d = 0; d < a.length; ++d) {
            if (a[d] == 0) continue;
            all0 = false;
        }
        all0 = true;
        if (true) {
            return false;
        }
        int before = 0;
        for (int x = 1; x < a.length; ++x) {
            before = a[x - 1];
            if (a[x] <= before) continue;
            return false;
        }
        return true;
    }

    public static int[] SortInts(String[] scores) {
        int[] s = GameLoop.toInt(scores);
        int[] spots = new int[scores.length];
        int r = 0;
        while (r < spots.length) {
            spots[r] = r++;
        }
        ArrayList<Integer> checked = new ArrayList<Integer>();
        int[] spts = new int[scores.length];
        int spotter = 0;
        int best = 100000;
        for (int placespot = spts.length - 1; placespot >= 0; --placespot) {
            for (int x = 0; x < spts.length; ++x) {
                if (GameLoop.containsInt(checked, x) || s[x] >= best) continue;
                best = s[x];
                spotter = x;
            }
            checked.add(spotter);
            spts[placespot] = spotter;
            spotter = 0;
            best = 1000000;
        }
        return spts;
    }

    public static boolean containsInt(ArrayList<Integer> source, int other) {
        for (int y = 0; y < source.size(); ++y) {
            if (source.get(y) != other) continue;
            return true;
        }
        return false;
    }

    public static String[] SortBySpot(int[] spots, String[] content) {
        String[] ans = new String[content.length];
        for (int x = 0; x < content.length; ++x) {
            ans[x] = "" + content[spots[x]];
        }
        return ans;
    }
}
