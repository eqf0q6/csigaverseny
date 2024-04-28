package csigaverseny;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Sandor Kollarits
 */
public class Game {

    String guessedWinner = "";
    ArrayList<Snail> snails = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public Game() {
        snails.add(Snail.getSnail("piros", getBooster(), 2, 0));
        snails.add(Snail.getSnail("zold", getBooster(), 2, 0));
        snails.add(Snail.getSnail("kek", getBooster(), 3, 0));
    }

    public static boolean getBooster() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100);
        return randomNumber <= 20;
    }

    public void guess() {
        String inputText;

        do {
            System.out.println("Guess winner (piros/zold/kek)");
            guessedWinner = scanner.nextLine();
        } while (!guessedWinner.equals("piros") && !guessedWinner.equals("zold") && !guessedWinner.equals("kek"));

        // Kiírjuk a bekért szöveget
        System.out.println("Your guess " + guessedWinner);

        // Lezárjuk a scanner objektumot
        scanner.close();
    }

    public void incraseDistance(Snail snail) {
        if (snail.hasBooster()) {
            snail.setDistance(snail.getDistance() + snail.getSpeed() * 2);
        } else {
            snail.setDistance(snail.getDistance() + snail.getSpeed());
        }

    }

    public void lap() {

        for (int i = 0; i < snails.size(); i++) {
            incraseDistance(snails.get(i));
            snails.get(i).setBooster(getBooster());
        }

    }

    public void race(int lap) {
        for (int i = 0; i < lap; i++) {
            lap();
        }
        result();
    }

    public Snail getWinner() {
        Snail winner = snails.get(0);
        if (snails.get(1).getDistance() > winner.getDistance()) {
            winner = snails.get(1);
        }

        if (snails.get(2).getDistance() > winner.getDistance()) {
            return snails.get(2);
        }
        return winner;
    }

    public void result() {
        if (guessedWinner.equals(getWinner().getColor())) {
            System.out.println("You win");
        } else {
            System.out.println("You loose");
        }

        for (int i = 0; i < snails.size(); i++) {
            System.out.println(snails.get(i));
        }

    }

}
