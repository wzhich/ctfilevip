package org.song.ctfilevip.uriwebserver;

import org.song.ctfilevip.urianalyze.URIAnalyze;
import org.song.ctfilevip.urianalyze.bean.LinkInfo;
import org.song.ctfilevip.urianalyze.bean.URIMark;
import org.song.ctfilevip.uriwebserver.bena.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class URIWEBServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(URIWEBServerApplication.class, args);
    }

    private URIAnalyze uriAnalyze;
    @Value("${pubcookie}")
    private String pubcookie;

    @GetMapping("/getVipUri")
    public Result getVipUri(String originalURI) {
        if (uriAnalyze == null)
            uriAnalyze = new URIAnalyze(pubcookie);
        LinkInfo analyze;
        Result<LinkInfo> result;
        try {
            URIMark uriMark = new URIMark(originalURI);
            analyze = uriAnalyze.analyze(uriMark);
            if (analyze.getVip_dx_url() == null && analyze.getVip_lt_url() == null && analyze.getVip_yd_url() == null && analyze.getDoubleclick_url() == null)
                result = new Result(500, "没有能成功获取到链接，可能是原始链接是错误到，也可能是服务器出现了错误!", null);
            else if (analyze.getVip_dx_url() == null && analyze.getVip_lt_url() == null && analyze.getVip_yd_url() == null)
                result = new Result(500, "没有能成功获取到高速链接，也可能是服务器出现了错误!", analyze);
            else {
                result = new Result(200, "成功获取到高速链接", analyze);
            }
        } catch (Exception e) {
            result = new Result(500, "没有能成功获取到高速链接,请检查原始链接是否正确", null);
        }
        return result;
    }
}