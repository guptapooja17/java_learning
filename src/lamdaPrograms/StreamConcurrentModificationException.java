package lamdaPrograms;

import java.util.ArrayList;
import java.util.List;

public class StreamConcurrentModificationException {

    public static void main(String[] args) {

        List<Integer> input = List.of(1);
        List<Integer> list = new ArrayList<>(input);

        // When the pipeline is executed, it modifies the source of the stream. 
        // This behaviour is prohibited for non-concurrent sources, resulting in an exception.
        // Exception in thread "main" java.util.ConcurrentModificationException
        list.stream().forEach(i -> list.add(i + 1));
        
        System.out.println(list);

    }

}