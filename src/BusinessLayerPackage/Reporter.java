/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jozehan
 */
public class Reporter {

    String report;

    public Reporter(String report) {
        this.report = report;
    }

    public void saveReport(String path) {
        try {
            System.out.println(path + ".txt");
            FileWriter fw = new FileWriter(new File(path + ".txt"));
            //DataOutputStream dos = new DataOutputStream(fos);
            fw.write(this.report);
            //fw.flush();
            //dos.flush();
            System.out.println("Report saved");
            //dos.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Reporter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
