import java.util.Scanner;

public class Prototype_shapes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Circle Circle1 = new Circle(0);
        Rectangle Rectangle1 = new Rectangle(0, 0);

        Circle Circle2 = new Circle(0);
        Rectangle Rectangle2 = new Rectangle(0, 0);;

        System.out.println("Menu:\n");

        System.out.println("1)  Set radius for Circle1.");
        System.out.println("2)  Get radius for Circle1.\n");

        System.out.println("3)  Set radius for Circle2.");
        System.out.println("4)  Get radius for Circle2.\n");

        System.out.println("5)  Clone Circle1 information into Circle2.");
        System.out.println("6)  Clone Circle2 information into Circle1.\n");

        System.out.println("7)  Display the info of Circle1.");
        System.out.println("8)  Display the info of Circle2.\n");

        System.out.println("------------------------------------------\n");

        System.out.println("9)  Set width for Rectangle1.");
        System.out.println("10) Get width for Rectangle1.\n");

        System.out.println("11) Set width for Rectangle2.");
        System.out.println("12) Get width for Rectangle2.\n");

        System.out.println("13) Set height for Rectangle1.");
        System.out.println("14) Get height for Rectangle1.\n");

        System.out.println("15) Set height for Rectangle2.");
        System.out.println("16) Get height for Rectangle2.\n");

        System.out.println("17) Clone Rectangle1 information into Rectangle2.");
        System.out.println("18) Clone Rectangle2 information into Rectangle1.\n");

        System.out.println("19) Display the info of Rectangle1.");
        System.out.println("20) Display the info of Rectangle2.\n");

        System.out.println("0)  EXIT\n");

        int radius = 0;        
        int width  = 0;
        int height = 0;

        int choice = 21;
        while (choice != 0) {
            System.out.print("Your choice: ");
            choice = input.nextInt(); input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Write the radius: ");
                    radius = input.nextInt(); input.nextLine();
                    Circle1.setRadius(radius);
                    break;

                case 2:
                    System.out.println("radius = " + Circle1.getRadius());
                    break;

                case 3:
                    System.out.print("Write the radius: ");
                    radius = input.nextInt(); input.nextLine();
                    Circle2.setRadius(radius);
                    break;

                case 4:
                    System.out.println("radius = " + Circle2.getRadius());
                    break;

                case 5:
                    Circle2 = Circle1.clone();
                    System.out.println("Circle2 ---> radius = " + Circle2.getRadius());
                    break;

                case 6:
                    Circle1 = Circle2.clone();
                    System.out.println("Circle1 ---> radius = " + Circle1.getRadius());
                    break;

                case 7:
                    Circle1.display();
                    break;

                case 8:
                    Circle2.display();
                    break;

                case 9:
                    System.out.print("Write the width: ");
                    width = input.nextInt(); input.nextLine();
                    Rectangle1.setWidth(width);
                    break;

                case 10:
                    System.out.println("width = " + Rectangle1.getWidth());
                    break;

                case 11:
                    System.out.print("Write the width: ");
                    width = input.nextInt(); input.nextLine();
                    Rectangle2.setWidth(width);
                    break;

                case 12:
                    System.out.println("width = " + Rectangle2.getWidth());
                    break;

                case 13:
                    System.out.print("Write the height: ");
                    height = input.nextInt(); input.nextLine();
                    Rectangle1.setHeight(height);
                    break;

                case 14:
                    System.out.println("height = " + Rectangle1.getHeight());
                    break;

                case 15:
                    System.out.print("Write the height: ");
                    height = input.nextInt(); input.nextLine();
                    Rectangle2.setHeight(height);
                    break;

                case 16:
                    System.out.println("height = " + Rectangle2.getHeight());
                    break;

                case 17:
                    Rectangle2 = Rectangle1.clone();
                    System.out.println("Rectangle2 ---> width = " + Rectangle2.getWidth() + ", height: " + Rectangle2.getHeight());
                    break;

                case 18:
                    Rectangle1 = Rectangle2.clone();
                    System.out.println("Rectangle1 ---> width = " + Rectangle1.getWidth() + ", height: " + Rectangle1.getHeight());
                    break;

                case 19:
                    Rectangle1.display();
                    break;

                case 20:
                    Rectangle2.display();
                    break;
            
                default:
                    break;
            }
        }

        input.close();
    }
}
