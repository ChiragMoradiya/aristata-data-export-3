package com.dw.aristata.export3;

import rx.Observable;
import rx.schedulers.Schedulers;

public class MastersJob {

  public Observable<Void> toObservable() {
    System.out.println(Thread.currentThread().getName() +": Observable creation STARTED for masters");
    Observable<Void> o = Observable.fromCallable(() -> {
      return call();
    }).subscribeOn(Schedulers.computation());
    System.out.println(Thread.currentThread().getName() +": Observable creation COMPLETED for masters");
    return o;
  }

  public Void call() throws Exception {
    System.out.println(Thread.currentThread().getName() +": Masters job - STARTED");
    Thread.sleep(2000l);
    System.out.println(Thread.currentThread().getName() +": Masters job - COMPLETED");
    return null;
  }
}
