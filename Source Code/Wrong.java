/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  archgame2.GameFrame
 *  archgame2.Wrong$1
 *  archgame2.Wrong$2
 */
package archgame2;

import archgame2.GameFrame;
import archgame2.Wrong;
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

public class Wrong
extends JFrame {
    private static String urans1 = "";
    private static String ans1 = "";
    private static int ttl1 = 0;
    private static GameFrame d = null;
    private JLabel CorAns;
    private JLabel Points;
    private JLabel Points5;
    private JLabel TotalScore;
    private JLabel UrAns;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel3;

    public Wrong() {
        this.initComponents();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jLabel3 = new JLabel();
        this.Points = new JLabel();
        this.Points5 = new JLabel();
        this.jLabel10 = new JLabel();
        this.TotalScore = new JLabel();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.CorAns = new JLabel();
        this.UrAns = new JLabel();
        this.jButton1 = new JButton();
        this.setDefaultCloseOperation(3);
        this.jLabel1.setFont(new Font("Franklin Gothic Medium", 1, 36));
        this.jLabel1.setText("        Dang it!");
        this.jLabel3.setFont(new Font("Century Gothic", 1, 16));
        this.jLabel3.setText("                              You missed it!...");
        this.Points.setFont(new Font("Century Gothic", 1, 36));
        this.Points.setText("0");
        this.Points5.setFont(new Font("Century Gothic", 0, 36));
        this.Points5.setText("+");
        this.jLabel10.setFont(new Font("Century Gothic", 1, 20));
        this.jLabel10.setText("Total Score:");
        this.TotalScore.setFont(new Font("Century Gothic", 1, 20));
        this.TotalScore.setText("00");
        this.setUp();
        this.jLabel11.setFont(new Font("Century Gothic", 1, 20));
        this.jLabel11.setText("Your Answer:");
        this.jLabel12.setFont(new Font("Century Gothic", 1, 20));
        this.jLabel12.setText("Correct Answer:");
        this.CorAns.setFont(new Font("Century Gothic", 1, 20));
        this.CorAns.setText("C. ...");
        this.UrAns.setFont(new Font("Century Gothic", 1, 20));
        this.UrAns.setText("A. ...");
        this.jButton1.setText("Next");
        this.setUp();
        this.jButton1.addActionListener((ActionListener)new /* Unavailable Anonymous Inner Class!! */);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(178, 178, 178).addComponent(this.jLabel1, -2, 259, -2).addContainerGap(252, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(75, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.jLabel12).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.CorAns, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel11, -2, 139, -2).addComponent(this.Points5)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.Points, -2, 32, -2).addGap(77, 77, 77).addComponent(this.jLabel3, -2, 271, -2)).addComponent(this.UrAns, -1, -1, 32767))).addGroup(layout.createSequentialGroup().addComponent(this.jLabel10, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.TotalScore, -2, 58, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton1))).addGap(89, 89, 89)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(133, 133, 133).addComponent(this.jLabel1, -2, 50, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel3, -2, 43, -2)).addGroup(layout.createSequentialGroup().addGap(28, 28, 28).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Points, -2, 58, -2).addComponent(this.Points5, -2, 43, -2)))).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel11, -2, 43, -2).addComponent(this.UrAns)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel12, -2, 43, -2).addComponent(this.CorAns)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10, -2, 43, -2).addComponent(this.TotalScore).addComponent(this.jButton1)).addGap(49, 49, 49)));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        d.setVisible(true);
        d.ReSet2();
    }

    public static void main(String[] args, String yourans, String ans, int ttl, GameFrame a) {
        urans1 = yourans;
        ans1 = ans;
        ttl1 = ttl;
        d = a;
        EventQueue.invokeLater((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void setUp() {
        this.UrAns.setText("" + urans1 + "");
        this.CorAns.setText("" + ans1 + "");
        this.TotalScore.setText("" + ttl1 + "");
    }

    static /* synthetic */ void access$000(Wrong x0, ActionEvent x1) {
        x0.jButton1ActionPerformed(x1);
    }
}
