package be.jgl;

import rx.Observable;

/**
 * Created by jgl on 29/05/2015.
 */
class Example {
    public static void main(String[] args) {
        // Create an Observable, apply transformations and subscribe to it.
        Observable.just("Hello World")
                .map(s -> s + " -Dan")
                .map(String::hashCode)
                .map(i -> Integer.toString(i))
                .subscribe(System.out::println);
    }
}
