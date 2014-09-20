package org.notlocalhost.metacpan;

import com.google.gson.Gson;

import org.notlocalhost.metacpan.models.Author;
import org.notlocalhost.metacpan.models.AuthorSearch;
import org.notlocalhost.metacpan.models.DistributionSearch;
import org.notlocalhost.metacpan.models.Module;
import org.notlocalhost.metacpan.models.Release;
import org.notlocalhost.metacpan.models.ReleaseSearch;
import org.notlocalhost.metacpan.services.MetaApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by pedlar on 9/19/14.
 */
public final class MetaCpan {
    private static MetaCpan mInstance;
    private RestAdapter mRestAdapter;

    private MetaCpan() {
        mRestAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.metacpan.org/v0")
                .setConverter(new GsonConverter(new Gson()))
                .build();
    }

    public static MetaCpan instance() {
        if(mInstance == null) {
            mInstance = new MetaCpan();
        }
        return mInstance;
    }

    private MetaApiService getApiService() {
        return mRestAdapter.create(MetaApiService.class);
    }

    public Module getModule(String moduleName) {
        return getApiService().getModule(moduleName);
    }

    public Author getAuthor(String authorName) {
        return getApiService().getAuthor(authorName);
    }

    public String getPod(String moduleName) {
        return getPod(moduleName, PodOutput.HTML);
    }

    public String getPod(String moduleName, PodOutput podType) {
        return getApiService().getPod(moduleName, podType.getContentType());
    }

    public Release getRelease(String releaseName) {
        return getApiService().getRelease(releaseName);
    }

    public List<Author> searchAuthors(String query) {
        AuthorSearch authorSearch = getApiService().searchAuthor(query);
        if(authorSearch != null) {
            AuthorSearch.AuthorHits hits = authorSearch.hits;
            if(hits != null) {
                if(hits.hits != null) {
                    List<Author> authors = new ArrayList<Author>();
                    for(AuthorSearch.AuthorHitsWrapper hit : hits.hits) {
                        authors.add(hit.author);
                    }
                    return authors;
                }
            }
        }
        return null;
    }

    public List<Release> searchReleases(String query) {
        ReleaseSearch releaseSearch = getApiService().searchRelease(query);
        if(releaseSearch != null) {
            ReleaseSearch.ReleaseHits hits = releaseSearch.hits;
            if(hits != null) {
                if(hits.hits != null) {
                    List<Release> releases = new ArrayList<Release>();
                    for(ReleaseSearch.ReleaseHitsWrapper hit : hits.hits) {
                        releases.add(hit.release);
                    }
                    return releases;
                }
            }
        }
        return null;
    }

    public List<String> searchDistribution(String query) {
        DistributionSearch authorSearch = getApiService().searchDistribution(query);
        if(authorSearch != null) {
            DistributionSearch.DistributionHits hits = authorSearch.hits;
            if(hits != null) {
                if(hits.hits != null) {
                    List<String> dists = new ArrayList<String>();
                    for(DistributionSearch.DistributionHitsWrapper hit : hits.hits) {
                        if(hit._source != null) {
                            dists.add(hit._source.name);
                        }
                    }
                    return dists;
                }
            }
        }
        return null;
    }
}
