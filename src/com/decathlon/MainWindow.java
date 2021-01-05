package com.decathlon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainWindow extends JFrame implements ActionListener {

    private boolean isWomenTournament;
    private File selectedCSVFile;
    private File selectedOutputFile;

    public void open(){
        JFrame frame = new JFrame("Decathlon Points Calculator");
        frame.add(isWomenTournamentCheckbox());
        frame.add(selectInputFileButton());
        frame.add(selectOutputFileButton());
        frame.add(getResultsButton());
        frame.setSize(400,200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
    }

    private JCheckBox isWomenTournamentCheckbox(){
        JCheckBox jCheckBox = new JCheckBox("Women Tournament");
        jCheckBox.setBounds(120,20,180,30);
        jCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if(jCheckBox.isSelected()) {
                    isWomenTournament = true;
                }
            }
        });
        return jCheckBox;
    }

    private JButton selectInputFileButton(){
        JButton selectFileButton = new JButton("Select CSV file");
        selectFileButton.setBounds(50,70,120,30);
        selectFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                selectedCSVFile = UserDialogue.promptChooseFile();
            }
        });
        return selectFileButton;
    }

    private JButton selectOutputFileButton(){
        JButton saveAsButton = new JButton("Select Output file");
        saveAsButton.setBounds(220,70,150,30);
        saveAsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                selectedOutputFile = UserDialogue.promptSaveAs();
            }
        });
        return saveAsButton;
    }

    private JButton getResultsButton(){
        JButton getResultsButton = new JButton("Get Results");
        getResultsButton.setBounds(120,120,150,30);
        getResultsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (selectedCSVFile == null || selectedOutputFile == null){
                    JOptionPane.showMessageDialog(
                            null, "Select Input/Output Files");
                } else {
                    Decathlon decathlon = new Decathlon(isWomenTournament);
                    decathlon.createAthleteList(selectedCSVFile);

                }
            }
        });
        return getResultsButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
