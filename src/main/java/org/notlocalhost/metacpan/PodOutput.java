package org.notlocalhost.metacpan;

/**
 * Created by pedlar on 9/20/14.
 */
public enum PodOutput {
    HTML("text/html"), TEXT("text/plain"), XPOD("text/x-pod"), MARKDOWN("text/x-markdown");

    private String contentType;
    private PodOutput(String contentType) {
        this.contentType = contentType;
    }
    public String getContentType() {
        return this.contentType;
    }
}
