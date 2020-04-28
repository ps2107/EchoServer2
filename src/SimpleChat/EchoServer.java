package SimpleChat;
import java.net.*;
import java.io.*;

public class EchoServer {

    private int port;
    public EchoServer(int port){
        this.port = port;
    }
    public void run(){
        //server code goes here...
        //a ServerSocket object is created and given a port to listen on. This is the key component of the server

        try(ServerSocket ss = new ServerSocket(port)){
            //listen for a client, method blocks
            Socket client = ss.accept();
            //create stream objects to send data
            PrintWriter sendTo = new PrintWriter(
                    client.getOutputStream());
            BufferedReader readFrom = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            // accept a message, also blocks
            String inputLine = "echo:" + readFrom.readLine();
            while(inputLine != null){
                //send the message line
                sendTo.println(inputLine);
                sendTo.flush();
                inputLine = "echo:" + readFrom.readLine();
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EchoServer server = new EchoServer(7777);
        server.run();

    }

}