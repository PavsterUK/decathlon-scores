package com.decathlon.utils;

import javax.swing.*;
import java.io.File;


/**
 * Utility class to prompt user dialog
 * for selecting file.
 *
 * It also used to select output file name and directory.
 */
public class FileChooser {

    /**
     * Prompts dialog to select CSV file.
     *
     * @return [File] User selected file.
     *
     * Returns null if no file selected.
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
     * in .html extension. Any other extensions will be
     * overridden to .html.
     *
     * @return [String] Absolute path of output file.
     *
     * Returns null if no file selected.
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
