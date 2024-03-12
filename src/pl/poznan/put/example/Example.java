package pl.poznan.put.example;
import pl.poznan.put.matrix.Matrix;

public class Example {
    //example matrices that will be added to the memory
    final private double tab[][] = {
            {21.0, 37.0, 5.0},
            {4.0, 5.0, 8.0},
            {2.9, 4.7, 1.9},
    };
    final private Matrix example1 = new Matrix(3, 3, tab);
    private double tab2[][] = {
            {6.0, 9.7, 4.9},
            {3.6, 2.9, 1.0},
            {2.3, 4.5, 5.8},
    };
    private Matrix example2 = new Matrix(3, 3, tab2);

    public Matrix firstExampleMatrix() {
        return example1;
    }

    public Matrix secondExampleMatrix() {
        return example2;
    }
}
