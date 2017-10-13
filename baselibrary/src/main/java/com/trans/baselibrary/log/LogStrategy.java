package com.trans.baselibrary.log;

public interface LogStrategy {

  void log(int priority, String tag, String message);
}
