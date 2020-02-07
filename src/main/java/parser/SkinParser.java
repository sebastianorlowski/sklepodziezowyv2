package parser;
import enums.SkinType;

public class SkinParser {

    public static SkinType parseSkin(String parse) {
        String skinType = parse.toUpperCase();

        if(skinType.equals("NATURAL")) {
            return SkinType.NATURAL;
        }

        else if(skinType.equals("ARTIFICAL")) {
            return SkinType.ARTIFICAL;
        }

        return SkinType.ARTIFICAL;



    }
}
