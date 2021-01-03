package com.decathlon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class MainWindow extends JFrame implements ActionListener {

    private boolean isWomenTournament;
    private File selectedCSVFile;
    private File selectedOutputFile;

    public void open(){
        //Main Box
        JFrame frame = new JFrame("Decathlon Points Calculator");

        //Checkbox for Women Tournament option
        JCheckBox checkBox1 = new JCheckBox("Women Tournament");
        checkBox1.setBounds(120,20,180,30);
        checkBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if(checkBox1.isSelected()) {
                    isWomenTournament = true;
                }
            }
        });

        //Button to select CSV file
        JButton selectFileButton = new JButton("Select CSV file");
        selectFileButton.setBounds(50,70,120,30);
        selectFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               selectedCSVFile = PromptDialogue.selectCSV();
            }
        });

        //Button for selecting output file
        JButton saveAsButton = new JButton("Select Output file");
        saveAsButton.setBounds(220,70,150,30);
        saveAsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                selectedOutputFile = PromptDialogue.saveAs();
            }
        });

        //Button for calculating result
        JButton getResltButton = new JButton("Get Results");
        getResltButton.setBounds(120,120,150,30);
        getResltButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               if (selectedCSVFile == null || selectedOutputFile == null){
                   JOptionPane.showMessageDialog(
                           frame, "Select Input/Output Files");
               } else {

               }
            }
        });

        frame.add(checkBox1);
        frame.add(selectFileButton);
        frame.add(saveAsButton);
        frame.add(getResltButton);
        frame.setSize(400,200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
