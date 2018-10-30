/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jozehan
 */
public class BCSerializer<T> {

    T t;

    public BCSerializer(T t) {
        this.t = t;
    }

    public void Serialize(String file) {
        try {
            FileOutputStream fos = new FileOutputStream(file+".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.t);
            System.out.println("Object serialized!!!!!");
            oos.flush();
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BCSerializer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BCSerializer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public T DeSerialize(String file) {
        T innerT=null;
        try {
            FileInputStream fis = new FileInputStream(file+".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            innerT=(T) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BCSerializer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BCSerializer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BCSerializer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return innerT;
    }
}
