package org.notlocalhost.metacpan;

public class Main {
    public static void main(String[] args) {
        System.out.println(MetaCpan.instance().getModule("Sys::RunAlone::User").toString());
        System.out.println(MetaCpan.instance().getAuthor(MetaCpan.instance().getModule("Sys::RunAlone::User").getAuthorName()).toString());
        System.out.println(MetaCpan.instance().searchAuthors("Pedlar"));
        System.out.println(MetaCpan.instance().searchDistribution("Sys-RunAlone-User"));
        System.out.println(MetaCpan.instance().getRelease("Sys-RunAlone-User"));
        System.out.println(MetaCpan.instance().searchReleases("Sys-RunAlone-User"));
    }
}