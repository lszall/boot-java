package com.jx.platform.framework.config.lock;

@FunctionalInterface
public interface CallBack {

    Object doTask() throws Throwable;
}
