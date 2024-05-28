package com.jtechnology.test;


public class Main {
    public static void main(String[] args) {

        MySingleton singleton = MySingleton.getInstance();

        System.out.println(singleton.GetAString());
    }
}