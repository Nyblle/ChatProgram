package odie.chatprograms;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Odie
 */
public class ChatClient implements Runnable{
    
    
    private static Socket ClientSocket = null;
    private static PrintStream OutputStream = null;
    private static DataInputStream InputStream = null;
    private static BufferedReader InputLine = null;
    private static boolean Closed = false;
    
    
    public static void main(String[] args) throws IOException {
        
        
        int PortNumber = 8081;
        String Host = "localhost";
  
////////////////////       
// ???   
////////////////////        
        if(args.length < 2){
            System.out.println("Usage: ChatClient <host> <portNumber>\n"
              + "Now using host=" + Host + ", portNumber=" + PortNumber);
        } else{
            Host = args[0];
            PortNumber = Integer.valueOf(args[1]).intValue();
        }
////////////////////       
// ???   
////////////////////  

////////////////////       
// Opens Socket with port and host. Opens Input and outputstreams.   
//////////////////// 
        try{
            ClientSocket = new Socket(Host, PortNumber);
            InputLine =  new BufferedReader(new InputStreamReader(System.in));
            OutputStream = new PrintStream(ClientSocket.getOutputStream());
            InputStream = new DataInputStream(ClientSocket.getInputStream());
            
        } catch(IOException e) {
            System.err.println("Could not connect to the host "
          + Host);
        }
        
////////////////////       
// Create a thread to read from the server.
//////////////////// 

        if (ClientSocket != null && OutputStream != null && InputStream != null) {
            try {
                
                new Thread( new ChatClient()).start();
                
                while(!Closed) {
                    OutputStream.println(InputLine.readLine().trim());
                }
            /*
            * Close the output stream, close the input stream, close the socket.
            */
            OutputStream.close();
            InputStream.close();
            ClientSocket.close();
            } catch(IOException e){
                System.err.println("IOException:  " + e);
            }
        }
    }
    
    @Override
    public void run() {
        String ResponseLine;
            try {
                while ((ResponseLine = InputStream.readLine()) != null) {
                System.out.println(ResponseLine);
                if (ResponseLine.indexOf("Bye") != -1)
                break;
                }
            Closed = true;
            } catch (IOException e) {
            System.err.println("IOException:  " + e);
        }
        
    }
    
    
}
