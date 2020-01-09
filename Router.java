/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.util.Vector;

/**
 *
 * @author Elliot
 */
public class Router{
    
    public int maxNumberOfConnection;
    
    Vector<Device> connected = new Vector();
    

    public Router(int size) {
        maxNumberOfConnection = size;
    }
    public synchronized void produce(Device d){
        
        if(connected.size()<maxNumberOfConnection)
            connected.add(d);
    }
        
        
        
    
    public synchronized void consume(Device d){
       for(int i = 0 ; i < connected.size() ; i++){
           if(d == connected.elementAt(i))
           {
               connected.remove(i);
               break;
           }
       }
       
}
    
    
}
