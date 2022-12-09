public class Matrix{
    private int numberOfRows, numberOfColumns;
    private Element[][] elements;
    Matrix(int m, int n)
    {
        this.numberOfRows=m;
        this.numberOfColumns=n;
        this.elements=new Element[numberOfRows][numberOfColumns];
    }
    Matrix(int m, int n, double[][] tab)
    {
        this.numberOfRows=m;
        this.numberOfColumns=n;
        this.elements=new Element[numberOfRows][numberOfColumns];
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                elements[i][j]=new Element(tab[i][j]);
            }
        }
    }
    void show()
    {
        for(int i = 0; i<numberOfRows; i++)
        {
            for(int j = 0; j<numberOfColumns; j++)
            {
                System.out.print(elements[i][j].pvalue());
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /*Matrix inputElements(int[][] tab, int m, int n)
    {
        Matrix newMatrix = new Matrix(m,n);
        Element temp = new Element();
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                temp.newValue(tab[i][j]);
                newMatrix
            }
        }
    }*/

}
