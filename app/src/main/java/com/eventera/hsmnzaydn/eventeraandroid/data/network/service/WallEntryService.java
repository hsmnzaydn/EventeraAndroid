package com.eventera.hsmnzaydn.eventeraandroid.data.network.service;

import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.Comment;
import com.eventera.hsmnzaydn.eventeraandroid.data.network.model.CommonResponse;

import java.util.List;

/**
 * Created by hsmnzaydn on 5/5/18.
 */

public interface WallEntryService {
    void postComment(String eventId, String wallEntryId, Comment text, ServiceCallback<CommonResponse> commonResponseServiceCallback);
    void getCommentList(String eventId, String wallEntryId, ServiceCallback<List<Comment>> listServiceCallback,ServiceCallback<CommonResponse> commonResponseServiceCallback);
    void like(String eventId, String wallEntryId);
}
