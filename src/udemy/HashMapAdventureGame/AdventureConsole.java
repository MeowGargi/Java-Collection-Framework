package udemy.HashMapAdventureGame;

import java.util.Scanner;

public class AdventureConsole {
//    final static String textBlock = """
//            *** You're standing inside a well house for a small spring *** \n
//            From here, you can see:
//            + A road to the West (W)
//            + A lake to the North (N)
//            + A stream to the South (S)
//            Select Your Compass Direction (Q to quit) >>
//            """;

    public static void main(String[] args) {
        AdventureGame  game = new AdventureGame();
        game.play("road");

        Scanner scanner = new Scanner(System.in);

        while(true){
            String direction = scanner.nextLine().trim().toUpperCase().substring(0,1);
            if( direction.equals("Q")) break;
            game.move(direction);
        }
    }


}
