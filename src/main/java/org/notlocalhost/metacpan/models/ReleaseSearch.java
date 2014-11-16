package org.notlocalhost.metacpan.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pedlar on 9/20/14.
 */
public final class ReleaseSearch {
    public ReleaseHits hits;

    public class ReleaseHits {
        public List<ReleaseHitsWrapper> hits;
    }

    public class ReleaseHitsWrapper {
        @SerializedName("_source")
        public Release release;
    }
}
