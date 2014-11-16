package org.notlocalhost.metacpan.models;

import com.google.gson.annotations.SerializedName;

import org.notlocalhost.metacpan.MetaCpan;

import java.io.Serializable;
import java.util.List;

/**
 * Created by pedlar on 9/20/14.
 */
public final class Release implements Serializable {
    private String status;
    private String date;
    private String author;
    private String maturity;
    private String id;
    private String download_url;
    private String archive;
    private String version;
    private String name;
    private String distribution;

    @SerializedName("abstract")
    private String _abstract;

    private List<String> provides;

    private float version_numified;

    private boolean authorized;
    private boolean first;

    private List<ReleaseDependency> dependency;

    public final static class ReleaseDependency implements Serializable {
        private String relationship;
        private String phase;
        private String version;
        private float version_numified;
        private String module;

        public String getModule() {
            return module;
        }

        public String getRelationship() {
            return relationship;
        }

        public String getPhase() {
            return phase;
        }

        public String getVersion() {
            return version;
        }

        public float getVersionNumber() {
            return version_numified;
        }

        @Override
        public String toString() {
            return "ReleaseDependency{" +
                    "relationship='" + relationship + '\'' +
                    ", phase='" + phase + '\'' +
                    ", version='" + version + '\'' +
                    ", version_numified=" + version_numified +
                    ", module='" + module + '\'' +
                    '}';
        }
    }


    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }

    public String getMaturity() {
        return maturity;
    }

    public String getId() {
        return id;
    }

    public String getDownloadUrl() {
        return download_url;
    }

    public String getArchive() {
        return archive;
    }

    public String getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public String getDistribution() {
        return distribution;
    }

    public String getAbstract() {
        return _abstract;
    }


    public List<String> getProvides() {
        return provides;
    }

    public float getVersionNumber() {
        return version_numified;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public boolean isFirst() {
        return first;
    }

    public float getRating() {
        return MetaCpan.instance().getRating(getDistribution());
    }

    public List<ReleaseDependency> getDependencies() {
        return dependency;
    }

    @Override
    public String toString() {
        return "Release{" +
                "status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", author='" + author + '\'' +
                ", maturity='" + maturity + '\'' +
                ", id='" + id + '\'' +
                ", download_url='" + download_url + '\'' +
                ", archive='" + archive + '\'' +
                ", version='" + version + '\'' +
                ", name='" + name + '\'' +
                ", distribution='" + distribution + '\'' +
                ", _abstract='" + _abstract + '\'' +
                ", provides=" + provides +
                ", version_numified=" + version_numified +
                ", authorized=" + authorized +
                ", first=" + first +
                ", dependency=" + dependency +
                '}';
    }
}
