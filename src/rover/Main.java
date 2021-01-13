package rover;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static Plateau plateau;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean flag = true;
        /*boyut bilgisi*/
        while (flag) {
            String input = scan.nextLine();
            scan.nextLine();
            //String input = "55 5";
            flag = !isLenValid(input);
            if (flag) System.out.println("format uygun degil");

            else {
                String[] coords = input.split(" ");
                plateau = new Plateau(Integer.valueOf(coords[0]), Integer.valueOf(coords[1]));
            }
        }
        /*rover konum ve hareket alma*/
        while (true) {
            Rover rover = null;
            String input = scan.nextLine();
            //String input = "43 4 N";
            if (!isRovValid(input)) {
                System.out.println("format uygun değil");
                continue;
            }
            rover = createRover(input);
            flag = true;
            while (flag) {
                input = scan.nextLine();
                //input = "LRMMRML";
                if (!isMoveValid(input)) {
                    System.out.println("format uygun değil");
                    continue;
                }
                parser(input, rover);
                flag = false;
                System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getRotation());
            }
        }
    }

    public static boolean isLenValid(String input) {
        String lenPattern = "[1-9][0-9]?[ ][1-9][0-9]?"; //Plateaunun min 1 max 99
        return Pattern.matches(lenPattern, input);
    }

    public static boolean isRovValid(String input) {

        String rovPattern = "[1-9][0-9]?[ ][1-9][0-9]?[ ][NWESnwes]"; // X Y Rotation min 1 max 99
        if (!Pattern.matches(rovPattern, input)) {
            return false;
        }
        String[] coords = input.split(" ");
        if (Integer.valueOf(coords[0]) > plateau.getmX() && Integer.valueOf(coords[1]) > plateau.getmY()) {
            System.out.println("Plateau sınırı aşıldı lütfen geçerli bir değer girin");
            return false;
        }
        return true;
    }

    public static boolean isMoveValid(String input) {
        String movePattern = "[lrmLRM]*";
        return Pattern.matches(movePattern, input);
    }

    /* rover hareket ve donus islemlerinin islenmesi*/
    public static void parser(String input, Rover rover) {
        for (char c : input.toCharArray()) {
            if (c == 'L') rover.l_rotate();
            else if (c == 'R') rover.r_rotate();
            else rover.move(plateau);
        }
    }

    public static Rover createRover(String input) {
        String[] coords = input.split(" ");
        int x = Integer.valueOf(coords[0]);
        int y = Integer.valueOf(coords[1]);
        char rotation = Character.toUpperCase(coords[2].charAt(0));
        return new Rover(x, y, rotation, plateau);
    }
}



