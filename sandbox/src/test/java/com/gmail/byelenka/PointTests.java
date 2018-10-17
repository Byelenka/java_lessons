package com.gmail.byelenka;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistance() {
        Point p1 = new Point(1,2);
        Point p2 = new Point(1,3);
        Assert.assertEquals(p1.distance(p2), 1.0);
        Point p3 = new Point(1,2);
        Point p4 = new Point(2,2);
        Assert.assertEquals(p3.distance(p4), 1.0);
        Point p5 = new Point(9,6);
        Point p6 = new Point(6,10);
        Assert.assertEquals(p5.distance(p6), 5.0);
    }
}
