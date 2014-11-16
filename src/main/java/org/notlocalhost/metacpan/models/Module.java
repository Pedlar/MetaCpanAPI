package org.notlocalhost.metacpan.models;

import com.google.gson.annotations.SerializedName;

import org.notlocalhost.metacpan.models.MetaObject;

import java.io.Serializable;

public final class Module extends MetaObject implements Serializable {
    private String pod;
    private String status;
    private String date;
    private String maturity;
    private boolean directory;
    private boolean indexed;
    private String documentation;
    private String version;
    private float version_numified;

    private String release;
    private String path;
    private String description;
    private String distribution;

    @SerializedName("abstract")
    private String _abstract;
    
    public String getAuthorName() {
        return this.author;
    }
    public String getPod() {
        return this.pod;
    }
    public String getStatus() {
        return this.status;
    }
    public String getDate() {
        return this.date;
    }
    public String getMaturity() {
        return this.maturity;
    }
    public boolean getDirectory() {
        return this.directory;
    }
    public boolean getIndexed() {
        return this.indexed;
    }
    public String getDocumentation() {
        return this.documentation;
    }
    public String getVersionString() {
        return this.version;
    }
    public float getVersionNumber() {
        return this.version_numified;
    }
    public String getReleaseName() {
        return this.release;
    }
    public String getPath() {
        return this.path;
    }
    public String getDescription() {
        return this.description;
    }
    public String getDistributionName() {
        return this.distribution;
    }
    public String getAbstract() {
        return this._abstract;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Module module = (Module) o;

        if (directory != module.directory) return false;
        if (indexed != module.indexed) return false;
        if (Float.compare(module.version_numified, version_numified) != 0) return false;
        if (_abstract != null ? !_abstract.equals(module._abstract) : module._abstract != null)
            return false;
        if (date != null ? !date.equals(module.date) : module.date != null) return false;
        if (description != null ? !description.equals(module.description) : module.description != null)
            return false;
        if (distribution != null ? !distribution.equals(module.distribution) : module.distribution != null)
            return false;
        if (documentation != null ? !documentation.equals(module.documentation) : module.documentation != null)
            return false;
        if (maturity != null ? !maturity.equals(module.maturity) : module.maturity != null)
            return false;
        if (path != null ? !path.equals(module.path) : module.path != null) return false;
        if (pod != null ? !pod.equals(module.pod) : module.pod != null) return false;
        if (release != null ? !release.equals(module.release) : module.release != null)
            return false;
        if (status != null ? !status.equals(module.status) : module.status != null) return false;
        if (version != null ? !version.equals(module.version) : module.version != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pod != null ? pod.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (maturity != null ? maturity.hashCode() : 0);
        result = 31 * result + (directory ? 1 : 0);
        result = 31 * result + (indexed ? 1 : 0);
        result = 31 * result + (documentation != null ? documentation.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (version_numified != +0.0f ? Float.floatToIntBits(version_numified) : 0);
        result = 31 * result + (release != null ? release.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (distribution != null ? distribution.hashCode() : 0);
        result = 31 * result + (_abstract != null ? _abstract.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        return "Module{" +
                "pod='" + pod + '\'' +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", maturity='" + maturity + '\'' +
                ", directory=" + directory +
                ", indexed=" + indexed +
                ", documentation='" + documentation + '\'' +
                ", version='" + version + '\'' +
                ", version_numified=" + version_numified +
                ", release='" + release + '\'' +
                ", path='" + path + '\'' +
                ", description='" + description + '\'' +
                ", distribution='" + distribution + '\'' +
                ", _abstract='" + _abstract + '\'' +
                '}';
    }
}