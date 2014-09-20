package org.notlocalhost.metacpan.services;

import org.notlocalhost.metacpan.models.Author;
import org.notlocalhost.metacpan.models.AuthorSearch;
import org.notlocalhost.metacpan.models.DistributionSearch;
import org.notlocalhost.metacpan.models.Module;
import org.notlocalhost.metacpan.models.Release;
import org.notlocalhost.metacpan.models.ReleaseSearch;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by pedlar on 9/19/14.
 */
public interface MetaApiService {
    @GET("/module/{module}/")
    public Module getModule(@Path("module") String moduleName);

    @GET("/author/{author}/")
    public Author getAuthor(@Path("author") String author);

    @GET("/pod/{module}/")
    public String getPod(@Path("module") String moduleName, @Query("content-type") String contentType);

    @GET("/author/_search/")
    public AuthorSearch searchAuthor(@Query("q") String query);

    @GET("/distribution/_search/")
    public DistributionSearch searchDistribution(@Query("q") String query);

    @GET("/release/_search/")
    public ReleaseSearch searchRelease(@Query("q") String query);

    @GET("/release/{release}/")
    public Release getRelease(@Path("release") String release);
}
