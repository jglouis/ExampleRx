package be.jgl;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by jgl on 29/05/2015.
 */
class Example {
    public static void main(String[] args) {

        // Create an Observable.
        Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello World");
                subscriber.onCompleted();
            }
        });

        // Create a Subscriber.
        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        // Subscribe to the Observable.
        myObservable.subscribe(mySubscriber);
    }
}
