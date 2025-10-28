package it.unibo.collections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static String insertTime(List<Integer> list) {
        final int ELEMS = 100_000;

        long time = System.nanoTime();
        /*
         * Run the benchmark
         */
        for (int i = 1; i <= ELEMS; i++) {
            list.addFirst(i);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        return (
            "add " 
                + ELEMS 
                + " in head " 
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        
    }

    private static String readingTime(List<Integer> list) {
        final int ELEMS = 1_000;
        final int mid = list.size() / 2;
        
        long time = System.nanoTime();
        /*
         * Run the benchmark
         */
        for (int i = 1; i <= ELEMS; i++) {
            list.get(mid);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        long millis = TimeUnit.NANOSECONDS.toMillis(time);
        return (// NOPMD
            "reading " 
                +  ELEMS
                + " in mid " 
                + time
                + "ns ("
                + millis
                + "ms)"
        );
    }

    final static int MIN = 1000;
    final static int MAX = 2000;


    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {

        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        ArrayList<Integer> arrayList = new ArrayList<>();
        
        for (int i = MIN; i < MAX; i++) {
            arrayList.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */


        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
        
        
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int FIRST = 0;
        final int LAST = linkedList.size() - 1;

        final int temp = linkedList.get(FIRST);
        linkedList.set(FIRST, linkedList.get(LAST));
        linkedList.set(LAST, temp);



        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        // for (var n : arrayList) {
        //     System.out.println(n);
        // }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        
        System.out.println("arrayList " + insertTime(arrayList));
        System.out.println("linkedList " + insertTime(linkedList));
        

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    
        System.out.println("arrayList " + readingTime(arrayList));
        System.out.println("linkedList " + readingTime(linkedList));

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        Map<String, Long> continentMap = new HashMap<>();
        continentMap.put("Africa", 1_110_635_000L);
        continentMap.put("Americas", 972_005_000L);
        continentMap.put("Antarctica", 0L);
        continentMap.put("Asia", 4_298_723_000L);
        continentMap.put("Europe", 742_442_000L);
        continentMap.put("Oceania", 38_304_000L);


        /*
         * 8) Compute the population of the world
         */
        long population = 0;
        for (Long n : continentMap.values()) {
            population += n;
        }
        System.out.println(population);
    }
}
