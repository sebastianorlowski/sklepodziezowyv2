package parser;
import enums.Color;
import org.junit.Assert;
import org.junit.Test;
import parser.ColorParser;

public class ColorParserTest {

    @Test
    public void blackColorParserTest() {

        String parse = "BLACK";
        Color color = ColorParser.parseColor(parse);
        Assert.assertEquals(Color.BLACK, color);

    }

    @Test
    public void redColorParserTest() {
        String parse = "rEd";
        Color color = ColorParser.parseColor(parse);
        Assert.assertEquals(Color.RED, color);
    }

    @Test
    public void yellowColorParserTest() {
        String parse = "yelLow";
        Color color = ColorParser.parseColor(parse);
        Assert.assertEquals(Color.YELLOW, color);
    }

    @Test
    public void greenColorParserTest() {
        String parse = "greeN";
        Color color = ColorParser.parseColor(parse);
        Assert.assertEquals(Color.GREEN, color);
    }



}
