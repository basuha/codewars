package are_they_the_same;

import java.util.Arrays;

//https://www.codewars.com/kata/550498447451fbbd7600041c/train/java
/*
Given two arrays a and b write a function comp(a, b) that
 checks whether the two arrays have the "same" elements, with the same multiplicities.
  "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.

Examples
Valid arrays
a = [121, 144, 19, 161, 19, 144, 19, 11]
b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]
comp(a, b) returns true because in b 121 is the square of 11, 14641 is the square of 121,
 20736 the square of 144, 361 the square of 19, 25921 the square of 161, and so on. It gets
  obvious if we write b's elements in terms of squares:

a = [121, 144, 19, 161, 19, 144, 19, 11]
b = [11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19]
Invalid arrays
If we change the first number to something else, comp may not return true anymore:

a = [121, 144, 19, 161, 19, 144, 19, 11]
b = [132, 14641, 20736, 361, 25921, 361, 20736, 361]
comp(a,b) returns false because in b 132 is not the square of any number of a.

a = [121, 144, 19, 161, 19, 144, 19, 11]
b = [121, 14641, 20736, 36100, 25921, 361, 20736, 361]
comp(a,b) returns false because in b 36100 is not the square of any number of a.

Remarks
a or b might be [] (all languages except R, Shell).
a or b might be nil or null or None or nothing.
If a or b are nil (or null or None), the problem doesn't make sense so return false.
 */
public class AreSame {
    public static boolean comp(int[] a, int[] b) {
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        if (a == null || b.length == 0 || a.length == 0)
            return false;
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < a.length; j++) {
                System.out.println("b = " + b[i]);
                System.out.println("a = " + (a[j] * a[j]) + "(" + a[j] + ")");
                if (a[j] * a[j] == b[i]) {
                    System.err.println(true);
                    break;
                } else {
                    if (j == a.length - 1) {
                        return false;
                    }
                }
                System.err.println(false);
                System.out.println("___");
            }
        return true;
    }
}
