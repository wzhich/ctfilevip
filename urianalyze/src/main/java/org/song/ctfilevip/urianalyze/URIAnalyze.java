package org.song.ctfilevip.urianalyze;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.GsonBuildConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.song.ctfilevip.urianalyze.bean.LinkInfo;
import org.song.ctfilevip.urianalyze.bean.URIMark;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class URIAnalyze {
    private String pubcookie;
    private CloseableHttpClient httpClient;
    private HttpGet httpGet;
    private Gson gson;

    public URIAnalyze(String pubcookie) {
        this.pubcookie = pubcookie;
    }

    private CloseableHttpClient getHttpClient() {
        if (httpClient == null)
            httpClient = HttpClientBuilder.create().build();

        return httpClient;
    }

    private HttpGet getHttpGet() {
        if (httpGet == null) {
            httpGet = new HttpGet();
            httpGet.setHeader("Cookie", "pubcookie=" + pubcookie);
            httpGet.setHeader("Host", "webapi.ctfile.com");
        }
        return httpGet;
    }

    private Gson getGson() {
        if (gson == null)
            gson = new Gson();
        return gson;
    }

    public LinkInfo analyze(URIMark uriMark) throws URISyntaxException, IOException {
        System.out.println(uriMark);
        HttpGet httpGet = getHttpGet();
        httpGet.setURI(new URI("https://webapi.ctfile.com/getfile.php?f=" + uriMark.getMark()));
        httpGet.setHeader("Origin", uriMark.getFileHost());
        String json = EntityUtils.toString(getHttpClient().execute(httpGet).getEntity());
        LinkInfo linkInfo = getGson().fromJson(json, LinkInfo.class);
        return linkInfo;
    }
}