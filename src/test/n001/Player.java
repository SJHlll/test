package test.n001;

public class Player {

    String name;
    int hp;
    int energy;
    int armor;

    Player() {
        this.hp = 1;
        this.energy = 0;
        this.armor = 0;
    }



    void energyUp() {
        System.out.printf("%s가 기를 모음\n", this.name);
        this.energy += 1;
    }

    void block() {
        System.out.printf("%s가 방어함\n", this.name);
        this.armor += 1;
    }

    void attack(Player target) {
        if (this.energy < 1) {
            System.out.printf("%s의 기가 부족함\n", this.name);
            return;
        } else {
            System.out.printf("%s가 %s를 공격함\n", this.name, target.name);
            this.energy -= 1;
            target.hp -= 1 - armor;
        }
    }

    void powerAttack(Player target) {
        if (this.energy < 3) {
            System.out.printf("%s의 기가 부족함\n", this.name);
            return;
        } else {
            System.out.printf("%s가 %s를 공격함\n", this.name, target.name);
            this.energy -= 3;
            target.hp -= 1;
        }
    }

}
