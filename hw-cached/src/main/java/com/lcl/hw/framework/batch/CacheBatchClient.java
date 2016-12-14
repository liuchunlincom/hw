package com.lcl.hw.framework.batch;

import java.util.List;
import java.util.Map;

/**
 * Created by Rain on 2016/12/13 19:19.
 */
public interface CacheBatchClient {
    void startBatch();

    void endBatch();

    void releaseResource();

    Map getResultMap();

    List getResultList();
}
