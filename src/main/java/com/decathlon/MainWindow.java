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

/**
 * Main GUI Window with buttons and
 * event listeners.
 */

public class MainWindow extends JFrame  {

    private File selectedCSVFile;
    private String selectedOutputFile;

    /**
     * Create Frame, put together all elements and display.
     */
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

    /**
     * Button "Select CSV file".
     * Contains event listener, activates @FileChooser.promptChooseFile().
     * Selected result stored in @selectedCSVFile field.
     *
     * @return [JButton]
     */
    private JButton inputFileButton(){
        JButton selectFileButton = new JButton("Select CSV file");
        selectFileButton.setBounds(50,20,120,30);
        selectFileButton.addActionListener(ae -> selectedCSVFile = FileChooser.promptChooseFile());
        return selectFileButton;
    }

    /**
     * Button "Save results as".
     * Contains event listener, activates @FileChooser.promptSaveAs()
     * Selected result stored in @selectedOutputFile field.
     *
     * @return [JButton]
     */
    private JButton outputFileButton(){
        JButton saveAsButton = new JButton("Save results as");
        saveAsButton.setBounds(220,20,125,30);
        saveAsButton.addActionListener(ae -> selectedOutputFile = FileChooser.promptSaveAs());
        return saveAsButton;
    }

    /**
     * Button "Get Results".
     * Contains event listener.
     *
     * Checks if input/output files selected, if so
     * proceeds with calculation and shows confirmation
     * message, otherwise prompts message asking to
     * select required files.
     *
     * @return [JButton]
     */
    private JButton getResultsButton(){
        JButton getResultsButton = new JButton("Get Results");
        getResultsButton.setBounds(120,70,150,30);
        getResultsButton.addActionListener(ae -> {
            if (selectedCSVFile == null || selectedOutputFile == null){
                JOptionPane.showMessageDialog(
                        null, "Select Input/Output Files");
            } else {
                List<Athlete> athleteList = CSVParser.getAthleteList(
                        CSVParser.parseCSV(selectedCSVFile));
                Decathlon dec = new Decathlon(athleteList);
                dec.initialize();
                String htmlString = HTMLGenerator.makeHTMLString(dec.getAthleteList());
                HTMLGenerator.createHTMLFile(htmlString, selectedOutputFile);
                JOptionPane.showMessageDialog(
                        null, "File processed successfully");
            }
        });
        return getResultsButton;
    }

}
