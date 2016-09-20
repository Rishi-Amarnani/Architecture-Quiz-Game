/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  archgame2.GameFrame
 *  archgame2.Instructions$1
 *  archgame2.Instructions$2
 */
package archgame2;

import archgame2.GameFrame;
import archgame2.Instructions;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

public class Instructions
extends JFrame {
    public static String[] input = null;
    private static boolean restart = false;
    private JButton NextButton;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;

    public Instructions() {
        this.initComponents();
    }

    private void initComponents() {
        this.NextButton = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.jTextArea1 = new JTextArea();
        this.setDefaultCloseOperation(3);
        this.NextButton.setText("Next");
        this.NextButton.addActionListener((ActionListener)new /* Unavailable Anonymous Inner Class!! */);
        this.jScrollPane1.setWheelScrollingEnabled(false);
        this.jTextArea1.setBackground(new Color(255, 0, 0));
        this.jTextArea1.setColumns(16);
        this.jTextArea1.setEditable(false);
        this.jTextArea1.setFont(new Font("Monospaced", 1, 14));
        this.jTextArea1.setForeground(new Color(255, 255, 255));
        this.jTextArea1.setLineWrap(true);
        this.jTextArea1.setRows(3);
        this.jTextArea1.setTabSize(6);
        this.jTextArea1.setText("       This is an architecture Trivia game. \n\n     You will be shown a picture of a piece of \n      architecture and given 4 answer choices.\n                Choose one of them.\n\n      If you do not know the answer, click \n           the CLUE button to get a clue.\n\n       Points are deducted for each clue used. \n        The more clues you use on a question, \n          the less the question is worth.\n\n          Click \"Next\" when you are ready.\n      \n     ");
        this.jTextArea1.setWrapStyleWord(true);
        this.jScrollPane1.setViewportView(this.jTextArea1);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(59, 59, 59).addComponent(this.jScrollPane1, -2, 401, -2)).addGroup(layout.createSequentialGroup().addGap(230, 230, 230).addComponent(this.NextButton))).addContainerGap(68, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(42, 42, 42).addComponent(this.jScrollPane1, -2, 329, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, 32767).addComponent(this.NextButton).addGap(27, 27, 27)));
        this.pack();
    }

    private void NextButtonActionPerformed(ActionEvent evt) {
        try {
            GameFrame.main((String[])input, (boolean)restart);
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Instructions.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }

    public static void main(String[] args, boolean rst) {
        input = args;
        restart = rst;
        EventQueue.invokeLater((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ void access$000(Instructions x0, ActionEvent x1) {
        x0.NextButtonActionPerformed(x1);
    }
}
