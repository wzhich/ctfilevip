import org.junit.Test;
import org.song.ctfilevip.urianalyze.URIAnalyze;
import org.song.ctfilevip.urianalyze.bean.LinkInfo;
import org.song.ctfilevip.urianalyze.bean.URIMark;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.util.Date;

public class TestApplication {
    @Test
    public void testA() throws URISyntaxException, IOException {
        String pubcookie = "VTEOOVdiAWYDNVEwUDACYQBbADJSDgFlAmNVPlVtVmQEYwQ0ADxSNlQRUXRUcgJ3VWQHaAI6VApWSlFrUW5QYVUyDjZXaQFlAzdRK1AOAmoAYwA4UjUBZAJjVTdVb1ZnBBIEdAB9UilUMlFqVG4CUFU2BzICblQyVjJRNlFiUGJVOg4_V1IBYAM-UT1QMAJoAGIAMlI1AW4CMVVjVWdWNAQ3BGEAb1IzVDNRMVRnAmhVNwc0AjFUYVYwUWdRPVA2VWIOPldv";
        String uri = "https://webapi.ctfile.com/getfile.php?f=16266733-301590400";
        URIAnalyze uriAnalyze = new URIAnalyze(pubcookie);
        LinkInfo linkInfo = uriAnalyze.analyze(new URIMark(uri));
        System.out.println(linkInfo);
    }
}