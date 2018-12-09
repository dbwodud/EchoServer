package com.company;

import java.net.*;
import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class Main {

    public static final int PORT = 6013;
    public static final String HOST = "127.0.0.1";

    public static void main(String[] args) {
        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        BufferedReader stdin = null;
        try{
            socket = new Socket(HOST,PORT);

            in = socket.getInputStream();
            out = socket.getOutputStream();

            reader = new BufferedReader(new InputStreamReader(in));
            writer = new PrintWriter(new OutputStreamWriter(out));

            stdin = new BufferedReader(new InputStreamReader(System.in));

            String msg = null;
            String echo = null;

            while((msg = stdin.readLine())!=null){
                writer.println(msg);
                writer.flush();
                echo = reader.readLine();
                System.out.println(echo);
            }
        }catch(IOException ioe){
            System.err.println(ioe);
        }
    }
}
