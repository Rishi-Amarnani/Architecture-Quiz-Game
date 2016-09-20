/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  archgame2.Finished
 *  archgame2.GameFrame$1
 *  archgame2.GameFrame$2
 *  archgame2.GameFrame$3
 *  archgame2.GameFrame$4
 *  archgame2.GameFrame$5
 *  archgame2.GameFrame$6
 */
package archgame2;

import archgame2.Finished;
import archgame2.GameFrame;
import archgame2.GameLoop;
import archgame2.Right;
import archgame2.Wrong;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

public class GameFrame
extends JFrame {
    public static String[] input = null;
    public static int spot = 0;
    private static boolean restart = false;
    private int n = 0;
    private int answered = 0;
    private int n2 = 0;
    private String[] right = null;
    private String[] a = null;
    private String[] b = null;
    private String[] c = null;
    private String[] d = null;
    private int[] nclues = null;
    private ArrayList<String> clues = new ArrayList();
    private int step = 0;
    private int[] steporder = new int[0];
    private int cluesused = 0;
    private int posspts = 100;
    private int score = 0;
    private int numcorrect = 0;
    private int numclues = 0;
    private String current = "";
    private String cluedisplay1 = "";
    private String cluedisplay2 = "";
    private String cluedisplay3 = "";
    private JButton A;
    private JLabel AText;
    private JButton B;
    private JLabel BText;
    private JButton C;
    private JLabel CText;
    private JLabel Clue1;
    private JLabel Clue2;
    private JLabel Clue3;
    private JLabel Clue4;
    private JTextArea CluesUsedArea;
    private JButton D;
    private JLabel DText;
    private JButton GiveAClueButton;
    private JTextArea NumQues;
    private JLabel Pic;
    private JTextArea PossPtsArea;
    private JTextArea TotalScoreArea;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;

    public GameFrame() throws FileNotFoundException, NoSuchElementException {
        Scanner in = new Scanner(new File("texts\\ArchGameText.txt"));
        this.n = in.nextInt();
        System.out.println(this.n);
        in.nextLine();
        this.right = new String[this.n];
        this.a = new String[this.n];
        this.b = new String[this.n];
        this.c = new String[this.n];
        this.d = new String[this.n];
        this.nclues = new int[this.n];
        this.clues = new ArrayList();
        for (int x = 0; x < this.n; ++x) {
            if (in.hasNextLine()) {
                this.right[x] = in.nextLine();
            }
            if (in.hasNextLine()) {
                this.a[x] = in.nextLine();
            }
            if (in.hasNextLine()) {
                this.b[x] = in.nextLine();
            }
            if (in.hasNextLine()) {
                this.c[x] = in.nextLine();
            }
            if (in.hasNextLine()) {
                this.d[x] = in.nextLine();
            }
            System.out.println(this.right[x]);
            System.out.println(this.a[x]);
            System.out.println(this.b[x]);
            System.out.println(this.c[x]);
            System.out.println(this.d[x]);
            if (in.hasNextLine()) {
                this.nclues[x] = Integer.parseInt(in.nextLine());
            }
            System.out.println(this.nclues[x]);
            for (int y = 0; y < this.nclues[x]; ++y) {
                String k = null;
                if (!in.hasNextLine()) continue;
                k = in.nextLine() + "";
                this.clues.add(k);
                System.out.println(k);
            }
        }
        this.steporder = new int[this.n];
        int[] numsToLength = new int[this.n];
        int i = 0;
        while (i < this.n) {
            numsToLength[i] = i++;
        }
        this.steporder = GameLoop.Randomize(numsToLength);
        this.step = this.steporder[0];
        if (restart) {
            spot = 0;
            restart = false;
        }
        this.initComponents();
    }

    public void setScore(int a) {
        this.score = a;
    }

    public void ReSet(boolean r) {
        this.setVisible(false);
        if (r) {
            ++this.numcorrect;
            Right.main(input, this, this.posspts, this.cluesused, this.nclues[this.step], GameLoop.getMinusPerClue(this.posspts, this.nclues[this.step]), this.score);
        } else if (!r) {
            Wrong.main(input, this.current, this.right[this.step], this.score, this);
        }
    }

    public void ReSet2() {
        if (++spot == this.steporder.length) {
            Finished.main((String[])input, (int)this.score, (int)this.numcorrect, (int)this.numclues);
            this.setVisible(false);
        } else {
            this.step = this.steporder[spot];
            this.AText.setText("" + this.a[this.step] + "");
            this.BText.setText("" + this.b[this.step] + "");
            this.CText.setText("" + this.c[this.step] + "");
            this.DText.setText("" + this.d[this.step] + "");
            this.Pic.setVisible(false);
            this.Pic.setIcon(new ImageIcon("pics\\pic" + (this.step + 1) + ".jpg"));
            this.Pic.setVisible(true);
            this.TotalScoreArea.setText("Score: " + this.score + "");
            this.GiveAClueButton.setText("Give a Clue! \n(-" + GameLoop.getMinusPerClue(this.posspts, this.nclues[this.step]) + "/Clue)");
            this.NumQues.setText("                 # " + (spot + 1) + "/" + this.a.length + "");
            this.cluesused = 0;
            this.Clue1.setText("");
            this.Clue2.setText("");
            this.Clue3.setText("");
            this.Clue4.setText("");
            this.setCluesUsed();
        }
    }

    public void setCluesUsed() {
        this.CluesUsedArea.setText(" Clues Used (" + this.cluesused + "/" + this.nclues[this.step] + ")");
        this.PossPtsArea.setText(" Points Possible: " + (this.posspts - this.cluesused * GameLoop.getMinusPerClue(this.posspts, this.nclues[this.step])) + "");
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.CluesUsedArea = new JTextArea();
        this.GiveAClueButton = new JButton();
        this.Clue1 = new JLabel();
        this.Clue2 = new JLabel();
        this.Clue3 = new JLabel();
        this.Clue4 = new JLabel();
        this.jScrollPane2 = new JScrollPane();
        this.PossPtsArea = new JTextArea();
        this.Pic = new JLabel();
        this.A = new JButton();
        this.B = new JButton();
        this.C = new JButton();
        this.D = new JButton();
        this.AText = new JLabel();
        this.BText = new JLabel();
        this.CText = new JLabel();
        this.DText = new JLabel();
        this.jScrollPane3 = new JScrollPane();
        this.TotalScoreArea = new JTextArea();
        this.jScrollPane4 = new JScrollPane();
        this.NumQues = new JTextArea();
        this.setDefaultCloseOperation(3);
        this.setTitle("Architecture Game");
        this.setBackground(new Color(0, 0, 255));
        this.setResizable(false);
        this.CluesUsedArea.setBackground(new Color(255, 0, 0));
        this.CluesUsedArea.setColumns(20);
        this.CluesUsedArea.setEditable(false);
        this.CluesUsedArea.setFont(new Font("SansSerif", 1, 18));
        this.CluesUsedArea.setForeground(new Color(240, 240, 240));
        this.CluesUsedArea.setLineWrap(true);
        this.CluesUsedArea.setRows(1);
        this.CluesUsedArea.setText("         Clues Used: ()\n");
        this.CluesUsedArea.setPreferredSize(new Dimension(100, 28));
        this.CluesUsedArea.setText(" Clues Used (" + this.cluesused + "/" + this.nclues[this.step] + ")");
        this.jScrollPane1.setViewportView(this.CluesUsedArea);
        this.GiveAClueButton.setFont(new Font("Tahoma", 0, 14));
        this.GiveAClueButton.setText("Give me a Clue! (-/Clue)");
        this.GiveAClueButton.setText("Give a Clue! \n(-" + GameLoop.getMinusPerClue(this.posspts, this.nclues[this.step]) + "/Clue)");
        this.GiveAClueButton.addActionListener((ActionListener)new /* Unavailable Anonymous Inner Class!! */);
        this.Clue1.setText("jLabel1");
        this.Clue1.setAutoscrolls(true);
        this.Clue1.setText("");
        this.Clue2.setText("jLabel1");
        this.Clue2.setAutoscrolls(true);
        this.Clue2.setText("");
        this.Clue3.setText("jLabel1");
        this.Clue3.setAutoscrolls(true);
        this.Clue3.setText("");
        this.Clue4.setText("jLabel1");
        this.Clue4.setAutoscrolls(true);
        this.Clue4.setText("");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(42, 42, 42).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Clue4, GroupLayout.Alignment.TRAILING, -1, 253, 32767).addComponent(this.Clue3, GroupLayout.Alignment.TRAILING, -1, 253, 32767).addComponent(this.Clue2, GroupLayout.Alignment.TRAILING, -1, 253, 32767).addComponent(this.Clue1, GroupLayout.Alignment.TRAILING, -1, 253, 32767).addComponent(this.jScrollPane1, 0, 0, 32767).addComponent(this.GiveAClueButton, -1, 253, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, -1, -2).addGap(22, 22, 22).addComponent(this.Clue1, -2, 56, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Clue2, -2, 57, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Clue3, -2, 51, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Clue4, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, 32767).addComponent(this.GiveAClueButton, -2, 104, -2).addGap(92, 92, 92)));
        this.jScrollPane2.setAutoscrolls(true);
        this.jScrollPane2.setHorizontalScrollBar(null);
        this.PossPtsArea.setBackground(new Color(255, 0, 0));
        this.PossPtsArea.setColumns(20);
        this.PossPtsArea.setEditable(false);
        this.PossPtsArea.setFont(new Font("SansSerif", 1, 18));
        this.PossPtsArea.setForeground(new Color(255, 255, 255));
        this.PossPtsArea.setLineWrap(true);
        this.PossPtsArea.setRows(1);
        this.PossPtsArea.setText(" Poss Pts: \n");
        this.PossPtsArea.setText(" Points Possible: " + this.posspts + "");
        this.PossPtsArea.setWrapStyleWord(true);
        this.PossPtsArea.setAutoscrolls(false);
        this.PossPtsArea.setPreferredSize(new Dimension(344, 28));
        this.jScrollPane2.setViewportView(this.PossPtsArea);
        this.Pic = new JLabel(new ImageIcon("pics\\pic" + (this.step + 1) + ".jpg"));
        this.A.setText("A");
        this.A.addActionListener((ActionListener)new /* Unavailable Anonymous Inner Class!! */);
        this.B.setText("B");
        this.B.addActionListener((ActionListener)new /* Unavailable Anonymous Inner Class!! */);
        this.C.setText("C");
        this.C.addActionListener((ActionListener)new /* Unavailable Anonymous Inner Class!! */);
        this.D.setText("D");
        this.D.addActionListener((ActionListener)new /* Unavailable Anonymous Inner Class!! */);
        this.AText.setFont(new Font("Trebuchet MS", 0, 16));
        this.AText.setText("jLabel1");
        this.AText.setText("" + this.a[this.step].substring(2) + "");
        this.BText.setFont(new Font("Trebuchet MS", 0, 16));
        this.BText.setText("jLabel2");
        this.BText.setText("" + this.b[this.step].substring(2) + "");
        this.CText.setFont(new Font("Trebuchet MS", 0, 16));
        this.CText.setText("jLabel3");
        this.CText.setText("" + this.c[this.step].substring(2) + "");
        this.DText.setFont(new Font("Trebuchet MS", 0, 16));
        this.DText.setText("jLabel4");
        this.DText.setText("" + this.d[this.step].substring(2) + "");
        this.TotalScoreArea.setBackground(new Color(255, 0, 0));
        this.TotalScoreArea.setColumns(20);
        this.TotalScoreArea.setEditable(false);
        this.TotalScoreArea.setFont(new Font("SansSerif", 1, 18));
        this.TotalScoreArea.setForeground(new Color(255, 255, 255));
        this.TotalScoreArea.setLineWrap(true);
        this.TotalScoreArea.setRows(1);
        this.TotalScoreArea.setText("Score:");
        this.TotalScoreArea.setText(" Score: " + this.score);
        this.TotalScoreArea.setWrapStyleWord(true);
        this.TotalScoreArea.setAlignmentX(3.0f);
        this.TotalScoreArea.setAlignmentY(3.0f);
        this.jScrollPane3.setViewportView(this.TotalScoreArea);
        this.NumQues.setBackground(new Color(255, 0, 0));
        this.NumQues.setColumns(20);
        this.NumQues.setEditable(false);
        this.NumQues.setFont(new Font("SansSerif", 1, 18));
        this.NumQues.setForeground(new Color(255, 255, 255));
        this.NumQues.setLineWrap(true);
        this.NumQues.setRows(1);
        this.NumQues.setText("              #1/65");
        this.NumQues.setText("                 # " + (spot + 1) + "/" + this.a.length + "");
        this.NumQues.setWrapStyleWord(true);
        this.NumQues.setAlignmentX(3.0f);
        this.NumQues.setAlignmentY(3.0f);
        this.jScrollPane4.setViewportView(this.NumQues);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(68, 68, 68).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.A, -1, -1, 32767).addComponent(this.C, -1, -1, 32767).addComponent(this.B, -1, -1, 32767).addComponent(this.D)).addGap(37, 37, 37).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.DText, -1, 295, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.BText, -1, -1, 32767).addComponent(this.CText).addComponent(this.AText, -2, 295, -2))).addGap(46, 46, 46)).addComponent(this.Pic, -2, 300, -2))).addGroup(layout.createSequentialGroup().addGap(115, 115, 115).addComponent(this.jScrollPane4, -2, 216, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane3, -1, 233, 32767).addComponent(this.jScrollPane2, -2, 233, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addGap(22, 22, 22).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane4).addComponent(this.jScrollPane2, -2, -1, -2)).addGap(18, 35, 32767).addComponent(this.Pic, -2, 255, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.A, -2, 23, -2).addComponent(this.AText)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.B).addComponent(this.BText)).addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.CText).addComponent(this.C)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.D).addComponent(this.DText))).addComponent(this.jScrollPane3, -2, -1, -2)).addGap(58, 58, 58)));
        this.pack();
    }

    private void AActionPerformed(ActionEvent evt) {
        String ans;
        this.current = ans = this.AText.getText();
        String rigght = this.right[this.step];
        GameLoop.addScore(this.posspts, this.cluesused, this.nclues[this.step], this.score, GameLoop.isRight(rigght, ans, this.step));
        this.ReSet(GameLoop.isRight(rigght, ans, this.step));
    }

    private void BActionPerformed(ActionEvent evt) {
        String ans;
        this.current = ans = this.BText.getText();
        String rigght = this.right[this.step];
        GameLoop.addScore(this.posspts, this.cluesused, this.nclues[this.step], this.score, GameLoop.isRight(rigght, ans, this.step));
        this.ReSet(GameLoop.isRight(rigght, ans, this.step));
    }

    private void CActionPerformed(ActionEvent evt) {
        String ans;
        this.current = ans = this.CText.getText();
        String rigght = this.right[this.step];
        GameLoop.addScore(this.posspts, this.cluesused, this.nclues[this.step], this.score, GameLoop.isRight(rigght, ans, this.step));
        this.ReSet(GameLoop.isRight(rigght, ans, this.step));
    }

    private void DActionPerformed(ActionEvent evt) {
        String ans;
        this.current = ans = this.DText.getText();
        String rigght = this.right[this.step];
        GameLoop.addScore(this.posspts, this.cluesused, this.nclues[this.step], this.score, GameLoop.isRight(rigght, ans, this.step));
        this.ReSet(GameLoop.isRight(rigght, ans, this.step));
    }

    private void GiveAClueButtonActionPerformed(ActionEvent evt) {
        if (this.cluesused + 1 > this.nclues[this.step]) {
            JOptionPane j = new JOptionPane();
            JOptionPane.showMessageDialog(this.rootPane, "You have already used all the clues for this question.");
            j.show();
        } else {
            ++this.numclues;
            JLabel l = new JLabel();
            if (this.cluesused == 0) {
                l = this.Clue1;
            } else if (this.cluesused == 1) {
                l = this.Clue2;
            } else if (this.cluesused == 2) {
                l = this.Clue3;
            } else if (this.cluesused == 3) {
                l = this.Clue4;
            }
            int ClueSpot = 0;
            for (int x = 0; x < this.step; ++x) {
                ClueSpot += this.nclues[x];
            }
            l.setText(this.clues.get(ClueSpot + this.cluesused));
            ++this.cluesused;
            this.setCluesUsed();
        }
    }

    public static void main(String[] args, boolean rst) throws FileNotFoundException {
        input = args;
        restart = rst;
        EventQueue.invokeLater((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ void access$000(GameFrame x0, ActionEvent x1) {
        x0.GiveAClueButtonActionPerformed(x1);
    }

    static /* synthetic */ void access$100(GameFrame x0, ActionEvent x1) {
        x0.AActionPerformed(x1);
    }

    static /* synthetic */ void access$200(GameFrame x0, ActionEvent x1) {
        x0.BActionPerformed(x1);
    }

    static /* synthetic */ void access$300(GameFrame x0, ActionEvent x1) {
        x0.CActionPerformed(x1);
    }

    static /* synthetic */ void access$400(GameFrame x0, ActionEvent x1) {
        x0.DActionPerformed(x1);
    }
}
