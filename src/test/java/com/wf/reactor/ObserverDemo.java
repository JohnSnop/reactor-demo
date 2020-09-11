package com.wf.reactor;

import java.util.Observable;

/**
 * @author wf
 * @create 2020-09-09 22:12
 * @desc
 **/
public class ObserverDemo extends Observable {
    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }
}
