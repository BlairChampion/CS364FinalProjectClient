import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Main {

    private static int getFactor(Long a){
        for (int i = 2; i <= (Math.sqrt(a)); i++ ) {
            if (a%i == 0){
                return i;
            }
        }
        return 0;
    }


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

            //Requesting a quote
            while (true) {
                System.out.println("Press <Enter> to request a quote");
                kbd.nextLine();
                System.out.println("Requesting quote");
                String request = "Received a quote request from client";
                to.println(request);

                Long first = Long.parseLong(from.readLine());
                Long second = Long.parseLong(from.readLine());
                System.out.println("Finding factors of " + first + ", " + second);
                int firstFactor = getFactor(first);
                int secondFactor = getFactor(second);
                System.out.println("Found factors " + firstFactor + ", " + secondFactor);
                System.out.println("Sending factors to server");
                to.println(firstFactor);
                to.println(secondFactor);
                System.out.println("Recieved \"" + from.readLine() + "\" from server");
                System.out.println("Received quote: \"" + from.readLine() + "\"");



            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
