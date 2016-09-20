/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  archgame2.Finished$1
 *  archgame2.Finished$2
 *  archgame2.Finished$3
 */
package archgame2;

import archgame2.Finished;
import archgame2.HighScores;
import archgame2.Menu;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

public class Finished
extends JFrame {
    private static String[] input;
    private static int total;
    private static int ques;
    private static int cluess;
    private JTextArea NameArea;
    private JButton Next;
    private JButton SKIP;
    private JLabel Score;
    private JLabel Score2;
    private JLabel Score3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JScrollPane jScrollPane1;

    public Finished() {
        this.initComponents();
        this.Score.setText("" + total + "");
        this.Score2.setText("" + ques + "");
        this.Score3.setText("" + cluess + "");
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.Score = new JLabel();
        this.Score2 = new JLabel();
        this.Score3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.NameArea = new JTextArea();
        this.jLabel5 = new JLabel();
        this.Next = new JButton();
        this.SKIP = new JButton();
        this.jLabel6 = new JLabel();
        this.setDefaultCloseOperation(3);
        this.setTitle("Architecture Game");
        this.jLabel1.setFont(new Font("Microsoft YaHei UI", 1, 36));
        this.jLabel1.setText("Final Score:");
        this.jLabel2.setFont(new Font("Microsoft YaHei UI", 1, 18));
        this.jLabel2.setText("Questions Answered Correctly:");
        this.jLabel3.setFont(new Font("Microsoft YaHei UI", 1, 18));
        this.jLabel3.setText("Clues Used:");
        this.Score.setFont(new Font("Tahoma", 1, 36));
        this.Score.setText("0000");
        this.Score.setAlignmentX(0.5f);
        this.Score2.setFont(new Font("Microsoft YaHei UI", 1, 18));
        this.Score2.setText("0000");
        this.Score3.setFont(new Font("Microsoft YaHei UI", 1, 18));
        this.Score3.setText("0000");
        this.jLabel4.setFont(new Font("Tahoma", 0, 14));
        this.jLabel4.setText("Now Please Enter Your Name to be recorded in the high scores list.");
        this.NameArea.setColumns(20);
        this.NameArea.setFont(new Font("Monospaced", 0, 18));
        this.NameArea.setRows(2);
        this.jScrollPane1.setViewportView(this.NameArea);
        this.jLabel5.setFont(new Font("Tahoma", 0, 14));
        this.jLabel5.setText("Press \"Don't Record\" if you don't want to record this score.");
        this.Next.setText("Next");
        this.Next.addActionListener((ActionListener)new /* Unavailable Anonymous Inner Class!! */);
        this.SKIP.setText("Don't Record");
        this.SKIP.addActionListener((ActionListener)new /* Unavailable Anonymous Inner Class!! */);
        this.jLabel6.setFont(new Font("Tahoma", 0, 14));
        this.jLabel6.setText("Press \"Next\" When Ready.");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(276, 32767).addComponent(this.jLabel1).addGap(10, 10, 10).addComponent(this.Score, -2, 143, -2).addGap(249, 249, 249)).addGroup(layout.createSequentialGroup().addGap(142, 142, 142).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.Score3, -2, 94, -2)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.Score2, -2, 86, -2)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel4, -2, 406, -2).addGap(32, 32, 32).addComponent(this.jScrollPane1, -2, 273, -2))).addContainerGap(33, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel6, -2, 297, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 187, 32767).addComponent(this.Next).addGap(18, 18, 18).addComponent(this.SKIP).addGap(92, 92, 92)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel5, -2, 373, -2).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(99, 99, 99).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1, -2, 92, -2).addComponent(this.Score, -1, 92, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2, -2, 37, -2).addComponent(this.Score2, -1, 37, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3, -2, 41, -2).addComponent(this.Score3, -1, 41, 32767)).addGap(33, 33, 33).addComponent(this.jLabel4, -1, 56, 32767)).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -2, 45, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addGap(35, 35, 35).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Next).addComponent(this.SKIP)).addGap(90, 90, 90)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel6, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel5, -2, 47, -2).addGap(42, 42, 42)))));
        this.pack();
    }

    private void NextActionPerformed(ActionEvent evt) {
        String name = this.NameArea.getText();
        int score1 = total;
        if (name.equals("")) {
            JOptionPane j = new JOptionPane();
            JOptionPane.showMessageDialog(this.rootPane, "Please enter your name in the box. If you do not want to record this in the highscores, press DON'T RECORD.");
            j.show();
        } else {
            try {
                HighScores.main(input, name, score1);
                this.setVisible(false);
            }
            catch (FileNotFoundException ex) {
                Logger.getLogger(Finished.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IOException ex) {
                Logger.getLogger(Finished.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void SKIPActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        Menu.main(input, true);
    }

    public static void main(String[] args, int score, int questions, int clues) {
        input = args;
        total = score;
        ques = questions;
        cluess = clues;
        EventQueue.invokeLater((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ void access$000(Finished x0, ActionEvent x1) {
        x0.NextActionPerformed(x1);
    }

    static /* synthetic */ void access$100(Finished x0, ActionEvent x1) {
        x0.SKIPActionPerformed(x1);
    }
}
