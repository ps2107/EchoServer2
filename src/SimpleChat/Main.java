package SimpleChat;
import java.net.*;
import java.io.*;

public class Main {
    public final int PORTNUM = 7777;
        public void main(String[] args) {
            // write your code here
            EchoServer server = new EchoServer(PORTNUM);
            server.run();

        }
    }

