package com.eventera.hsmnzaydn.eventeraandroid.ui.DialogPopup;


import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Interesting;
import com.eventera.hsmnzaydn.eventeraandroid.ui.base.DialogMvpView;

import java.util.List;

/**
 * Created by hsmnzaydn on 29.01.2018.
 */

public interface PopupFragmentMvpView extends DialogMvpView {
    void openEventListActivity();
    void loadDataToList(List<Interesting> lisOfInteresting);
    void dismissPopup();
}
