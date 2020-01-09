/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Elliot
 */
public class Device extends Thread {
    String name =" ";
    String type;
    Router r;
    static Semaphore semaphore;
     
    public Device(String name, String type , Router r) {
        this.name = name;
        this.type = type;
        this.r = r;
    }
    void connect() throws IOException{
        r.produce(this);
        
        File file = new File("file.txt");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        try {
            System.out.println(this.name+" "+this.type+" Occupied" );
            br.write(this.name+" "+this.type+" Occupied\n");
            br.close();
            fr.close();
           Thread.sleep((long) (Math.random() * 4000 + 1)); 
         
        } catch (InterruptedException ex) {
            Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void navigate() throws IOException{
        File file = new File("file.txt");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        try {
            System.out.println(this.name+" "+this.type+" performs online activity" );
            br.write(this.name+" "+this.type+" performs online activity\n");
            br.close();
            fr.close();
           Thread.sleep((long) (Math.random() * 4000 + 1)); 
         
        } catch (InterruptedException ex) {
            Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void logout() throws IOException{
        r.consume(this);
        File file = new File("file.txt");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        System.out.println(this.name+" "+this.type+" Logged out");
        br.write(this.name+" "+this.type+" Logged out\n");
        br.close();
        fr.close();
        

    }
    
    @Override
    public void run() {
        
        try {
            semaphore.P(this);
        } catch (IOException ex) {
            Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            connect();
        } catch (IOException ex) {
            Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            navigate();
        } catch (IOException ex) {
            Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            logout();
        } catch (IOException ex) {
            Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
        }
        semaphore.V();
        
        
    }
    
}
