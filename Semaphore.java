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

/**
 *
 * @author Elliot
 */
public class Semaphore {
    protected int value ;
    

  protected Semaphore() { value = 0 ; }

  protected Semaphore(int initial) { value = initial ; }

  
  
  
  public synchronized void P(Device d) throws IOException{
	File file = new File("file.txt");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        value-- ;
        if (value < 0){
             try {
                System.out.println(d.name+" "+d.type+"  arrivres and wait ");
                br.write(d.name+" "+d.type+"  arrivres and wait \n");
                br.close();
                fr.close();
                 wait();
             }
             catch(InterruptedException e) {
             
             }
        }
        else{
            System.out.println(d.name+" "+d.type+ "   arrives");
            br.write(d.name+" "+d.type+ "   arrives \n");
            br.close();
            fr.close();
        }

  }
  public synchronized void V() {
        value++ ;
        if (value <= 0) 
            notify() ;
  }

}