/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  archgame2.GameFrame
 *  archgame2.HighScores2
 *  archgame2.Instructions
 *  archgame2.Menu$1
 *  archgame2.Menu$2
 *  archgame2.Menu$3
 *  archgame2.Menu$4
 */
package archgame2;

import archgame2.GameFrame;
import archgame2.HighScores2;
import archgame2.Instructions;
import archgame2.Menu;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

public class Menu
extends JFrame {
    private static String[] input;
    private static boolean restart;
    private JButton HiScores;
    private JButton Inst;
    private JButton Start;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea1;
    private JTextArea jTextArea2;

    public Menu() {
        this.initComponents();
    }

    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.jTextArea1 = new JTextArea();
        this.jPanel1 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.jTextArea2 = new JTextArea();
        this.Start = new JButton();
        this.Inst = new JButton();
        this.HiScores = new JButton();
        this.jTextArea1.setColumns(20);
        this.jTextArea1.setFont(new Font("Monospaced", 0, 12));
        this.jTextArea1.setLineWrap(true);
        this.jTextArea1.setRows(5);
        this.jTextArea1.setText("   Welcome to the Architecture Game!\n\n     If this is your first time, \n     please read the instructions.");
        this.jTextArea1.setAlignmentX(4.0f);
        this.jTextArea1.setAlignmentY(4.0f);
        this.jTextArea1.setCursor(new Cursor(2));
        this.jScrollPane1.setViewportView(this.jTextArea1);
        this.setDefaultCloseOperation(3);
        this.jPanel1.setToolTipText("Main Menu");
        this.jPanel1.setName("Main Menu");
        this.jTextArea2.setBackground(new Color(255, 0, 0));
        this.jTextArea2.setColumns(20);
        this.jTextArea2.setEditable(false);
        this.jTextArea2.setFont(new Font("Monospaced", 1, 14));
        this.jTextArea2.setForeground(new Color(255, 255, 255));
        this.jTextArea2.setLineWrap(true);
        this.jTextArea2.setRows(5);
        this.jTextArea2.setText("  Welcome to the Architecture Game!\n\n    If this is your first time, \n   please read the instructions.");
        this.jTextArea2.setWrapStyleWord(true);
        this.jTextArea2.setCaretColor(new Color(255, 255, 255));
        this.jScrollPane2.setViewportView(this.jTextArea2);
        this.Start.setText("Start");
        this.Start.addActionListener((ActionListener)new /* Unavailable Anonymous Inner Class!! */);
        this.Inst.setText("How to Play");
        this.Inst.addActionListener((ActionListener)new /* Unavailable Anonymous Inner Class!! */);
        this.HiScores.setText("High Scores");
        this.HiScores.addActionListener((ActionListener)new /* Unavailable Anonymous Inner Class!! */);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(120, 120, 120).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.Inst).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.HiScores)).addComponent(this.jScrollPane2, -2, 299, -2)).addContainerGap(121, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(230, 32767).addComponent(this.Start, -2, 82, -2).addGap(228, 228, 228)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(58, 58, 58).addComponent(this.jScrollPane2, -2, 172, -2).addGap(31, 31, 31).addComponent(this.Start, -2, 47, -2).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Inst).addComponent(this.HiScores)).addContainerGap(131, 32767)));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2));
        this.pack();
    }

    private void StartActionPerformed(ActionEvent evt) {
        try {
            GameFrame.main((String[])input, (boolean)restart);
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }

    private void InstActionPerformed(ActionEvent evt) {
        Instructions.main((String[])input, (boolean)restart);
        this.setVisible(false);
    }

    private void HiScoresActionPerformed(ActionEvent evt) {
        try {
            HighScores2.main((String[])input, (boolean)restart);
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }

    public static void main(String[] args, boolean rst) {
        input = args;
        restart = rst;
        EventQueue.invokeLater((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ void access$000(Menu x0, ActionEvent x1) {
        x0.StartActionPerformed(x1);
    }

    static /* synthetic */ void access$100(Menu x0, ActionEvent x1) {
        x0.InstActionPerformed(x1);
    }

    static /* synthetic */ void access$200(Menu x0, ActionEvent x1) {
        x0.HiScoresActionPerformed(x1);
    }
}
