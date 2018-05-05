package com.eventera.hsmnzaydn.eventeraandroid.eventbus;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.WallEntry;

/**
 * Created by hsmnzaydn on 5/5/18.
 */

public class WallEntryEvent {
    private WallEntry wallEntry;

    public WallEntryEvent(WallEntry wallEntry) {
        this.wallEntry = wallEntry;
    }

    public WallEntry getWallEntry() {
        return wallEntry;
    }

    public void setWallEntry(WallEntry wallEntry) {
        this.wallEntry = wallEntry;
    }
}
