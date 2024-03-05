package test.n001_Dragonball;

import java.util.Scanner;

import static util.Utility.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Player player = new Player();
        player.name = "춘식이";
        Computer computer = new Computer();
        computer.name = "대식이";


        while (true) {

            // 턴 진행, 내 행동 선택하기
            System.out.println("행동할 숫자를 입력하세요. (1 ~ 4)\n1. 기모으기 (1 sp 획득) || 2. 방어 (공격 방어) || 3. 공격 (1 sp 소모) || 4. 필살기 (3 sp 소모, 방어 무시)");
            int playerChoice = sc.nextInt();

            // 컴퓨터가 미리 행동, 플레이어가 선으로 행동하면 ai에 오류가 생김
            computer.ai(player);

            // 플레이어 행동
            switch (playerChoice) {
                case 1:
                    player.energyUp();
                    break;
                case 2:
                    player.block();
                    break;
                case 3:
                    player.attack(computer);
                    break;
                case 4:
                    player.powerAttack(computer);
                    break;
                default:
                    System.out.println("헛짓거리를 해서 턴이 날아갔습니다.");
                    break;
            }


            // 둘 다 공격을 날릴 시 체력 복구
            if (player.hp == 0 && computer.hp == 0) {
                player.hp += 1;
                computer.hp += 1;
            }

            // 둘 다 필살기를 날릴 시 체력 복구
            if (player.hp == -1 && computer.hp == -1) {
                player.hp += 2;
                computer.hp += 2;
            }

            // 컴퓨터의 올라간 방어력 복구
            if (computer.armor >= 1) computer.armor = 0;


            // 끝나는 조건 (필살기 vs 공격)
            if (player.hp == -1 && computer.hp == 0) {
                makeLine(); System.out.printf("%s의 승리!", computer.name); break;
            }
            if (player.hp == 0 && computer.hp == -1) {
                makeLine(); System.out.printf("%s의 승리!", player.name); break;
            }

            // 끝나는 조건 (기본)
            if (player.hp <= 0) {
                makeLine(); System.out.printf("%s의 승리!", computer.name); break;
            }
            if (computer.hp <= 0) {
                makeLine(); System.out.printf("%s의 승리!", player.name); break;
            }

            makeLine();

            // 현재 기력 보여줌
            System.out.printf("%s의 기력 : %d || %s의 기력 : %d\n"
                    , player.name, player.energy, computer.name, computer.energy);

            makeLine();



        }


    }

}
