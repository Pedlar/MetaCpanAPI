package org.notlocalhost.metacpan.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pedlar on 9/20/14.
 */
public final class AuthorSearch {
    public AuthorHits hits;

    public class AuthorHits {
        public List<AuthorHitsWrapper> hits;
    }

    public class AuthorHitsWrapper {
        @SerializedName("_source")
        public
        Author author;
    }
}
