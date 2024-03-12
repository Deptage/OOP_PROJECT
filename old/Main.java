import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("MatrixAlmostExpert - a program to perform various operations on matrices by Zuzanna Ławniczak, PUT student.");
        Menu userMemory=new Menu();
        //Import example matrices to the memory
        Example ex1=new Example();
        userMemory.insertAMatrix(ex1.firstExampleMatrix());
        userMemory.insertAMatrix(ex1.secondExampleMatrix());
        userMemory.showMenu();
    }
}
