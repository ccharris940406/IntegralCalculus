package com.harris;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int [] a = {4, 4 , 3, 3, 4};

        Polynomial poli = new Polynomial( a, 4);

        System.out.println(poli);
        System.out.println(poli.RectangleMethodIntegral(1000000000, 2, 100));
        System.out.println(poli.TrapMethodIntegral(1000000000, 2, 100));
    }
}
