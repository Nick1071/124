import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class KeyboardObserver{

    public enum Move {
        RIGHT,
        LEFT,
        DOWN,
        ROTATE,
        NOUN
    }


    public Move getMove() {
        Scanner scanner = new Scanner(System.in);
        String c = scanner.nextLine();
        Move move;
        switch (c) {
            case "r":
                move = Move.RIGHT;
                break;
            case "l":
                move = Move.LEFT;
                break;
            case "d":
                move = Move.DOWN;
                break;
            case "rr":
                move = Move.ROTATE;
                break;
            default:
                move = Move.NOUN;
        }
        return move;
    }
}
