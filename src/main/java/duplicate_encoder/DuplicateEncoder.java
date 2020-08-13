package duplicate_encoder;
//https://www.codewars.com/kata/54b42f9314d9229fd6000d9c/train/java


import org.apache.commons.lang3.StringUtils;

import java.util.stream.Collectors;

/*
The goal of this exercise is to convert a string to a new string
 where each character in the new string is "(" if that character
 appears only once in the original string, or ")" if that character
 appears more than once in the original string. Ignore capitalization
  when determining if a character is a duplicate.

Examples
"din"      =>  "((("
"recede"   =>  "()()()"
"Success"  =>  ")())())"
"(( @"     =>  "))(("
Notes

Assertion messages may be unclear about what they display in some languages.
 If you read "...It Should encode XXX", the "XXX" is the expected result, not the input!
 */
public class DuplicateEncoder {
    static String encode(String word){
        return word.toLowerCase().chars()
                .mapToObj(x -> (char) x)
                .map(x -> StringUtils.countMatches(word.toLowerCase(), x) > 1 ? ')' : '(')
                .map(Object::toString)
                .collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        System.out.println(encode("recede"));
    }
}
