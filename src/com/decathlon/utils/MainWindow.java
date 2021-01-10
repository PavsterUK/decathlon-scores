package com.decathlon.utils;

import com.decathlon.Decathlon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainWindow extends JFrame implements ActionListener {

    private File selectedCSVFile;
    private File selectedOutputFile;

    public void open(){
        JFrame frame = new JFrame("Decathlon Points Calculator");
        frame.add(selectInputFileButton());
        frame.add(selectOutputFileButton());
        frame.add(getResultsButton());
        frame.setSize(400,150);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
    }

    private JButton selectInputFileButton(){
        JButton selectFileButton = new JButton("Select CSV file");
        selectFileButton.setBounds(50,20,120,30);
        selectFileButton.addActionListener(ae -> selectedCSVFile = UserDialogue.promptChooseFile());
        return selectFileButton;
    }

    private JButton selectOutputFileButton(){
        JButton saveAsButton = new JButton("Save results as");
        saveAsButton.setBounds(220,20,125,30);
        saveAsButton.addActionListener(ae -> selectedOutputFile = UserDialogue.promptSaveAs());
        return saveAsButton;
    }

    private JButton getResultsButton(){
        JButton getResultsButton = new JButton("Get Results");
        getResultsButton.setBounds(120,70,150,30);
        getResultsButton.addActionListener(ae -> {
            if (selectedCSVFile == null || selectedOutputFile == null){
                JOptionPane.showMessageDialog(
                        null, "Select Input/Output Files");
            } else {
                Decathlon decathlon = new Decathlon();
                decathlon.createAthleteList(selectedCSVFile);

            }
        });
        return getResultsButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
