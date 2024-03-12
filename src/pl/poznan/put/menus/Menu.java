package pl.poznan.put.menus;
import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.Scanner;
import pl.poznan.put.interfaces.MenuFunctions;
import pl.poznan.put.matrix.Matrix;

public class Menu implements MenuFunctions {
    private ArrayList<Matrix> matrices = new ArrayList<>();
    private Scanner cin = new Scanner(System.in);
    private UI dialogue = new UI();

    @Override
    public void insertAMatrix(Matrix m1) {
        //instead of using these 3 lines everywhere, I optimized it and used a method
        matrices.add(m1);
        System.out.println("Your matrix has been added to the memory");
        matrices.get(matrices.size() - 1).show();
    }

    @Override
    public boolean ifMatricesEmpty() {
        //instead of having try...catch block in every method, I check it here
        boolean flag = true;
        try {
            if (matrices.isEmpty()) {
                throw new InaccessibleObjectException("There are no matrices stored in memory!");
            } else flag = false;
        } catch (Exception ex1) {
            System.out.println(ex1.getMessage());
        }
        return flag;
    }

    @Override
    public boolean indexOutOfRange(int id) {
        //instead of having try...catch block in every method, I check it here
        //checking if index of an object exists
        boolean flag = true;
        try {
            if (((matrices.size() - 1) < id) || id < 0) {
                throw new IllegalAccessException("Index is out of range!");
            } else flag = false;
        } catch (Exception ex1) {
            System.out.println(ex1.getMessage());
        }
        return flag;
    }

    @Override
    public void showMenu() {
        dialogue.printUI();
        int input = cin.nextInt();
        switch (input) {
            case 1 -> this.createAMatrixMenu();//creating a matrix
            case 2 -> this.deleteAMatrixMenu();//deleting a matrix from the memory
            case 3 -> this.displayMatrices();//printing matrices
            case 4 -> this.addMatrices();//adding two matrices
            case 5 -> this.subtractMatrices();//subtracting matrices
            case 6 -> this.multiplyMatrices();//multiplying matrices
            case 7 -> this.transposeAMatrix();//transposing a matrix
            case 8 -> this.multiplyByANumber();//multiplying matrix by a number
            case 9 -> System.exit(0);//exit
        }
        this.showMenu();
    }

    @Override
    public void createAMatrixMenu() {
        try {
            System.out.println("Input number of rows for the new matrix");
            int m = cin.nextInt();
            System.out.println("Input number of columns for the new matrix");
            int n = cin.nextInt();
            if (m <= 0 || n <= 0) {
                throw new IllegalArgumentException("Number of rows and columns of a matrix must be positive!");
            } else {
                double[][] tab2 = new double[m][n];
                System.out.println("Input values of the elements of the matrix. You should use your local notation (in Poland use a comma (,) ):");
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        tab2[i][j] = cin.nextDouble();
                    }
                }
                Matrix mat = new Matrix(m, n, tab2);
                insertAMatrix(mat);
            }
        } catch (IllegalArgumentException ex1) {
            System.out.println(ex1.getMessage());
            this.createAMatrixMenu();
        }
    }

    @Override
    public void displayMatrices() {
        if (!ifMatricesEmpty()) {
            for (int i = 0; i < matrices.size(); i++) {
                System.out.print(i);
                System.out.println(": ");
                matrices.get(i).show();
            }
        }
    }

    @Override
    public void deleteAMatrixMenu() {
        if (!ifMatricesEmpty()) {
            System.out.println("Input an index of a matrix you want to delete!:");
            int id = cin.nextInt();
            if (!indexOutOfRange(id)) {
                matrices.remove(id);
                System.out.println("Your matrix has been deleted.");
            }
        }
    }

    @Override
    public void addMatrices() {
        int id1, id2;
        System.out.println("Input the index of the matrix you want to add to:");
        id1 = cin.nextInt();
        System.out.println("Input the index of the matrix you want to add:");
        id2 = cin.nextInt();
        if (!indexOutOfRange(id1) && !indexOutOfRange(id2)) {
            if (matrices.get(id1).numberOfRows() != matrices.get(id2).numberOfRows()) {
                System.out.println("Impossible to add.");
            } else if (matrices.get(id1).numberOfColumns() != matrices.get(id2).numberOfColumns()) {
                System.out.println("Impossible to add.");
            } else {
                Matrix newMatrix = matrices.get(id1).addToThisMatrix(matrices.get(id2));
                insertAMatrix(newMatrix);
            }
        }
    }

    @Override
    public void subtractMatrices() {
        int id1, id2;
        System.out.println("Input the index of the matrix you want to subtract from:");
        id1 = cin.nextInt();
        System.out.println("Input the index of the matrix you want to subtract:");
        id2 = cin.nextInt();
        if (!indexOutOfRange(id1) && !indexOutOfRange(id2)) {
            if (matrices.get(id1).numberOfRows() != matrices.get(id2).numberOfRows()) {
                System.out.println("Impossible to subtract.");
            } else if (matrices.get(id1).numberOfColumns() != matrices.get(id2).numberOfColumns()) {
                System.out.println("Impossible to subtract.");
            } else {
                Matrix newMatrix = matrices.get(id1).subtractFromThisMatrix(matrices.get(id2));
                insertAMatrix(newMatrix);
            }
        }
    }

    @Override
    public void multiplyMatrices() {
        int id1, id2;
        boolean fl1 = ifMatricesEmpty();
        if (!fl1) {
            System.out.println("Input the index of the matrix you want to multiply");
            id1 = cin.nextInt();
            System.out.println("input the index of the matrix you want to multiply by");
            id2 = cin.nextInt();
            fl1 = indexOutOfRange(id1) || indexOutOfRange(id2);
            if (!fl1) {
                Matrix newMatrix = new Matrix(matrices.get(id1), matrices.get(id2));
                insertAMatrix(newMatrix);
            }
        }
    }

    @Override
    public void transposeAMatrix() {
        int id1;
        boolean fl1 = ifMatricesEmpty();
        if (!fl1) {
            System.out.println("Input the index of the matrix you want to transpose:");
            id1 = cin.nextInt();
            fl1 = indexOutOfRange(id1);
            if (!fl1) {
                Matrix newMatrix = new Matrix(matrices.get(id1));
                insertAMatrix(newMatrix);
            }
        }
    }

    @Override
    public void multiplyByANumber() {
        int id1;
        double number;
        boolean fl1 = ifMatricesEmpty();
        if (!fl1) {
            System.out.println("Input the index of the matrix you want to multiply:");
            id1 = cin.nextInt();
            fl1 = indexOutOfRange(id1);
            if (!fl1) {
                System.out.println("Input the number");
                number = cin.nextDouble();
                Matrix newMatrix = new Matrix(matrices.get(id1), number);
                insertAMatrix(newMatrix);
            }
        }
    }
}
