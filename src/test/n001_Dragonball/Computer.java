package test.n001_Dragonball;

public class Computer {

    String name;
    int hp;
    int energy;
    // 방어력, 컴퓨터가 선턴을 잡아서 공격을 방어 할 때 필요함
    int armor;

    Computer() {
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
        } else {
            System.out.printf("%s가 %s를 공격함\n", this.name, target.name);
            this.energy -= 1;
            target.hp -= 1;
        }
    }

    void powerAttack(Player target) {
        if (this.energy < 3) {
            System.out.printf("%s의 기가 부족함\n", this.name);
        } else {
            System.out.printf("%s가 %s에게 필살기를 씀\n", this.name, target.name);
            this.energy -= 3;
            target.hp -= 2;
        }
    }

    // 컴퓨터 행동 기준
    public void ai(Player target) {

        // 필살기, 에너지가 3일 때 작동
        if (this.energy == 3) {
            powerAttack(target); return;
        }

        // 기모으기, 둘 다 기력이 0일 때 작동
        if (this.energy == 0 && target.energy == 0) {
            this.energyUp(); return;
        }
        
        // 방어, 컴퓨터만 기력이 없을 때 작동
        if (this.energy == 0 && target.energy >= 1) {
            double d = Math.random();
            if (d >= 0.5) this.energyUp();
            else this.block(); return;
        }

        // 공격, 컴퓨터만 기력이 있을 때 작동
        if (this.energy >= 1 && target.energy == 0) {
            double d = Math.random();
            if (d >= 0.5) this.energyUp();
            else this.attack(target); return;
        }

        // 공격2, 둘 다 기력이 있을 때 작동
        if (this.energy >= 1 && target.energy >= 1) {
            double d = Math.random();
            if (d >= 0.67) this.energyUp();
            else if (d <= 0.34) {
                this.block();
            } else this.attack(target);
        }

    }

}
