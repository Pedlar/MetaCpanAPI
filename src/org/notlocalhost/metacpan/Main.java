package org.notlocalhost.metacpan;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(API.fetchModule("Sys::RunAlone::User").getAuthorName());
            System.out.println(API.fetchAuthor(API.fetchModule("Sys::RunAlone::User").getAuthorName()).getDir());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return;
    }
}