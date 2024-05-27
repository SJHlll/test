package test.n003_material_exchange;

import java.util.Scanner;

public class MaterialExchange {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 재료 A, B, C의 개수를 입력
        System.out.print("A의 개수: ");
        double A = scanner.nextDouble();

        System.out.print("B의 개수: ");
        double B = scanner.nextDouble();

        System.out.print("C의 개수: ");
        double C = scanner.nextDouble();

        // 재료 A, B, C의 교환비 X, Y, Z를 입력
        System.out.print("교환비 X: ");
        int X = scanner.nextInt();

        System.out.print("교환비 Y: ");
        int Y = scanner.nextInt();

        System.out.print("교환비 Z: ");
        int Z = scanner.nextInt();

        // 한 개의 제품 제작에 필요한 a, b, c 비율을 입력
        System.out.print("비율 a: ");
        int a = scanner.nextInt();

        System.out.print("비율 b: ");
        int b = scanner.nextInt();

        System.out.print("비율 c: ");
        int c = scanner.nextInt();

        // 재료 A, B를 전부 C로 교환하기
        // 교환비 X:Z가 2:1이고 A가 10개면, 10*1/2 -> C는 5개로 교환됨
        double AC = A * Z / X;
        double BC = B * Z / Y;

        double CC = AC + BC + C; // A:0, B:0, C로 전부 교환됨
        
        // 특정 제품의 제작에 필요한 a:b:c의 비율 계산
        double XC = (double) X / Z; // C 1개로 A XC개
        double YC = (double) Y / Z; // C 1개로 B YC개

        double aXC = a / XC; // x에 필요한 C의 개수
        double bYC = b / YC; // y에 필요한 C의 개수
        
        double tC = aXC + bYC + c; // 제품 1개를 만들 때 필요한 C의 개수

        double totalItem = CC / tC; // 총 만들 수 있는 제품의 개수

        double totalA = totalItem * a; // 총 필요한 재료 A의 개수
        double totalB = totalItem * b; // 총 필요한 재료 B의 개수
        double totalC = totalItem * c; // 총 필요한 재료 C의 개수

        double insertA = totalA / X;
        double insertB = totalB / Y;



        System.out.print("=======================================\n만들 수 있는 제품의 개수 = ");
        System.out.printf("%.2f", totalItem);
        System.out.println("개\n=======================================");
        System.out.print("투입한 재료 A의 개수 = ");
        System.out.printf("%.2f", totalA);
        System.out.print("개\n");
        System.out.print("투입한 재료 B의 개수 = ");
        System.out.printf("%.2f", totalB);
        System.out.print("개\n");
        System.out.print("투입한 재료 C의 개수 = ");
        System.out.printf("%.2f", totalC);
        System.out.println("개\n=======================================");
        System.out.print("A로 교환할 C의 개수 = ");
        System.out.printf("%.2f", insertA);
        System.out.print("개\n");
        System.out.print("B로 교환할 C의 개수 = ");
        System.out.printf("%.2f", insertB);
        System.out.print("개\n");
        System.out.print("C의 개수 = ");
        System.out.printf("%.2f", totalC);
        System.out.println("개\n=======================================");





        scanner.close();

    }

}
