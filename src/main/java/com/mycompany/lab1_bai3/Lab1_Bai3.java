/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab1_bai3;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author Minhh
 */

public class Lab1_Bai3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("__Cau 3__ ");
        System.out.println("Nhap vao so luong tram: ");
        int sl = sc.nextInt();
        Point[] points = new Point[sl];
        for(int i = 0; i < sl; i++){
            System.out.println("Nhap vao toa do tram "+ (i+1) +": ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }   
        CH(points, sl);
    }
    
    static Point p0;
    
    static Point nextTop(Stack<Point> nt){
        Point p = nt.pop();
        Point res = nt.peek();
        nt.push(p);
        return res;
    }
    
    static void Swap(Point[] points, int i, int j){
        Point temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
    
    static int SofD(Point p1, Point p2){
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }
    
    static int Orient(Point p,  Point q, Point r){
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if(val == 0) return 0;
        return (val > 0) ? 1 : 2;
    }
    
    static int Compare(Point p1, Point p2){
        int o = Orient(p0, p1, p2);
        if(o == 0){
            return (SofD(p0, p2) >= SofD(p0, p1)) ? -1 : 1;
        }
        return (o == 2) ? -1 : 1;
    }
    
    static void CH(Point[] points, int n){
        int min = 0;
        for(int i = 1; i < n; i++){
            if(points[i].y < points[min].y || (points[i].y == points[min].y && points[i].x < points[min].x)){
                min = i;
            }
        }
        Swap(points, 0, min);
        p0 = points[0];
        Arrays.sort(points, 1, n, Lab1_Bai3::Compare);
        int m = 1;
        for(int i = 1; i < n; i++){
            while(i < n - 1 && Orient(p0, points[i], points[i + 1]) == 0){
                i++;
            }
            points[m] = points[i];
            m++;
        }
        if(m < 3) return;
        Stack<Point> nt = new Stack<>();
        nt.push(points[0]);
        nt.push(points[1]);
        nt.push(points[2]);
        for(int i = 3; i < m; i++){
            while(nt.size() > 1 && Orient(nextTop(nt), nt.peek(), points[i]) != 2){
                nt.pop();
            }
            nt.push(points[i]);
        }
        while(!nt.isEmpty()){
            Point p = nt.pop();
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
    }
}

class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}