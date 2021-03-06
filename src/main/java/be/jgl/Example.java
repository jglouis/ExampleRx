package be.jgl;

import rx.Observable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Created by jgl on 29/05/2015 for project ExampleRx for project ExampleRx for project ExampleRx.
 */
class Example {
    public static void main(String[] args) {
        // Create an Observable, apply transformations and subscribe to it.
        Observable.just("Hello World")
                .map(s -> s + " -Dan")
                .map(String::hashCode)
                .map(i -> Integer.toString(i))
                .subscribe(System.out::println);

        Collection<Integer> ints = getRandInts(10);
        Observable<Collection<Integer>> obsInts = Observable.just(ints);

        obsInts.subscribe(System.out::println);
        obsInts.flatMap(Observable::from)
                .map(i -> i + 1)
                .filter(i -> i > 0)
                .subscribe(System.out::println);
    }

    private static Collection<Integer> getRandInts(int n) {
        Collection<Integer> collection = new ArrayList<>();
        for (int i = 0; i < n; i++)
            collection.add(new Random().nextInt());
        return collection;
    }
}
