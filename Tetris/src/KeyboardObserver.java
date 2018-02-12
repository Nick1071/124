import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class KeyboardObserver{

    public enum Move {
        RIGHT,
        LEFT,
        DOWNMAX,
        ROTATE,
        NOUN
    }


    public Move getMove() {
        Scanner scanner = new Scanner(System.in);
        String c = scanner.nextLine();
        Move move;
        switch (c) {
            case "l":
                move = Move.RIGHT;
                break;
            case "j":
                move = Move.LEFT;
                break;
            case "m":
                move = Move.DOWNMAX;
                break;
            case "k":
                move = Move.ROTATE;
                break;
            default:
                move = Move.NOUN;
        }
        return move;
    }
}
