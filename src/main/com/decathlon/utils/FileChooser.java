package com.decathlon.utils;

import javax.swing.*;
import java.io.File;


/**
 * Utility class used to prompt user dialog
 * window for selecting file containing
 * athletes data for processing.
 *
 * It also used to select output file name and directory.
 */
public class FileChooser {

    /**
     * Prompts dialog to select target file.
     *
     * @return user selected file.
     * In case if none selected , return null
     */
    public static File promptChooseFile(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select CSV File");
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    /**
     * Prompts dialogue to let user select output
     * destination and file name. NOTE file must be
     * in html format. Any other extension will be
     * overwritten to .html.
     *
     * @return absolute path of output file as String.
     */
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
