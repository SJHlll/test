package test.n001_Dragonball;

public class Player {

    String name;
    int hp;
    int energy;

    Player() {
        this.hp = 1;
        this.energy = 0;
    }

    void energyUp() {
        System.out.printf("%s가 기를 모음\n", this.name);
        this.energy += 1;
    }

    void block() {
        System.out.printf("%s가 방어함\n", this.name);
        // 컴퓨터가 선턴을 잡아서 방어력이 쓸모가 없음. hp 회복으로 대체
        if (this.hp == 0) this.hp += 1;
    }

    void attack(Computer target) {
        if (this.energy < 1) {
            System.out.printf("%s의 기가 부족함\n", this.name);
        } else {
            System.out.printf("%s가 %s를 공격함\n", this.name, target.name);
            this.energy -= 1;
            // 역시 컴퓨터가 선턴을 잡아서 방어력 기준으로 계산함
            target.hp -= (1 - target.armor);
        }
    }

    void powerAttack(Computer target) {
        if (this.energy < 3) {
            System.out.printf("%s의 기가 부족함\n", this.name);
        } else {
            System.out.printf("%s가 %s에게 필살기를 씀\n", this.name, target.name);
            this.energy -= 3;
            target.hp -= 2;
        }
    }
}
