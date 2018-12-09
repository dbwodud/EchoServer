package com.company;

import java.net.*;
import java.io.*;

public class Main {

    public static final int PORT = 6013;

    public static void main(String[] args){

        ServerSocket server = null;
        Socket socket;
        try{
            server = new ServerSocket(PORT);
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }

        while(true) {
            try {
                socket = server.accept();
                EchoThread thread = new EchoThread(socket);
                Thread t = new Thread(thread);
                t.start();
            } catch (IOException ioe) {
                System.err.println(ioe);
            }
        }
    }
}