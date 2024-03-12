package pl.poznan.put.interfaces;
import pl.poznan.put.matrix.Matrix;
public interface Operations {
    //this interface is implemented by the Matrix class
    //addition, subtraction are methods
    //multiplication, transposition are handled by constructors in Matrix class
    void show();

    Operations addToThisMatrix(Matrix m1);

    Operations subtractFromThisMatrix(Matrix m2);
}
