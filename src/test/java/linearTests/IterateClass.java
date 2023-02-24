package linearTests;

import java.util.*;

public class IterateClass {
    public static void collections() {
        List<String> list = new ArrayList<String>();
        list.add("C");
        list.add("Core Java");
        list.add("Advance Java");
        System.out.println("Initial collection value:" + list);
        Collections.addAll(list, "Servlet", "JSP");
        System.out.println("After adding elements collection value:" + list);
        String[] strArr = {"C#", ".Net"};
        Collections.addAll(list, strArr);
        System.out.println("After adding array collection value:" + list);
        Collections.sort(list);
        System.out.println("After sorting in ascending order:" + list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("After sorting in descending order:" + list);
        System.out.println("Minimum value " + Collections.min(list));
        System.out.println("Maximum value " + Collections.max(list));

    }

    public static void main(String[] args) {

        IterateClass.collections();

        // Creating a HashMap of int keys and String values
        HashMap<String, String> capitalMap = new HashMap<String, String>();

        // Adding Key and Value pairs to HashMap
        capitalMap.put("India", "Delhi");
        capitalMap.put("Russia", "Moscow");
        capitalMap.put("Japan", "Tokyo");
        capitalMap.put("Australia", "Sydney");
        capitalMap.put("USA", "Washington DC");

        //Simple For loop using keySet
        System.out.println("For loop using key set");
        for (String i : capitalMap.keySet()) {
            System.out.println("key: " + i + " value: " + capitalMap.get(i));
        }
        //For loop using Entryset
        System.out.println("\nFor loop using Entry Set");
        for (Map.Entry<String, String> entry : capitalMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }
        //Using Iterator and key set
        System.out.println("\nUsing Iterator and key set");
        Iterator<String> iterator = capitalMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ":" + capitalMap.get(key));
        }
        System.out.println("\nUsing Lambda Expression");
        capitalMap.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
        //Using Iterator and key set
        System.out.println("\nUsing Iterator and entry set");
        Iterator<Map.Entry<String, String>> itr = capitalMap.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, String> ent = itr.next();
            System.out.println(ent.getKey() + ":" + ent.getValue());
        }
        /*//Only to print values
        Iterator<String> ite = capitalMap.values().iterator();
        while (ite.hasNext()) {
            String value = ite.next();
            System.out.println("value :" + value);
        }*/

        List<String> crunchifyList = new ArrayList<String>();

        // add 4 different values to list
        crunchifyList.add("Facebook");
        crunchifyList.add("Paypal");
        crunchifyList.add("Google");
        crunchifyList.add("Yahoo");

        // Other way to define list is - we will not use this list :)
        List<String> crunchifyListNew = Arrays.asList("Facebook", "Paypal", "Google", "Yahoo");
        // Simple For loop
        System.out.println("\n==============> 1. Simple For loop Example.");
        for (int j = 0; j < crunchifyList.size(); j++) {
            System.out.println(crunchifyList.get(j));
        }
        // New Enhanced For loop
        System.out.println("\n==============> 2. New Enhanced For loop Example..");
        for (String temp : crunchifyList) {
            System.out.println(temp);
        }
        //Using Lambda Expression
        System.out.println("\n============> 3. New Lambda Expression");
        crunchifyListNew.forEach(v -> System.out.println(v + " "));
        // Iterator - Returns an iterator over the elements in this list in proper sequence.
        System.out.println("\n==============> 4. Iterator Example...");
        Iterator<String> crunchifyIterator = crunchifyList.iterator();
        while (crunchifyIterator.hasNext()) {
            System.out.println(crunchifyIterator.next());
        }
        // while loop
        System.out.println("\n==============> 5. While Loop Example....");
        int wi = 0;
        while (wi < crunchifyList.size()) {
            System.out.println(crunchifyList.get(wi));
            wi++;
        }
        // Iterable.forEach() util: Returns a sequential Stream with this collection as its source
        System.out.println("\n==============> 6. Iterable.forEach() Example....");
        crunchifyList.forEach((temp) -> {
            System.out.println(temp);
        });

    }
}
