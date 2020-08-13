package parse_html_css_colors;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.ColorModel;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class ExampleTests {
    private HtmlColorParser parser;

    @Before
    public void setup() {
        parser = new HtmlColorParser(PresetColors.getMap());
    }

    @Test
    public void testExamples() {
        shouldParse("#80FFA0",   new RGB(128, 255, 160));
        shouldParse("#3B7",      new RGB( 51, 187, 119));
        shouldParse("LimeGreen", new RGB( 50, 205,  50));
    }

    /* Test helper functions */

    private void shouldParse(String color, RGB expected) {
        assertRgbEquals(color, expected, parser.parse(color));
    }

    private static <RGB> void assertRgbEquals(String input, RGB expected, RGB actual) throws AssertionError {
        try {
            System.out.printf("input: \"%s\"", input);
            assertEquals(expected, actual);
            System.out.println(" => pass!");
        } catch (AssertionError e) {
            String message = String.format(Locale.ENGLISH,
                    "expected: %s\nactual  : %s", expected, actual);
            throw new AssertionError(message, e);
        }
    }
}
