import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            HomeTheaterFacade homeTheater = new HomeTheaterFacade();

            System.out.println("Menu:");

            System.out.println("1) Watch a movie.");
            System.out.println("2) End the movie.");
            System.out.println("0) EXIT");

            String movie = "";
            int volume = 0;
            String projectorInput = "DVD Player";

            int choice = 3;
            while (choice != 0) {
                System.out.print("\nYour choice: ");
                choice = input.nextInt(); input.nextLine();

                switch (choice) {
                    case 0:
                        break;

                    case 1:
                        System.out.print("Write the movie name: ");
                        movie = input.nextLine();
                        System.out.print("Set the volume level: ");
                        volume = input.nextInt(); input.nextLine();
                        homeTheater.watchMovie(movie, volume, projectorInput);
                        break;

                    case 2:
                        homeTheater.endMovie();
                        break;
                
                    default:
                        System.out.println("Invalid message.");
                        break;
                }
            }

            homeTheater = null;
            System.gc();

            // Chờ vài giây để GC thực thi `finalize()`
            Thread.sleep(1100);

            input.close();

        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
