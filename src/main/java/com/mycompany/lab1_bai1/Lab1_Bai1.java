/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab1_bai1;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Minhh
 */
public class Lab1_Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("__Cau 1__ ");
        System.out.println("Nhap vao ban kinh: ");
        int r = sc.nextInt();
        double result = approximatePi(100000000);
        System.out.println("Dien tich hinh tron la: ");
        System.out.println(r * r * result);
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
