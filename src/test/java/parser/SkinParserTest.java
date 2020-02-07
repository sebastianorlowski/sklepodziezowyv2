package parser;

import enums.SkinType;
import org.junit.Assert;
import org.junit.Test;

public class SkinParserTest {

    @Test
    public void naturalSkinTest() {
        String parse = "natuRal";
        SkinType skinType = SkinParser.parseSkin(parse);
        Assert.assertEquals(SkinType.NATURAL, skinType);
    }

    @Test
    public void artificalSkinTest() {
        String parse = "artifiCaL";
        SkinType skinType = SkinParser.parseSkin(parse);
        Assert.assertEquals(SkinType.ARTIFICAL, skinType);
    }
}
