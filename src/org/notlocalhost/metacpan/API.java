package org.notlocalhost.metacpan;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class API {
    private static HttpClient httpClient;
    private static String baseUrl = "http://api.metacpan.org/v0";
    
    public API() {
        httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter("http.protocol.single-cookie-header", true);
        httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
    }
    
    public static void initClient() {
        httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter("http.protocol.single-cookie-header", true);
        httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
    }
    
    public static Module fetchModule(String module) throws ClientProtocolException, IOException, JSONException {
        initClient();
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        HttpGet httpGet = new HttpGet(baseUrl + "/module/" + module);
        HttpResponse response = httpClient.execute(httpGet);
        
        response.getEntity().writeTo(byteStream);
        JSONObject body = new JSONObject(byteStream.toString());
        if(body.has("code") && body.getInt("code") == 404) {
            return null;
        }
        return new Module(body.getString ("author"),
                          body.getString ("pod"),
                          body.getString ("status"),
                          body.getString ("date"),
                          body.getString ("maturity"),
                          body.getBoolean("directory"),
                          body.getBoolean("indexed"),
                          body.getString ("documentation"),
                          body.getString ("version"),
                          body.getString ("release"),
                          body.getString ("path"),
                          body.getString ("description"),
                          body.getString ("distribution"),
                          body.getString ("abstract")
                         );
    }
}