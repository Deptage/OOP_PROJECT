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
    public int numberOfRows()
    {
        return numberOfRows;
    }
    public int numberOfColumns()
    {
        return numberOfColumns;
    }
    Matrix addToThisMatrix(Matrix m2)
    {
        Matrix tempMatrix=new Matrix(this.numberOfRows,this.numberOfColumns);
        for(int i = 0; i<this.numberOfRows; i++)
        {
            for(int j=0; j<this.numberOfColumns;j++)
            {
                tempMatrix.elements[i][j]=new Element(this.elements[i][j].pvalue()+m2.elements[i][j].pvalue());
            }
        }
        return tempMatrix;
    }
    Matrix subtractFromThisMatrix(Matrix m2)
    {
        Matrix tempMatrix=new Matrix(this.numberOfRows,this.numberOfColumns);
        for(int i = 0; i<this.numberOfRows; i++)
        {
            for(int j=0; j<this.numberOfColumns;j++)
            {
                tempMatrix.elements[i][j]=new Element(this.elements[i][j].pvalue()-m2.elements[i][j].pvalue());
            }
        }
        return tempMatrix;
    }
    Matrix(Matrix m1, Matrix m2)//to multiply matrices
    {
        this.numberOfRows=m1.numberOfRows();
        this.numberOfColumns=m2.numberOfColumns();
        this.elements=new Element[numberOfRows][numberOfColumns];
        for(int i = 0; i<this.numberOfRows; i++)
        {
            for(int j = 0; j<this.numberOfColumns; j++)
            {
                int tempsum=0;
                for(int k = 0; k<m2.numberOfRows();k++)
                {
                    tempsum+=m1.elements[i][k].pvalue()*m2.elements[k][j].pvalue();
                }
                this.elements[i][j]=new Element(tempsum);
            }
        }
    }
    Matrix(Matrix m1)//transposing a matrix
    {
        this.numberOfRows=m1.numberOfColumns();
        this.numberOfColumns=m1.numberOfRows();
        this.elements=new Element[numberOfRows][numberOfColumns];
        for(int i = 0; i<m1.numberOfRows();i++)
        {
            for(int j = 0; j<m1.numberOfColumns(); j++)
            {
                elements[j][i]=new Element(m1.elements[i][j].pvalue());
            }
        }
    }
}
