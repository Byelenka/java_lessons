package com.gmail.byelenka;

public class HomeworkPoint {
    public static void main (String[] args) {

        Point p1 = new Point(6,8);
        Point p2 = new Point(7,4);

        System.out.println("Расстояние между точками p1 (" + p1.x + ", " + p1.y + ") и p2 (" + p2.x + ", " + p2.y + ") равно " + p1.distance(p2));
    }

}
