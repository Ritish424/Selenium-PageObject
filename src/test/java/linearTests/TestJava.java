package linearTests;

import java.util.*;

public class TestJava {
    public static void main(String[] args) {
        TestJava tj = new TestJava();
        tj.getLengthofString("length of a text");
        tj.stringBuilderReverse("Reverse of given string");
        tj.stringReverse("reverse string");
        tj.characterCount("newtext");
        tj.removeDuplicteUsingSet("Bloomberg");
        tj.removeDuplicateUsingArrayList("senses");
        tj.secondLargest(new int[]{1, 2, 1, 23, 45});
        tj.swapNumbers(18, 24);
        tj.removeWhiteSpaces("Removing White Spaces In A Text");
        tj.stringFomrat("aaabbcccdd");
        tj.fibonacciSeries(8);
        tj.primeCheck(4);
        tj.capitalizeWord("the indian express");
        tj.reverseInteger(7678);
    }

    public void getLengthofString(String text) {
        char[] array = text.toCharArray();
        int i = 0;
        for (char c : array) {
            i++;
        }
        System.out.println("String Length is " + i);
    }

    public void stringBuilderReverse(String text) {
        StringBuilder sb = new StringBuilder(text);
        System.out.println("Reverse of the give text is " + sb.reverse());
    }

    public void stringReverse(String text) {
        char[] array = text.toCharArray();
        String reverse = "";
        for (int i = array.length - 1; i >= 0; i--) {
            reverse += array[i];
        }
        System.out.println("Reverse without builder is " + reverse);
    }

    public void characterCount(String text) {
        String[] array = text.split("");
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        for (String s : array) {
            if (hmap.containsKey(s)) {
                hmap.put(s, hmap.get(s) + 1);
            } else {
                hmap.put(s, 1);
            }
        }
        for (Map.Entry entry : hmap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public void removeDuplicteUsingSet(String text) {

        String[] str = text.split("");
        Set<String> sSet = new HashSet<String>();
        for (String s : str) {
            sSet.add(s);
        }
        System.out.println("After removing duplicates: " + sSet);
    }

    public void removeDuplicateUsingArrayList(String text) {
        String[] str = text.split("");
        List<String> lst = new ArrayList<String>();
        for (String s : str) {
            if (!lst.contains(s)) {
                lst.add(s);
            }
        }
        System.out.println("After removing duplicates using Array List" + lst);
    }

    public void secondLargest(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] >= array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Second largets in array is " + array[1]);
    }

    public void swapNumbers(int a, int b) {
        System.out.println("Before swapping " + a + " & " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swapping " + a + " & " + b);
    }

    public void removeWhiteSpaces(String text) {
        System.out.println("After removing white spaces from given text is: " + text.replaceAll("\\s", ""));
    }

    public void stringFomrat(String text) {
        char[] ch = text.toCharArray();
        String output = "";
        for (int i = 0; i < ch.length; i++) {
            int count = 1;
            while (i + 1 < ch.length && ch[i] == ch[i + 1]) {
                count += 1;
                i += 1;
            }
            output += ch[i] + String.valueOf(count);
        }
        System.out.println("After formatting " + output);
    }

    public void fibonacciSeries(int maxNumber) {
        int previous = 0;
        int next = 1;
        for (int i = 0; i < maxNumber; i++) {
            System.out.print(previous + " ");
            int temp = previous;
            previous = next;
            next = temp + next;
        }
    }

    public void primeCheck(int number) {
        boolean prime = true;
        for (int i = 2; i < number / 2; i++) {
            if ((number / 2) % i == 0) {
                prime = false;
                break;
            }
        }
        if (prime == true) {
            System.out.println("\nGiven number " + number + " is prime");
        } else {
            System.out.println("\nGiven number " + number + " is not prime");
        }

    }

    public void capitalizeWord(String string) {
        String[] words = string.split("\\s");
        String result = "";
        for (String s : words) {
            String first = s.substring(0, 1).toUpperCase();
            String remains = s.substring(1);
            result = result + first + remains + " ";

        }
        System.out.println("After capitalizing each word " + result.trim());
    }

    public void reverseInteger(int number) {
        int reverse = 0;
        while (number != 0) {
            int lastDigit = number % 10;
            reverse = reverse * 10 + lastDigit;
            number = number / 10;
        }
        System.out.println("After reversing digit: " + reverse);
    }
}
