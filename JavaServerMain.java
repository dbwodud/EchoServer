package com.company;

import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        ServerSocket server = null;
        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        try{
            server = new ServerSocket(6013);
            socket = server.accept();

            in = socket.getInputStream();
            out = socket.getOutputStream();

            reader = new BufferedReader(new InputStreamReader(in));
            writer = new PrintWriter(new OutputStreamWriter(out));

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
