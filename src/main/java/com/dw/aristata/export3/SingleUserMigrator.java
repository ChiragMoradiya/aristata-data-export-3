package com.dw.aristata.export3;

import java.util.concurrent.Future;

import rx.Observable;
import rx.schedulers.Schedulers;

public class SingleUserMigrator {
  private String userId;
  
  public SingleUserMigrator(String userId) {
    this.userId = userId;
  }
  
  public String getUserId() {
    return userId;
  }
  
  public void setUserId(String userId) {
    this.userId = userId;
  }
  
  public Observable<Boolean> toObservable() {
    return Observable.fromCallable(() -> {
      try {
        Thread.sleep(1000l);
        System.out.println(Thread.currentThread().getName() + ": SingleUserMigrator:: " + this.userId + ". Time:" + System.currentTimeMillis());
      } catch (Exception e) {
        e.printStackTrace();
      }
      return true;
    }).subscribeOn(Schedulers.computation());
    
  }
}
