import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args){

        try(ServerSocket server = new ServerSocket(8000)){
            System.out.println("Server Started!");

            int index = 0;
            while(true){
                int i = ++index;
                Phone phone = new Phone(server);
                new Thread(() -> {
                    System.out.println("Client " + i + " connected");
                    String request = phone.readLine();
                    String response = (int)(Math.random() * 30 - 10) +"";
                    try{
                        Thread.sleep(3000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("Request received from client " + i + ": " + request);
                    phone.writeLine(response);
                }).start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}