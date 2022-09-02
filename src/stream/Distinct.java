package stream;

import java.util.*;
import java.util.stream.Collectors;

public class Distinct {
    public static void main(String[] args) {
        A a = new A();
        a.setName("a");
        a.setDes("aa");

        A b = new A();
        b.setName("a");
        b.setDes("bb");

        ArrayList<A> list = new ArrayList<>();
        list.add(a);
        list.add(b);

//        List<A> collect = list.stream().distinct().collect(Collectors.toList());
//        System.out.println(collect.toString());

        ArrayList<A> collect = list.stream().
                collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(A::getName))), ArrayList::new));
        System.out.println(collect.toString());


    }
}
