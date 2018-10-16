package com.gmail.byelenka;

public class MyFirstProgram {
	public static void main (String[] args) {
		hello("world");

		double lenght = 5;
        System.out.println("Площадь квадрата со стороной " + lenght + " равна " + area(lenght));

        double a = 2;
        double b = 3;
        System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " равна " + area(a, b));
	}

	public static void hello (String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }

	public static double area (double l) {
	    return l*l;
    }

    public static double area (double a, double b) {
	    return a*b;
    }
}