import pl.poznan.put.example.Example;
import pl.poznan.put.menus.Menu;

public class Main {
    public static void main(String[] args) {
        System.out.println("MatrixAlmostExpert - a program to perform various operations on matrices by Zuzanna Ławniczak, PUT student.");
        Menu userMemory = new Menu();
        //Import example matrices to the memory
        Example ex1 = new Example();
        userMemory.insertAMatrix(ex1.firstExampleMatrix());
        userMemory.insertAMatrix(ex1.secondExampleMatrix());
        userMemory.showMenu();
    }
}
