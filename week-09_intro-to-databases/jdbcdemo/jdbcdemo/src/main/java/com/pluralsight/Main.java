package com.pluralsight;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {
        // the situation without try with resources, regular try catch
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(" path");
            fileReader.close();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null) {
                try {
                    fileReader.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // with try with resources
        // automatically closes resources that are autocloseable
        try(FileReader fr = new FileReader(" path")) {
            // use the file reader
        } // closes whatever is opened, automatically
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
