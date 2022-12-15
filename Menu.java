import java.lang.reflect.Executable;
import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<Matrix> matrices=new ArrayList<>();//moze gdzies przeniesc
    private Scanner cin=new Scanner(System.in);
    private UI dialogue = new UI();
    public void Menu()
    {
        dialogue.printUI();
        Scanner cin=new Scanner(System.in);
        int input=cin.nextInt();
        switch(input)
        {
            case 1:
                this.createAMatrixMenu();
                break;
            case 2:
                this.deleteAMatrixMenu();
                break;
            case 3:
                this.displayMatrices();
                break;
            case 4:
                this.addMatrices();
                break;
            case 5:
                this.subtractMatrices();
                break;
            case 9:
                System.exit(0);
                break;
        }
        this.Menu();
    }
    public void createAMatrixMenu()
    {
        try{
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
                        tab2[i][j]=cin.nextDouble();
                    }
                }
                Matrix mat=new Matrix(m,n,tab2);
                matrices.add(mat);
                System.out.println("Your matrix has been added to the memory");
                //matrices.get(0).show();
            }
        }
        catch(IllegalArgumentException ex1)
        {
            System.out.println(ex1.getMessage());//a getter, but I can't do anything about it ;(
            this.createAMatrixMenu();
        }
        //this.Menu();
    }
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
        //this.Menu();
    }
    public void deleteAMatrixMenu()
    {
        try{
            if(matrices.isEmpty()) {
                throw new InaccessibleObjectException("There are no matrices stored in memory!");
            }
            else
            {
                System.out.println("Input an index of a matrix you want to delete!:");
                int id=cin.nextInt();
                try{
                    if(id>matrices.size()||id<0) throw new IllegalArgumentException("Wrong index!");
                    else
                    {
                        matrices.remove(id);
                        System.out.println("Your matrix has been deleted.");
                    }
                }
                catch(Exception ex1)
                {
                    System.out.println(ex1.getMessage());
                }
            }
        }
        catch(Exception ex1)
        {
            System.out.println(ex1.getMessage());
        }
        //this.Menu();
    }
    public void addMatrices()
    {
        int id1,id2;
        System.out.println("Input the index of the matrix you want to add to:");
        id1=cin.nextInt();
        System.out.println("Input the index of the matrix you want to add:");
        id2=cin.nextInt();
        try{
            if(id1>matrices.size()||id1<0||id2>matrices.size()||id2<0) throw new IllegalArgumentException("Wrong index!");
            else
            {
                if(matrices.get(id1).numberOfRows()!=matrices.get(id2).numberOfRows())
                {
                    System.out.println("Impossible to add.");
                }
                else if(matrices.get(id1).numberOfColumns()!=matrices.get(id2).numberOfColumns())
                {
                    System.out.println("Impossible to add.");
                }
                else {
                    Matrix newMatrix=matrices.get(id1).addToThisMatrix(matrices.get(id2));
                    matrices.add(newMatrix);
                    newMatrix.show();
                }
            }
        }
        catch(Exception ex1)
        {
            System.out.println(ex1.getMessage());
        }
    }
    public void subtractMatrices()
    {
        int id1,id2;
        System.out.println("Input the index of the matrix you want to subtract from:");
        id1=cin.nextInt();
        System.out.println("Input the index of the matrix you want to subtract:");
        id2=cin.nextInt();
        try{
            if(id1>matrices.size()||id1<0||id2>matrices.size()||id2<0) throw new IllegalArgumentException("Wrong index!");
            else
            {
                if(matrices.get(id1).numberOfRows()!=matrices.get(id2).numberOfRows())
                {
                    System.out.println("Impossible to subtract.");
                }
                else if(matrices.get(id1).numberOfColumns()!=matrices.get(id2).numberOfColumns())
                {
                    System.out.println("Impossible to subtract.");
                }
                else {
                    Matrix newMatrix=matrices.get(id1).subtractFromThisMatrix(matrices.get(id2));
                    matrices.add(newMatrix);
                    newMatrix.show();
                }
            }
        }
        catch(Exception ex1)
        {
            System.out.println(ex1.getMessage());
        }
    }
}
