package com.decathlon;

import javax.swing.*;
import java.io.File;

public class UserDialogue {

    public static File promptChooseFile(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select CSV File");
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public static File promptSaveAs(){
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Specify a destination file");
        int userSelection = chooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }
}
