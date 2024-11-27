import java.lang.Thread;

public class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Amplifier amplifier;
    private Projector projector;

    public HomeTheaterFacade() throws InterruptedException {
        System.out.println("Preparing Theater...\n");
        Thread.sleep(1000);

        dvdPlayer = new DVDPlayer();
        amplifier = new Amplifier();
        projector = new Projector();

        System.out.println("Theater is ON");
    }

    public void watchMovie(String movie, int volume, String projectorInput) throws InterruptedException {
        System.out.println("Preparing to watch a movie...");
        Thread.sleep(1000);

        dvdPlayer.on();
        Thread.sleep(100);
        dvdPlayer.play(movie);
        Thread.sleep(300);

        amplifier.on();
        Thread.sleep(100);
        amplifier.setVolume(volume);
        Thread.sleep(300);
        
        projector.on();
        Thread.sleep(100);
        projector.setInput(projectorInput);

        Thread.sleep(1000);
        System.out.println("Movie is now playing. Enjoy!");
    }

    public void endMovie() throws InterruptedException {
        System.out.println("Shutting down the movie...");
        Thread.sleep(1000);

        dvdPlayer.off();
        Thread.sleep(100);
        amplifier.off();
        Thread.sleep(100);
        projector.off();

        Thread.sleep(1000);
        System.out.println("Movie is stop playing.");
    }

    @Override
    protected void finalize() {
        System.out.println("Shutting down Theater...");
        try {
            Thread.sleep(1000); // Tạm dừng 1 giây
        } catch (InterruptedException e) {
            System.out.println("Interrupted while shutting down Theater: " + e.getMessage());
        }
        System.out.println("\nTheater is OFF");
    }    
}
