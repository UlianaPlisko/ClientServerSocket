import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private static List<String> europeanCities;

    static{
        europeanCities = new ArrayList<>();
        europeanCities.add("London");
        europeanCities.add("Paris");
        europeanCities.add("Berlin");
        europeanCities.add("Madrid");
        europeanCities.add("Rome");
        europeanCities.add("Vienna");
        europeanCities.add("Amsterdam");
        europeanCities.add("Brussels");
        europeanCities.add("Lisbon");
        europeanCities.add("Prague");
        europeanCities.add("Budapest");
        europeanCities.add("Warsaw");
        europeanCities.add("Dublin");
        europeanCities.add("Athens");
        europeanCities.add("Copenhagen");
        europeanCities.add("Stockholm");
        europeanCities.add("Oslo");
        europeanCities.add("Zurich");
        europeanCities.add("Helsinki");
        europeanCities.add("Belgrade");
    }
    public static void main(String[] args) {
        int i = 0;
        for(String city : europeanCities){
            int index = ++i;
            new Thread(() ->{
                try(Phone phone = new Phone("127.0.0.1", 8000)){
                    System.out.printf("Client %d connected to server\n", index);
                    System.out.println(city);
                    phone.writeLine(city);
                    String response = phone.readLine();
                    System.out.println("Response to client " + index + ": " + response + " celsius");
                }catch(IOException e){
                    e.printStackTrace();
                }
            }).start();
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}