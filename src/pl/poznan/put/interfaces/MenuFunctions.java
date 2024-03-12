package pl.poznan.put.interfaces;
import pl.poznan.put.matrix.Matrix;

public interface MenuFunctions {
    void insertAMatrix(Matrix m1);

    boolean ifMatricesEmpty();

    boolean indexOutOfRange(int id);//checking if index of an object exists

    void showMenu();

    void createAMatrixMenu();

    void displayMatrices();

    void deleteAMatrixMenu();

    void addMatrices();

    void subtractMatrices();

    void multiplyMatrices();

    void transposeAMatrix();

    void multiplyByANumber();

}
