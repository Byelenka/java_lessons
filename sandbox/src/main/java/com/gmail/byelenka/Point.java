package com.gmail.byelenka;

public class Point {
    public double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p) {

        double d = Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));

        return d;
    }
}
