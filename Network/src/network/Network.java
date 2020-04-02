/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Elliot
 */
public class Network {

    
    public static Vector<Device> myDevices = new Vector<>();
    public static Scanner sc = new Scanner(System.in);
       
    public static void main(String[] args) throws InterruptedException {
       
       
       System.out.println("What is the number of WI-FI Connections");
       int y = sc.nextInt();
       Router r = new Router(y);
       System.out.println("What is number of devices Clients want to connect? ");
       int x = sc.nextInt();
      
       for(int i = 0; i < x; i++)
       {
           String name,type;
           name = sc.next();
           type = sc.next();
           
           Device D = new Device(name , type,r);
           
           
           myDevices.add(D);
       }
       Device.semaphore = new Semaphore(y);

       for(int i = 0; i < x; i++)
       {
           myDevices.get(i).start();
       }

    }
    
}
