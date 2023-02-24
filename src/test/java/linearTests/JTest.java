package linearTests;

import java.util.*;

public class JTest {

    public static void main(String[] args) {
        JTest.reverseString("newness");
        JTest.primeNumber(4);
        JTest.printPrimeNumber(10);
        JTest.getLengthOfString("Testnewlength");
        JTest.characterLength("aabbbaccdddd");
        JTest.removeDuplicates("abcdacdfels");
        JTest.powerUsingMath(4, 3);
        JTest.powerUsingWhile(3, 4);
        JTest.anagram("listen", "silent");
        JTest.triangleOfNumbers(3);
        JTest.pyramid(5);
        JTest.perfectNumber(496);
        JTest.removeDuplicateWords("a boy is boy not a girl");
    }

    public static void reverseString(String s) {
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev = rev + s.charAt(i);
        }
        System.out.println("Reverse of string " + rev);
    }

    public static void primeNumber(int num) {
        boolean b = true;
        for (int i = 2; i <= num / 2; i++) {
            if ((num / 2) % i == 0) {
                b = false;
                break;
            }

        }
        if (b == false) {
            System.out.println(num + " is not prime");
        } else {
            System.out.println(num + " is prime");
        }
    }

    public static void printPrimeNumber(int count) {

        System.out.println("");
        for (int i = 1; i <= count; i++) {
            boolean b = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                System.out.print(i + "\t");
            }
        }
    }

    public static void getLengthOfString(String str) {
        int count = 0;
        for (char s : str.toCharArray()) {
            count++;
        }
        System.out.println("\nLength of String is " + count);
    }

    public static void characterLength(String str) {
        String[] ar = str.split("");
        Map<String, Integer> map = new HashMap<>();
        for (String s : ar) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

    public static void removeDuplicates(String str) {
        String[] s = str.split("");
        List<String> l = new ArrayList<>();
        for (String a : s) {
            if (!l.contains(a)) {
                l.add(a);
            }
        }
        System.out.println("After removing duplicates " + l);
    }

    public static void powerUsingWhile(int base, int exponent) {
        long result = 1;
        while (exponent != 0) {
            result *= base;
            exponent--;
        }
        System.out.println(base + " Power of " + exponent + " is " + result);
    }

    public static void powerUsingMath(int base, int exponent) {
        double result = Math.pow(base, exponent);
        System.out.println(base + " Power of " + exponent + " is " + result);
    }

    public static void anagram(String text1, String text2) {
        String array1[] = text1.split("");
        String array2[] = text2.split("");
        Arrays.sort(array1);
        Arrays.sort(array2);
        if (array2.length == array1.length) {
            if (Arrays.equals(array1, array2)) {
                System.out.println(text1 + " is anagram of " + text2);
            } else {
                System.out.println("Both strings are not anagram to each other");
            }
        } else {
            System.out.println("Both strings are not anagram to each other");
        }
    }

    public static void triangleOfNumbers(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void pyramid(int size) {
        int numSpaces = size - 1;
        int numStars = 1;
        for (int i = 1; i <= size; i++) {
            //for printing spaces
            for (int j = 1; j <= numSpaces; j++) {
                System.out.print(" ");
            }
            //for printing stars
            for (int j = 1; j <= numStars; j++) {
                System.out.print(j + " ");
            }
            System.out.println("");
            numStars += 2;
            numSpaces--;
        }
    }

    public static void perfectNumber(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum = sum + i;
            }
        }
        if (number == sum) {
            System.out.println("Given number " + number + " is perfect number");
        } else {
            System.out.println("Given number " + number + "is not perfect number");
        }
    }

    public static void removeDuplicateWords(String sentence) {
        String array[] = sentence.split(" ");
        Set<String> set = new LinkedHashSet<String>();
        for (String s : array) {
            set.add(s);
        }
        String rem = "";
        for (String st : set) {
            rem = rem + st + " ";
        }
        System.out.println("After removing duplicates " + rem.trim());
    }
}
