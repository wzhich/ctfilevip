package org.song.ctfilevip.uriwebserver;

import org.song.ctfilevip.urianalyze.URIAnalyze;
import org.song.ctfilevip.urianalyze.bean.LinkInfo;
import org.song.ctfilevip.urianalyze.bean.URIMark;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
@RestController
public class URIWEBServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(URIWEBServerApplication.class, args);
    }

    private URIAnalyze uriAnalyze;
    @Value("${pubcookie}")
    private String pubcookie;

    @PostMapping("/getVipUri")
    public LinkInfo getVipUri(String originalURI) throws IOException, URISyntaxException {
        if (uriAnalyze == null)
            uriAnalyze = new URIAnalyze(pubcookie);
        URIMark uriMark = new URIMark(originalURI);
        LinkInfo analyze = uriAnalyze.analyze(uriMark);
        return analyze;
    }
}