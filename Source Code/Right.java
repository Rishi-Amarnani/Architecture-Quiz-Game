/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  archgame2.GameFrame
 *  archgame2.Right$1
 *  archgame2.Right$2
 */
package archgame2;

import archgame2.GameFrame;
import archgame2.Right;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;

public class Right
extends JFrame {
    private static GameFrame d = null;
    private static int posspts = 0;
    private static int cused = 0;
    private static int ncs = 0;
    private static int mpc = 0;
    private static int ttl = 0;
    private static int ttlprev = 0;
    private static int plusscore = 0;
    private static int pdeducted = 0;
    private JLabel PlusScore;
    private JLabel Points2;
    private JLabel Points3;
    private JLabel Points4;
    private JLabel Points5;
    private JLabel Points9;
    private JLabel PossPoints;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;

    public Right() {
        this.initComponents();
    }

    public Right(GameFrame c) {
        this.initComponents();
        d = c;
    }

    public static void setVars(GameFrame in, int ppts1, int cused1, int ncs1, int mpc1, int ttl1, boolean done) {
        d = in;
        posspts = ppts1;
        cused = cused1;
        ncs = ncs1;
        mpc = mpc1;
        if (done) {
            int pscore = 0;
            pdeducted = 0;
            Right.addScore(posspts, cused, ncs, ttl, pscore, pdeducted);
            d.setScore(ttl);
        }
    }

    public void setTexts() {
        Right.setVars(d, posspts, cused, ncs, mpc, ttl, true);
        this.PlusScore.setText("" + plusscore + "");
        this.PossPoints.setText("" + posspts + "");
        this.Points2.setText("" + mpc + "");
        this.Points3.setText("" + cused + "/" + ncs + "");
        this.Points4.setText("" + pdeducted + "");
        this.Points9.setText("" + ttl + "");
    }

    public static void addScore(int posspts1, int cluesused1, int nclues1, int totalscore1, int pscore1, int pd) {
        int totaladd;
        int totalminus;
        int possminus = (int)Math.round((double)posspts1 * 0.8);
        double perminus = Math.floor((double)possminus * 1.0 / ((double)nclues1 * 1.0));
        pd = totalminus = (int)((double)cluesused1 * perminus);
        pdeducted = totalminus;
        plusscore = totaladd = posspts1 - totalminus;
        plusscore = pscore1 = totaladd;
        ttl = totalscore1 = ttl + totaladd;
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.PlusScore = new JLabel();
        this.Points2 = new JLabel();
        this.Points9 = new JLabel();
        this.Points3 = new JLabel();
        this.Points4 = new JLabel();
        this.jButton1 = new JButton();
        this.Points5 = new JLabel();
        this.jLabel10 = new JLabel();
        this.PossPoints = new JLabel();
        this.setDefaultCloseOperation(3);
        this.jLabel1.setFont(new Font("Franklin Gothic Medium", 1, 36));
        this.jLabel1.setText("        Congratulations!");
        this.jLabel3.setFont(new Font("Century Gothic", 1, 16));
        this.jLabel3.setText("                              You got it right!...");
        this.jLabel4.setFont(new Font("Century Gothic", 1, 20));
        this.jLabel4.setText(" Breakdown of Points");
        this.jLabel5.setFont(new Font("Century Gothic", 1, 16));
        this.jLabel5.setText("Points Possible for This Question:");
        this.jLabel6.setFont(new Font("Century Gothic", 1, 16));
        this.jLabel6.setText("Number of Clues Used:");
        this.jLabel7.setFont(new Font("Century Gothic", 1, 16));
        this.jLabel7.setText("Points Deducted per Clue: ");
        this.jLabel8.setFont(new Font("Century Gothic", 1, 16));
        this.jLabel8.setText("Points Deducted:");
        this.jLabel9.setFont(new Font("Century Gothic", 1, 16));
        this.PlusScore.setFont(new Font("Century Gothic", 1, 36));
        this.PlusScore.setText("45");
        this.Points2.setFont(new Font("Century Gothic", 1, 20));
        this.Points2.setText("00");
        this.Points9.setFont(new Font("Century Gothic", 1, 20));
        this.Points9.setText("00");
        this.Points3.setFont(new Font("Century Gothic", 1, 20));
        this.Points3.setText("00");
        this.Points4.setFont(new Font("Century Gothic", 1, 20));
        this.Points4.setText("00");
        this.setTexts();
        this.jButton1.setText("Next");
        this.jButton1.addActionListener((ActionListener)new /* Unavailable Anonymous Inner Class!! */);
        this.Points5.setFont(new Font("Century Gothic", 0, 36));
        this.Points5.setText("+");
        this.jLabel10.setFont(new Font("Century Gothic", 1, 20));
        this.jLabel10.setText("Total Score:");
        this.PossPoints.setFont(new Font("Century Gothic", 1, 20));
        this.PossPoints.setText("100");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(149, 149, 149).addComponent(this.jLabel9)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(78, 78, 78).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(59, 59, 59).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4, -2, 215, -2).addGroup(layout.createSequentialGroup().addGap(50, 50, 50).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel5, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.jLabel8).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.Points4, -2, 75, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel10, -2, 121, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, 32767).addComponent(this.jButton1)).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Points9, -2, 58, -2)))).addComponent(this.PossPoints, -2, 75, -2))).addGroup(layout.createSequentialGroup().addComponent(this.jLabel6, -2, 182, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Points3, -2, 75, -2)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Points2, -2, 75, -2)))).addGroup(layout.createSequentialGroup().addGap(221, 221, 221).addComponent(this.jLabel3, -2, 271, -2)))).addGroup(layout.createSequentialGroup().addGap(132, 132, 132).addComponent(this.Points5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.PlusScore, -2, 98, -2)))).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(143, 143, 143).addComponent(this.jLabel1, -2, 499, -2)))).addContainerGap(74, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(114, 114, 114).addComponent(this.jLabel1, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel3, -2, 43, -2).addGap(68, 68, 68)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.PlusScore, -2, 79, -2).addComponent(this.Points5, -2, 43, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4, -2, 43, -2).addComponent(this.jLabel10, -2, 43, -2).addComponent(this.Points9)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5, -2, 31, -2).addComponent(this.PossPoints)).addGap(6, 6, 6).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.Points2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6, -2, 31, -2).addComponent(this.Points3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.Points4)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel9)).addComponent(this.jButton1)).addContainerGap(43, 32767)));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        d.setVisible(true);
        d.ReSet2();
    }

    public static void main(String[] args, GameFrame a, int ppts, int cluesused, int nclues, int minusperclue, int total1) {
        Right.setVars(a, ppts, cluesused, nclues, minusperclue, total1, false);
        EventQueue.invokeLater((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ void access$000(Right x0, ActionEvent x1) {
        x0.jButton1ActionPerformed(x1);
    }
}
