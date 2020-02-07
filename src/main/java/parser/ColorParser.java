package parser;

import enums.Color;

public class ColorParser {


    public static Color parseColor(String parse) {
        Color col = Color.valueOf(parse.toUpperCase());

        switch (col) {

            case BLACK:
                return Color.BLACK;

            case WHITE:
                return Color.WHITE;

            case RED:
                return Color.RED;

            case BLUE:
                return Color.BLUE;

            case GREEN:
                return Color.GREEN;

            case YELLOW:
                return Color.YELLOW;

            default:
                System.out.println("Wrong color!");

        }
        return null;

    }
}
