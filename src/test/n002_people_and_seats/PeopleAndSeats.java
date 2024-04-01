package test.n002_people_and_seats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/*
    1. 사람은 100명이 있으며 좌석은 100개의 좌석이 있다. (n번 사람, n번 좌석으로 함)
    2. 기본적으로 n번 사람은 n번 좌석에 순차적으로 앉는다.
    3. 예외적으로 1번 사람은 1번 좌석에 앉지 않고 그 외의 99개 좌석 중 한 자리에 앉는다.
    4. 1번 사람으로 인해 특정 사람이 자기 좌석에 앉지 못하면 빈 좌석 중 한 좌석을 무작위로 앉는다.
    5. 이를 100번 사람까지 반복한다.
    6. 100번 사람은 1번, 100번 좌석에 각각 50% 확률로 앉게 된다.
*/
class PeopleAndSeats {
    private static final int NUM_PEOPLE = 100;
    private static final int NUM_SEATS = 100;

    public static void main(String[] args) {
        List<Integer> seats = new ArrayList<>();
        for (int i = 1; i <= NUM_SEATS; i++) {
            seats.add(i);
        }

        Collections.shuffle(seats); // 1번 사람을 위해 좌석을 섞음

        int firstPersonSeat = seats.remove(0); // 1번 사람의 좌석

        System.out.println("1번 사람이 앉은 자리: " + firstPersonSeat);

        for (int i = 2; i <= NUM_PEOPLE; i++) {
            int nextSeat;
            if (seats.contains(i)) {
                nextSeat = i; // n번 사람이 n번 자리에 앉음
                seats.remove(Integer.valueOf(i));
            } else {
                nextSeat = getRandomEmptySeat(seats); // 빈 자리 중 하나에 앉음
            }
            System.out.println(i + "번 사람이 앉은 자리: " + nextSeat);
        }
    }

    private static int getRandomEmptySeat(List<Integer> seats) {
        Random random = new Random();
        int index = random.nextInt(seats.size());
        int seat = seats.get(index);
        seats.remove(index);
        return seat;
    }
}
