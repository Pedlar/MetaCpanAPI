package org.notlocalhost.metacpan.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pedlar on 9/20/14.
 */
public final class DistributionSearch {
    public DistributionHits hits;

    public class DistributionHits {
        public List<DistributionHitsWrapper> hits;
    }

    public class DistributionHitsWrapper {
        @SerializedName("_source")
        public
        DistributionHitsSourceWrapper _source;
    }

    public class DistributionHitsSourceWrapper {
        public String name;
    }
}