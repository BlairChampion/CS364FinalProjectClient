import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Main {




    public static void main(String[] args) {

        Socket sock;
        BufferedReader from;
        PrintWriter to;
        Scanner kbd = new Scanner(System.in);

        System.out.println("Enter IP address: ");
        String ip = kbd.nextLine().trim();

        try {
            sock = new Socket(ip, 12345);
            System.out.println("Connected to " +
                    sock.getInetAddress());
            from = new BufferedReader(
                    new InputStreamReader(
                            sock.getInputStream()
                    )
            );
            to = new PrintWriter(sock.getOutputStream(),
                    true);

//            while (true) {
//                System.out.println("Waiting...");
//                String response = from.readLine();
//                System.out.println("them: " + response);
//                System.out.println("me: ");
//                String s = kbd.nextLine();
//                to.println(s);
//            }

            //Requesting a quote
            while (true) {
                System.out.println("Press <Enter> to request a quote");
                kbd.nextLine();
                System.out.println("Requesting quote");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
