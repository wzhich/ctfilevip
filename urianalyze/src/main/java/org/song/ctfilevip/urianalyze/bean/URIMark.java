package org.song.ctfilevip.urianalyze.bean;

public class URIMark {
   private String fileHost;
   private String mark;

   public URIMark(String uri) {
      fileHost = uri.substring(0,uri.indexOf("/file"));
      mark = uri.substring(uri.lastIndexOf("file/")+5);
      System.out.println(uri);
   }

   public String getFileHost() {
      return fileHost;
   }

   public void setFileHost(String fileHost) {
      this.fileHost = fileHost;
   }

   public String getMark() {
      return mark;
   }

   public void setMark(String mark) {
      this.mark = mark;
   }

   @Override
   public String toString() {
      return "URIMark{" +
              "fileHost='" + fileHost + '\'' +
              ", mark='" + mark + '\'' +
              '}';
   }
}
