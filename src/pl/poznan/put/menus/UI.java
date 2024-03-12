
package pl.poznan.put.menus;
public class UI {
    public void printUI() {
        System.out.println("===========================================================");
        System.out.println("                           MENU                            ");
        System.out.println("1. Create a new matrix");
        System.out.println("2. Delete a matrix from memory");
        System.out.println("3. Print all stored matrices");
        System.out.println("------------------------------------");
        System.out.println("4. Add selected matrices");
        System.out.println("5. Subtract selected matrices");
        System.out.println("6. Multiply selected matrices");
        System.out.println("7. Transpose a matrix");
        System.out.println("8. Multiply a matrix by a number");
        System.out.println("------------------------------------");
        System.out.println("9. Exit");
        System.out.println("------------------------------------");
        System.out.println("Your choice (input an integer):");
    }

    UI() {
    }
}
