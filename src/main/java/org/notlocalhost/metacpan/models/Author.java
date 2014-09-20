package org.notlocalhost.metacpan.models;

import java.util.ArrayList;
import java.util.List;

public final class Author extends MetaObject {
    private String country;
    private List<String> website = new ArrayList<String>();
    private String gravatar_url; 
    private String dir;
    private List<String> email = new ArrayList<String>();
    private String city;
    private String pauseid;
    
    public String getCountry() {
        return this.country;
    }
    public String getWebsite() {
        return this.website.get(0);
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
        return this.email.get(0);
    }
    public String getCity() {
        return this.city;
    }
    public String getPauseId() {
        return this.pauseid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (city != null ? !city.equals(author.city) : author.city != null) return false;
        if (country != null ? !country.equals(author.country) : author.country != null)
            return false;
        if (dir != null ? !dir.equals(author.dir) : author.dir != null) return false;
        if (email != null ? !email.equals(author.email) : author.email != null) return false;
        if (gravatar_url != null ? !gravatar_url.equals(author.gravatar_url) : author.gravatar_url != null)
            return false;
        if (pauseid != null ? !pauseid.equals(author.pauseid) : author.pauseid != null)
            return false;
        if (website != null ? !website.equals(author.website) : author.website != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = country != null ? country.hashCode() : 0;
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (gravatar_url != null ? gravatar_url.hashCode() : 0);
        result = 31 * result + (dir != null ? dir.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (pauseid != null ? pauseid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "country='" + country + '\'' +
                ", website=" + website +
                ", gravatar_url='" + gravatar_url + '\'' +
                ", dir='" + dir + '\'' +
                ", email=" + email +
                ", city='" + city + '\'' +
                ", pauseid='" + pauseid + '\'' +
                '}';
    }
}