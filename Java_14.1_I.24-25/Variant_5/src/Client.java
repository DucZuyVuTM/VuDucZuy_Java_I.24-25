import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        System.out.println("Menu:\n");

        System.out.println("1) Write content.");
        System.out.println("2) Save content.");
        System.out.println("3) Print current content.");
        System.out.println("4) Undo.\n");

        System.out.println("0) EXIT\n");

        int choice = 5;
        while (choice != 0) {
            System.out.print("Your choice: ");
            choice = input.nextInt(); input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Write the content: ");
                    editor.setContent(input.nextLine());
                    break;

                case 2:
                    caretaker.save(editor.save());
                    System.out.println("Content saved");
                    break;

                case 3:
                    System.out.println("Content: " + editor.getContent());
                    break;

                case 4:
                    editor.restore(caretaker.undo());
                    System.out.println("Content restored");
                    break;
                
                default:
                    break;
            }
            System.out.println();
        }

        input.close();
    }
}
