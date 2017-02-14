package odie.chatprograms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Odie
 */
public class ChatServer {
    
    private static Socket ServerSocket = null;
    private static Socket ClientSocket = null;
    
    private static  final int MaxClientsCount = 10;
  //  private static final ClientThreads[] threads = new  ClientThread[MaxClientsCount];
    
    public static void main(String[] args) throws IOException {
        
    }
}
