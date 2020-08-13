package exes_and_ohs;

import org.junit.Test;

import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class OH {
    public static boolean getXO (String str) {
        return str.toLowerCase()
                .chars()
                .filter(x -> x == 'x')
                .count()
                == str.toLowerCase()
                        .chars()
                        .filter(x -> x == 'o')
                        .count();
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(123));
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(4));
        System.out.println(getXO("xxxooo"));
        System.out.println(getXO("xxxXooOo"));
        System.out.println(getXO("xxx23424esdsfvxXXOOooo"));
        System.out.println(getXO("xXxxoewrcoOoo"));
        System.out.println(getXO("XxxxooO"));
        System.out.println(getXO("zssddd"));
        System.out.println(getXO("Xxxxertr34"));
    }

    @Test
    public void basicTests() {
        assertEquals(Integer.toBinaryString(0).substring(1), "0");
        assertEquals(Integer.toBinaryString(1), "01");
        assertEquals(Integer.toBinaryString(5), "0101");
        assertEquals(Integer.toBinaryString(213), "011010101");
        assertEquals(Integer.toBinaryString(9999999), "0100110001001011001111111");
    }
}
