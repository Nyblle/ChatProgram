/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odie.chatprograms;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Odie
 */
class ClientThread extends Thread {
    
        private String ClientName = null;
        private DataInputStream InputStream = null;
        private PrintStream OutputStream = null;
        private Socket ClientSocket = null;
        private final ClientThread[] threads;
        private int MaxClientsCount;
        
        public ClientThread(Socket ClientSocket, ClientThread[] threads){
            this.ClientSocket = ClientSocket;
            this.threads = threads;
            MaxClientsCount =  threads.length;
        }
        
        public void run(){
            
            int MaxClientsCount = this.MaxClientsCount;
            ClientThread[] threads = this.threads;
            
            try{
/*
* Create input and output streams for this client.
*/
                
                InputStream = new DataInputStream(ClientSocket.getInputStream());
                OutputStream = new PrintStream(ClientSocket.getOutputStream());
                String Name;
                while(true){
                    OutputStream.println("Enter your name");
                    Name = InputStream.readLine().trim();
                    if (name.indexOf('@') == -1) {
                      break;
                    } else {
                        OutputStream.println("The name should not contain '@' character.");
                    }
                }
                
            }catch(IOException e){
                
            }
        }
        
       
    }
