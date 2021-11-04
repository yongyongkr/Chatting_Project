package Project_A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        Scanner sc = new Scanner(System.in);

        try {
            socket = new Socket("localhost", 12000);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while (true) {
                System.out.print("메시지를 입력하세요 : ");
                String outMsg = sc.nextLine();

                if (outMsg.contains("종료")) {
                    out.write("연결이 종료되었습니다");
                    out.flush();
                    System.out.println("연결이 종료되었습니다");
                    break;
                }

                out.write(outMsg + "\n");
                out.flush();

                String inMsg = in.readLine();
                System.out.println("상대방 : " + inMsg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                sc.close();
                out.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
