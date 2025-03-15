/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab1_bai2;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Minhh
 */

public class Lab1_Bai2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double result2 = approximatePi(100000000);
        System.out.println("__Cau 2__ ");
        System.out.printf("Voi %d diem: Pi gan bang %.8f, sai so: %.8f%n", 100000000, result2, Math.abs(result2 - Math.PI));
    }
    public static double approximatePi(int numPoints) {
        Random random = new Random();
        int pointsInsideCircle = 0;
        int pointsTotal = 0;
        
        for (int i = 0; i < numPoints; i++) {
            // Tạo điểm ngẫu nhiên trong hình vuông [-1,1] x [-1,1]
            double x = random.nextDouble() * 2 - 1;
            double y = random.nextDouble() * 2 - 1;
            
            // Kiểm tra xem điểm có nằm trong đường tròn không
            if (x*x + y*y <= 1) {
                pointsInsideCircle++;
            }
            pointsTotal++;
        }
        
        // π ≈ (2n)^2 * (số điểm trong đường tròn / tổng số điểm)
        return 4 * ((double) pointsInsideCircle / pointsTotal);
    }
}
