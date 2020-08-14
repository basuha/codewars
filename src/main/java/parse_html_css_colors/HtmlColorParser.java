package parse_html_css_colors;

import javax.swing.*;
import java.awt.Color;
import java.awt.color.ColorSpace;
import java.awt.image.ColorModel;
import java.util.HashMap;
import java.util.Map;
//https://www.codewars.com/kata/58b57ae2724e3c63df000006/train/java
/*
In this kata you parse RGB colors represented by strings. The formats are primarily used in HTML and CSS. Your task is to implement a function which takes a color as a string and returns the parsed color as a map (see Examples).

Input:
The input string represents one of the following:

6-digit hexadecimal - "#RRGGBB"
e.g. "#012345", "#789abc", "#FFA077"
Each pair of digits represents a value of the channel in hexadecimal: 00 to FF
3-digit hexadecimal - "#RGB"
e.g. "#012", "#aaa", "#F5A"
Each digit represents a value 0 to F which translates to 2-digit hexadecimal: 0->00, 1->11, 2->22, and so on.
Preset color name
e.g. "red", "BLUE", "LimeGreen"
You have to use the predefined map PRESET_COLORS (JavaScript, Python, Ruby), presetColors (Java, C#, Haskell), or preset-colors (Clojure). The keys are the names of preset colors in lower-case and the values are the corresponding colors in 6-digit hexadecimal (same as 1. "#RRGGBB").
Examples:
parse("#80FFA0")   === new RGB(128, 255, 160))
parse("#3B7")      === new RGB( 51, 187, 119))
parse("LimeGreen") === new RGB( 50, 205,  50))

 */
public class HtmlColorParser {
    private Map<String, String> map;

    public HtmlColorParser(Map<String,String> map) {
        this.map = map;
    }
//sdadasdasd
    



    public RGB parse(String color) {
        Color c = Color.BLACK;
        if (color.matches("#.{3,6}")) {
            c = Color.decode(color);
        } else {
            try {
                c = (Color) AdditionalColors.class.getField(color.substring(1).toUpperCase()).get(null);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return new RGB(c.getRed(), c.getGreen(), c.getBlue());
    }
}

class AdditionalColors extends Color {

    public static final Color lightslategray = new Color(119, 136, 255);
    public static final Color LIGHTSLATEGRAY = lightslategray;

    public static final Color limegreen = new Color(50, 205, 50);
    public static final Color LIMEGREEN = limegreen;

    public AdditionalColors(int r, int g, int b) {
        super(r, g, b);
    }
}

class PresetColors {
    public static Map<String,String> getMap(){
        return new HashMap<>();
    }
}

final class RGB {
    public int r, g, b;

    public RGB() {
    }

    public RGB(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public String toString() {
        return "RGB{" +
                "r=" + r +
                ", g=" + g +
                ", b=" + b +
                '}';
    }
}