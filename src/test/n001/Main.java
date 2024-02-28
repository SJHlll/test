package test.n001;

import java.util.Scanner;

import static util.Utility.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Player player = new Player();
        player.name = "Player";
        Player com = new Player();
        com.name = "Computer";


        while (true) {
            if (player.hp == 0) {
                System.out.println("패배");
                break;
            }
            if (com.hp == 0) {
                System.out.println("승리");
                break;
            }
            input("ㅎㅇㅎㅇ > ");



        }

            makeLine();

    }

}
