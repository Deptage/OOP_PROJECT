import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList<Matrix> matrices=new ArrayList<>();//moze gdzies przeniesc
    public void Menu()
    {
        System.out.println("===========================================================");
        System.out.println("                           MENU                            ");
        System.out.println("1. Create a new matrix");
        System.out.println("2. Delete a matrix from memory");
        System.out.println("3. Print all stored matrices");
        System.out.println("Your choice (input an integer):");
        Scanner cin=new Scanner(System.in);
        int input=cin.nextInt();
        switch(input)
        {
            case 1:
                this.createAMatrixMenu();
                break;
            //case 2:
            //    this.deleteAMatrixMenu();
            //    break;
            case 3:
                this.displayMatrices();
                break;
        }
    }
    public void createAMatrixMenu()
    {
        try{
            Scanner cin=new Scanner(System.in);
            System.out.println("Input number of rows for the new matrix");
            int m=cin.nextInt();
            System.out.println("Input number of columns for the new matrix");
            int n=cin.nextInt();
            if(m<=0||n<=0)
            {
                throw new IllegalArgumentException("Number of rows and columns of a matrix must be positive!");
            }
            else
            {
                double[][] tab2= new double[m][n];
                double val;
                System.out.println("Input values of the elements of the matrix. You should use your local notation (in Poland use a comma (,) ):");
                for(int i=0; i<m; i++)
                {
                    for(int j=0; j<n; j++)
                    {
                        //val= cin.nextDouble();
                        //System.out.println(val);
                        tab2[i][j]=cin.nextDouble();
                        //tab2[i][j]=val;
                    }
                }
                Matrix mat=new Matrix(m,n,tab2);
                matrices.add(mat);
                System.out.println("Your matrix:");
                matrices.get(0).show();
            }
        }
        catch(IllegalArgumentException ex1)
        {
            System.out.println(ex1.getMessage());//a getter, but I can't do anything about it ;(
            this.createAMatrixMenu();
        }
    }
    /*public void deleteAMatrixMenu()
    {
        try{
            Scanner cin=new Scanner(System.in);
            System.out.println("Which matrix do you want to delete?");
        }
        catch()
        {

        }
    }*/
    public void displayMatrices()
    {
        try{
            if(matrices.isEmpty())
            {
                throw new InaccessibleObjectException("There are no matrices stored in memory!");
            }
            else
            {
                   for(int i = 0; i<matrices.size();i++)
                   {
                       System.out.print(i);
                       System.out.println(": ");
                       matrices.get(i).show();
                   }
            }
        }
        catch(Exception ex2)
        {
            System.out.println(ex2.getMessage());
        }
    }
}
