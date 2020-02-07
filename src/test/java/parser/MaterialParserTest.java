package parser;

import enums.Material;
import org.junit.Assert;
import org.junit.Test;
/** LEATHER, FUR, COTTON, WOOL, POLYESTERS; **/
public class MaterialParserTest {

    @Test
    public void leatherMaterialTest() {
        String parse = "lEather";
        Material material = MaterialParser.parseMaterial(parse);
        Assert.assertEquals(Material.LEATHER, material);

    }

    @Test
    public void furMaterialTest() {
        String parse = "FUr";
        Material material = MaterialParser.parseMaterial(parse);
        Assert.assertEquals(Material.FUR, material);
    }

    @Test
    public void cottonMaterialTest() {
        String parse = "coTTon";
        Material material = MaterialParser.parseMaterial(parse);
        Assert.assertEquals(Material.COTTON, material);
    }

    @Test
    public void woolMaterialTest() {
        String parse = "wooL";
        Material material = MaterialParser.parseMaterial(parse);
        Assert.assertEquals(Material.WOOL, material);
    }

    @Test
    public void polyestersMaterialTest() {
        String parse = "polyesterS";
        Material material = MaterialParser.parseMaterial(parse);
        Assert.assertEquals(Material.POLYESTERS, material);
    }


}
