package lamdaPrograms;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main (String[] args) throws InterruptedException {
        Timestamp timestamp1, timestamp2 = null;
        List<Integer> l = new ArrayList<>();
        for (int i=0 ; i<=10000 ; i++){
            l.add(i);
        }
        timestamp1 = new Timestamp(System.currentTimeMillis());
        l.stream().filter( i -> i%2 == 0).forEach( i -> System.out.println(i));
        timestamp2 = new Timestamp(System.currentTimeMillis());
        System.out.println("Output List Sequential : " + (timestamp2.getTime() - timestamp1.getTime()));

        Thread.sleep(4000);
        Stream<Integer> s = l.parallelStream();
        timestamp1 = new Timestamp(System.currentTimeMillis());
        s.filter( i -> i%2 == 0).forEach( i -> System.out.println(i));
        timestamp2 = new Timestamp(System.currentTimeMillis());
        System.out.println("Output List Parallel : " + (timestamp2.getTime() - timestamp1.getTime()));
        System.out.println(s.isParallel());
    }
}
