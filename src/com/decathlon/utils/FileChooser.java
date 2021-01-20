package com.decathlon.utils;

import javax.swing.*;
import java.io.File;

public class FileChooser {

    public static File promptChooseFile(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select CSV File");
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public static String promptSaveAs(){
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save results as");
        int userSelection = chooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String fileName = chooser.getSelectedFile().toString();
            if (!fileName.endsWith(".html")) {
                fileName += ".html";
            }
            System.out.println(fileName);
            return fileName;
        }
        return null;
    }
}
