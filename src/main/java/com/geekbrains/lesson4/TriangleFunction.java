package com.geekbrains.lesson4;

public class TriangleFunction {
    public static Double AreaOfATriangle (int a, int b, int c) throws TriangleDoesNotExistException {
        if (a <= 0| b <= 0| c <= 0) throw new IllegalArgumentException("Одна из сторон <= 0!");
        if ((a + b) < c| (b + c) < a| (a + c) < b) throw new TriangleDoesNotExistException();
        double p1 = (a + b + c) / 2;
        double s = Math.sqrt(p1 * (p1 - a) * (p1 - b) * (p1 - c));
        return s;
    }
}
