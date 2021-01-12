package rover;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean flag = true;
        /*boyut bilgisi*/
        while (flag) {
            String input = scan.nextLine();
            //String input = "55 5";
            flag = !isValid(input, 0);
            if (flag) System.out.println("format uygun degil");
            else Rover.setEndCord(input);
        }
        /*rover konum ve hareket alma*/
        while (true) {
            Rover rover = null;
            String input = scan.nextLine();
            //String input = "43 4 N";
            if (!isValid(input, 1)) {
                System.out.println("format uygun degil");
                continue;
            }
            rover = createRover(input);
            flag = true;
            while (flag) {
                input = scan.nextLine();
                //input = "LRMMRML";
                if (!isValid(input, 2)) {
                    System.out.println("format uygun degil");
                    continue;
                }
                parser(input, rover);
                flag = false;
                System.out.println(rover.getCoordinate());
            }
        }
    }

    /* alınan  farklı string tipi burada kontrol edilir*/
    public static boolean isValid(String input, int mode) {
        String lenPattern = "[0-9]+[/ ]+[0-9]";
        String rovPattern = "[0-9]+[/ ]+[0-9]+[/ ]+[NWESnwes]";
        String movePattern = "[lrmLRM]*";
        if (mode == 0) {
            return Pattern.matches(lenPattern, input);
        } else if (mode == 1) {
            return Pattern.matches(rovPattern, input);
        } else {
            return Pattern.matches(movePattern, input);
        }
    }

    /* rover hareket ve donus islemlerinin islenmesi*/
    public static void parser(String input, Rover rover) {
        for (char c : input.toCharArray()) {
            if (c == 'L') rover.l_rotate();
            else if (c == 'R') rover.r_rotate();
            else rover.move();
        }
    }

    public static Rover createRover(String input) {
        int spc1 = input.indexOf(' ');
        int spc2 = input.indexOf(' ', spc1 + 1);
        int x = Integer.valueOf(input.substring(0, spc1));
        int y = Integer.valueOf(input.substring(spc1 + 1, spc2));
        char rotation = Character.toUpperCase(input.charAt(input.length() - 1));
        return new Rover(x, y, rotation);
    }
}



