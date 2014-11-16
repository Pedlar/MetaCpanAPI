package org.notlocalhost.metacpan.services;

import com.google.gson.JsonObject;

import org.notlocalhost.metacpan.models.Author;
import org.notlocalhost.metacpan.models.AuthorSearch;
import org.notlocalhost.metacpan.models.DistributionSearch;
import org.notlocalhost.metacpan.models.Module;
import org.notlocalhost.metacpan.models.Release;
import org.notlocalhost.metacpan.models.ReleaseSearch;

import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by pedlar on 9/19/14.
 */
public interface MetaApiService {
    @GET("/module/{module}/")
    public Module getModule(@Path("module") String moduleName);

    @GET("/author/{author}/?join=release")
    public Author getAuthor(@Path("author") String author);

    @GET("/pod/{module}/")
    public Response getPod(@Path("module") String moduleName, @Query("content-type") String contentType);

    @GET("/author/_search/")
    public AuthorSearch searchAuthor(@Query("q") String query, @Query("size") int size, @Query("from") int from);

    @GET("/distribution/_search/")
    public DistributionSearch searchDistribution(@Query("q") String query, @Query("size") int size, @Query("from") int from);

    @GET("/release/_search/")
    public ReleaseSearch searchRelease(@Query("q") String query, @Query("size") int size, @Query("from") int from);

    @GET("/release/{release}/")
    public Release getRelease(@Path("release") String release);

    @GET("/rating/_search/")
    public JsonObject getRating(@Query("q") String query, @Query("size") int size, @Query("from") int from);

}
