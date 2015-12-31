package com.dw.aristata.export3;

import java.util.concurrent.Callable;

import rx.Observable;
import rx.schedulers.Schedulers;

public class FamilyJob implements Callable<Void> {
  
  String familyId;
  
  public FamilyJob(String familyId) {
    this.familyId = familyId;
  }

  public Observable<Void> toObservable() {
    System.out.println(Thread.currentThread().getName() +": Observable creation STARTED for family :" + familyId);
    Observable<Void> o = Observable.fromCallable(this).subscribeOn(Schedulers.computation());
    System.out.println(Thread.currentThread().getName() +": Observable creation ENDED for family :" + familyId);
    return o;
  }

  @Override
  public Void call() throws Exception {
    System.out.println(Thread.currentThread().getName() +": Family job :" + familyId + " - STARTED");
    Thread.sleep(2000l);
    System.out.println(Thread.currentThread().getName() +": Family job :" + familyId + " - COMPLETED");
    return null;
  }
}
