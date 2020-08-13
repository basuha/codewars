package write_nuber_in_expanded_form;
//https://www.codewars.com/kata/5842df8ccbd22792a4000245/train/java
/*
Write Number in Expanded Form
You will be given a number and you will need to return it as a string in Expanded Form. For example:

Kata.expandedForm(12); # Should return "10 + 2"
Kata.expandedForm(42); # Should return "40 + 2"
Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
NOTE: All numbers will be whole numbers greater than 0.

If you liked this kata, check out part 2!!
 */
public class Kata {
    public static String expandedForm(int num) {
        String numString = String.valueOf(num);
        char[] charArray = numString.toCharArray();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '0') {
                if (i == charArray.length - 1) {
                    out.delete(out.length() - 3, out.length());
                    break;
                }
                continue;
            }
            if (i == charArray.length - 1) {
                out.append(charArray[i]);
                break;
            }
            out.append(charArray[i]).append("0".repeat(numString.substring(i + 1).length())).append(" + ");
        }
        return out.toString();
    }

    public static void main(String[] args) {
//        System.out.println(expandedForm(70304));
        System.out.println(expandedForm(10));
        System.out.println(expandedForm(40));
        System.out.println(expandedForm(12));
        System.out.println(expandedForm(42));
        System.out.println(expandedForm(40001));
        System.out.println(expandedForm(400010));
    }
}
