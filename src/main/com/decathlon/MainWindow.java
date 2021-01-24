package com.decathlon;

import com.decathlon.domain.Athlete;
import com.decathlon.domain.Decathlon;
import com.decathlon.utils.CSVParser;
import com.decathlon.utils.FileChooser;
import com.decathlon.utils.HTMLGenerator;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;


public class MainWindow extends JFrame  {

    private File selectedCSVFile;
    private String selectedOutputFile;

    public void open(){
        JFrame frame = new JFrame("Decathlon Points Calculator");
        frame.add(inputFileButton());
        frame.add(outputFileButton());
        frame.add(getResultsButton());
        frame.setSize(400,150);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
    }

    private JButton inputFileButton(){
        JButton selectFileButton = new JButton("Select CSV file");
        selectFileButton.setBounds(50,20,120,30);
        selectFileButton.addActionListener(ae -> selectedCSVFile = FileChooser.promptChooseFile());
        return selectFileButton;
    }

    private JButton outputFileButton(){
        JButton saveAsButton = new JButton("Save results as");
        saveAsButton.setBounds(220,20,125,30);
        saveAsButton.addActionListener(ae -> selectedOutputFile = FileChooser.promptSaveAs());
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
                List<Athlete> athleteList = CSVParser.getAthleteList(
                        CSVParser.getData(selectedCSVFile));
                Decathlon dec = new Decathlon(athleteList);
                dec.initialize();
                String htmlString = HTMLGenerator.makeHTMLString(dec.getATHLETE_LIST());
                HTMLGenerator.createHTMLFile(htmlString, selectedOutputFile);
                JOptionPane.showMessageDialog(
                        null, "File processed successfully");
            }
        });
        return getResultsButton;
    }

}
