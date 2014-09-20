package org.notlocalhost.metacpan;

public class Author extends MetaObject {
    private String country;
    private String website; 
    private String gravatar_url; 
    private String dir;
    private String email; 
    private String city;
    private String pauseid;
    
    public Author(String country, 
                  String website, 
                  String gravatar_url, 
                  String name, 
                  String dir, 
                  String email, 
                  String city, 
                  String pauseid) {
        this.country = country;
        this.website = website;
        this.gravatar_url = gravatar_url;
        this.name = name;
        this.dir = dir;
        this.email = email;
        this.city = city;
        this.pauseid = pauseid;
    }
    
    public String getCountry() {
        return this.country;
    }
    public String getWebsite() {
        return this.website;
    }
    public String getGravatarUrl() {
        return this.gravatar_url;
    }
    public String getName() {
        return this.name;
    }
    public String getDir() {
        return this.dir;
    }
    public String getEmail() {
        return this.email;
    }
    public String getCity() {
        return this.city;
    }
    public String getPauseId() {
        return this.pauseid;
    }
}