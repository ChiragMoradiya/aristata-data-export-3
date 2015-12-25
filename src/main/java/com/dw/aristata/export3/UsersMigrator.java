package com.dw.aristata.export3;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.schedulers.Schedulers;

public class UsersMigrator {
  
  public UsersMigrator() {
  }
  
  public Observable<Boolean> toObservable() {
    Observable o1 = getObservable("One", 10);
    Observable o2 = getObservable("Two", 10);
    Observable o3 = getObservable("Three", 10);
    Observable o4 = getObservable("Four", 10);
    
    
    Observable o5 = Observable.concat(o1, o2);
    Observable o6 = Observable.concat(o3, o4);
    return Observable.merge(o5, o6).last();
  }
  
  private Observable getObservable(String prefix, int n) {
    List<Observable<Boolean>> observables = new ArrayList<>();
    for(String userId: getUserIds(prefix, n)) {
      observables.add(new SingleUserMigrator(userId).toObservable());
    }
    return Observable.merge(observables);
  }
  
  List<String> getUserIds(String prefix, int n) {
    List<String> records = new ArrayList<>();
    for(int i = 1 ;i <= n; i++) {
      records.add(prefix + i);
    }
    return records;
  }
}
