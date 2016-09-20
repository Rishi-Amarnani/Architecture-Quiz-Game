/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  archgame2.Alphabetize
 *  archgame2.GameLoop
 *  archgame2.HighScores$1
 *  archgame2.HighScores$2
 *  archgame2.HighScores$3
 *  archgame2.HighScores$4
 *  archgame2.HighScores$5
 *  archgame2.HighScores$6
 */
package archgame2;

import archgame2.Alphabetize;
import archgame2.GameLoop;
import archgame2.HighScores;
import archgame2.Menu;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.ListModel;

public class HighScores
extends JFrame {
    private static String[] input;
    private static String name1;
    private static String score1;
    private static int changed;
    private static String previous;
    private static String[] scores2;
    private static String[] names2;
    private static String[] dates2;
    private static int[] spots;
    private static String[] namesbyscores;
    private static String[] scoresbyscores;
    private static String[] datesbyscores;
    private static String[] namesbyalpha;
    private static String[] scoresbyalpha;
    private static String[] datesbyalpha;
    private static boolean restart;
    private static int l;
    private JList DatesList;
    private JComboBox DropDownList;
    private JList NamesList;
    private JList ScoresList;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;

    public HighScores() {
        this.initComponents();
    }

    private void initComponents() {
        this.jLabel2 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.NamesList = new JList();
        this.jScrollPane2 = new JScrollPane();
        this.ScoresList = new JList();
        this.DropDownList = new JComboBox();
        this.jLabel1 = new JLabel();
        this.jScrollPane3 = new JScrollPane();
        this.DatesList = new JList();
        this.jButton1 = new JButton();
        this.jLabel2.setText("Sort by Name");
        this.setDefaultCloseOperation(3);
        this.setTitle("HiScores");
        this.NamesList.setModel(new /* Unavailable Anonymous Inner Class!! */);
        this.jScrollPane1.setViewportView(this.NamesList);
        this.ScoresList.setModel(new /* Unavailable Anonymous Inner Class!! */);
        this.jScrollPane2.setViewportView(this.ScoresList);
        this.DropDownList.setModel(new DefaultComboBoxModel<String>(new String[]{"Date", "Score", "Name"}));
        this.DropDownList.addItemListener((ItemListener)new /* Unavailable Anonymous Inner Class!! */);
        this.jLabel1.setText("Sort By");
        this.DatesList.setModel(new /* Unavailable Anonymous Inner Class!! */);
        this.jScrollPane3.setViewportView(this.DatesList);
        this.jButton1.setText("Main Menu");
        this.jButton1.addActionListener((ActionListener)new /* Unavailable Anonymous Inner Class!! */);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(164, 164, 164).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.DropDownList, -2, -1, -2).addContainerGap(221, -2)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jButton1, -2, 100, -2)).addGroup(layout.createSequentialGroup().addGap(45, 45, 45).addComponent(this.jScrollPane1, -2, 139, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 98, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -1, 115, 32767))).addGap(73, 73, 73)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(45, 45, 45).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.DropDownList, -2, -1, -2)).addGap(50, 50, 50).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane3, GroupLayout.Alignment.LEADING, -1, 319, 32767).addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING, -1, 319, 32767).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 319, 32767)).addGap(40, 40, 40).addComponent(this.jButton1).addGap(34, 34, 34)));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        restart = true;
        Menu.main(input, restart);
    }

    private void DropDownListItemStateChanged(ItemEvent evt) {
        String s = "";
        if (changed != 0 && !(s = "" + evt.getItem().toString()).equals(previous)) {
            if (s.equals("Date")) {
                this.NamesList.setListData(names2);
                this.ScoresList.setListData(scores2);
                this.DatesList.setListData(dates2);
            } else if (s.equals("Name")) {
                System.out.println("Name");
                this.NamesList.setListData(namesbyalpha);
                this.ScoresList.setListData(scoresbyalpha);
                this.DatesList.setListData(datesbyalpha);
            } else if (s.equals("Score")) {
                System.out.println("Score");
                this.NamesList.setListData(namesbyscores);
                this.ScoresList.setListData(scoresbyscores);
                this.DatesList.setListData(datesbyscores);
            }
        }
        previous = s;
        ++changed;
    }

    public static void main(String[] args, String name, int score) throws FileNotFoundException, IOException {
        input = args;
        name1 = name;
        score1 = "" + score;
        String date1 = GameLoop.setDate() + "";
        System.out.println(score1);
        System.out.println(name1);
        System.out.println(date1);
        File s = new File("texts\\Scores.txt");
        File n = new File("texts\\Names.txt");
        File d = new File("texts\\Dates.txt");
        Scanner s1 = new Scanner(s);
        Scanner n1 = new Scanner(n);
        Scanner d1 = new Scanner(d);
        ArrayList<String> Scores = new ArrayList<String>();
        ArrayList<String> Names = new ArrayList<String>();
        ArrayList<String> Dates = new ArrayList<String>();
        int z = 0;
        Scores.add(z, HighScores.setL(score1));
        Names.add(z, name1);
        Dates.add(z, date1);
        while (n1.hasNextLine() && s1.hasNextInt() && d1.hasNextLine()) {
            Scores.add(++z, s1.nextLine());
            Names.add(z, n1.nextLine());
            Dates.add(z, d1.nextLine());
        }
        BufferedWriter s2 = new BufferedWriter(new FileWriter(s));
        BufferedWriter n2 = new BufferedWriter(new FileWriter(n));
        BufferedWriter d2 = new BufferedWriter(new FileWriter(d));
        s2.flush();
        n2.flush();
        d2.flush();
        for (int x = 0; x != Scores.size(); ++x) {
            if (x != 0) {
                s2.newLine();
                n2.newLine();
                d2.newLine();
            }
            s2.write(HighScores.setL("" + (String)Scores.get(x)));
            n2.write((String)Names.get(x));
            d2.write((String)Dates.get(x));
        }
        s2.close();
        n2.close();
        d2.close();
        File sa = new File("texts\\Scores.txt");
        File na = new File("texts\\Names.txt");
        File da = new File("texts\\Dates.txt");
        Scanner s122 = new Scanner(sa);
        Scanner n122 = new Scanner(na);
        Scanner d122 = new Scanner(da);
        scores2 = new String[Scores.size()];
        names2 = new String[Scores.size()];
        dates2 = new String[Scores.size()];
        for (int o = 0; o < Scores.size(); ++o) {
            HighScores.scores2[o] = "" + s122.next();
            HighScores.names2[o] = "" + n122.next();
            HighScores.dates2[o] = "" + d122.next();
        }
        spots = GameLoop.SortInts((String[])scores2);
        namesbyscores = GameLoop.SortBySpot((int[])spots, (String[])names2);
        scoresbyscores = GameLoop.SortBySpot((int[])spots, (String[])scores2);
        datesbyscores = GameLoop.SortBySpot((int[])spots, (String[])dates2);
        namesbyalpha = Alphabetize.alpha((String[])names2);
        scoresbyalpha = Alphabetize.alphaint((String[])scores2, (String[])names2);
        datesbyalpha = Alphabetize.alphaint((String[])dates2, (String[])names2);
        EventQueue.invokeLater((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public static String setL(String n) {
        String s = "";
        if (n.length() == 4) {
            return n;
        }
        if (n.length() == 3) {
            s = "0" + n;
        } else if (n.length() == 2) {
            s = "00" + n;
        } else if (n.length() == 1) {
            s = "000" + n;
        }
        return s;
    }

    static /* synthetic */ String[] access$000() {
        return names2;
    }

    static /* synthetic */ String[] access$100() {
        return scores2;
    }

    static /* synthetic */ void access$200(HighScores x0, ItemEvent x1) {
        x0.DropDownListItemStateChanged(x1);
    }

    static /* synthetic */ String[] access$300() {
        return dates2;
    }

    static /* synthetic */ void access$400(HighScores x0, ActionEvent x1) {
        x0.jButton1ActionPerformed(x1);
    }

    static {
        changed = 0;
        previous = "";
        scores2 = null;
        names2 = null;
        dates2 = null;
        restart = false;
        l = 0;
    }
}
