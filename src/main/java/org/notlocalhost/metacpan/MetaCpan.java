package org.notlocalhost.metacpan;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.notlocalhost.metacpan.models.Author;
import org.notlocalhost.metacpan.models.AuthorSearch;
import org.notlocalhost.metacpan.models.DistributionSearch;
import org.notlocalhost.metacpan.models.Module;
import org.notlocalhost.metacpan.models.Release;
import org.notlocalhost.metacpan.models.ReleaseSearch;
import org.notlocalhost.metacpan.services.MetaApiService;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
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

    public void setLogLevel(RestAdapter.LogLevel logLevel) {
        mRestAdapter.setLogLevel(logLevel);
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
        InputStream is = null;
        String podString = "";
        try {
            is = getApiService().getPod(moduleName, podType.getContentType()).getBody().in();
            java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
            podString = s.hasNext() ? s.next() : "";
        } catch (IOException e) {

        } finally {
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return podString;
    }

    public Release getRelease(String releaseName) {
        return getApiService().getRelease(releaseName);
    }

    public List<Author> searchAuthors(String query, int size, int offset) {
        AuthorSearch authorSearch = getApiService().searchAuthor(query, size, offset);
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

    public List<Release> searchReleases(String query, int size, int offset) {
        ReleaseSearch releaseSearch = getApiService().searchRelease(query, size, offset);
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

    public List<String> searchDistribution(String query, int size, int offset) {
        DistributionSearch authorSearch = getApiService().searchDistribution(query, size, offset);
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

    public float getRating(String distribution) {
        JsonObject jsonObject = getApiService().getRating("distribution:" + distribution, 1, 0);
        if(jsonObject.has("hits")) {
            if(jsonObject.get("hits").getAsJsonObject().get("total").getAsInt() > 0) {
                return Float.parseFloat(jsonObject
                        .get("hits").getAsJsonObject()
                        .get("hits").getAsJsonArray()
                        .get(0).getAsJsonObject()
                        .get("_source").getAsJsonObject()
                        .get("rating").getAsString());
            }
        }
        return 0.0f;
    }
}
