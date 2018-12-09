package com.company;

import java.io.*;
import java.net.*;

public class EchoThread implements Runnable{
    Socket socket;

    InputStream in = null;
    OutputStream out = null;

    BufferedReader reader = null;
    PrintWriter writer = null;

    public EchoThread(Socket s) {
        socket = s;
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();

            reader = new BufferedReader(new InputStreamReader(in));
            writer = new PrintWriter(new OutputStreamWriter(out));


        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
    public void run(){
        try{
            String msg = null;
            while((msg = reader.readLine())!=null){
                writer.println(msg);
                writer.flush();
        }
        }catch(IOException ioe){
            System.err.println(ioe);
        }
    }
}

