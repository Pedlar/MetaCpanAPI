package org.notlocalhost.metacpan;

public class Module extends MetaObject {
    private String pod;
    private String status;
    private String date;
    private String maturity;
    private boolean directory;
    private boolean indexed;
    private String documentation;
    private String version;
    private String release;
    private String path;
    private String description;
    private String distribution;
    private String _abstract;
    
    public Module(
            String author,
            String pod,
            String status,
            String date,
            String maturity,
            boolean directory,
            boolean indexed,
            String documentation,
            String version,
            String release,
            String path,
            String description,
            String distribution,
            String _abstract 
    ) {
        this.author = author;
        this.pod = pod;
        this.status = status;
        this.date = date;
        this.maturity = maturity;
        this.directory = directory;
        this.indexed = indexed;
        this.documentation = documentation;
        this.version = version;
        this.release = release;
        this.path = path;
        this.description = description;
        this.distribution = distribution;
        this._abstract = _abstract;
    }
    
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
    public String getVersion() {
        return this.version;
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
}