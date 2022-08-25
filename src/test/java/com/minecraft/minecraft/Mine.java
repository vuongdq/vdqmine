package com.minecraft.minecraft;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Mine {
    public static void main(String[] args) throws IOException {
        String baseUrl ="https://www.9minecraft.net/crossroads-mc-mod/";
        Document doc = Jsoup.connect(baseUrl).get();
        String title = doc.title();
        System.out.println(title);
        String title2 = doc.selectFirst("h1").text();
        System.out.println(title2);
        Element content = doc.getElementById("content").getElementsByClass("postContent").first();

        System.out.println("Content ------: "+content.text());
        Element mineBanner = content.selectFirst(".mine-banner");
        Element eztoccontainer = content.selectFirst("#ez-toc-container");
        System.out.println("eztoccontainer:"+eztoccontainer.text());
        Element shareElement = content.selectFirst(".heateor_sss_sharing_container");
        System.out.println("mine ----"+mineBanner.toString());

        content.selectFirst(".mine-banner").remove();
        content.selectFirst("#ez-toc-container").remove();
        content.selectFirst(".heateor_sss_sharing_container").remove();
        content.select(".heateorSssClear").remove();
        System.out.println("After remove"+content);
        Elements imgElements = doc.getElementsByTag("img");
        int i =0;
        for (Element imgElement: imgElements) {
            i++;
            System.out.println("img: "+i+ ":"+imgElement.attr("data-srcset"));

        }

        Elements blockquoteElements = (Elements) content.getElementsByTag("blockquote");
        for (Element blockquoteElement :blockquoteElements){
            Elements links = blockquoteElement.getElementsByTag("a");

            for (Element link: links) {
                if(link.attr("href").contains("act=dl&id=")){
                    System.out.println(link.text());
                    String linkDownload = link.attr("href");
                    System.out.println(linkDownload);

                    Document downloadPage = Jsoup.connect(linkDownload).get();
                    String linkDownloadPage = downloadPage.getElementsByTag("a").attr("href");
                    System.out.println(linkDownloadPage);
                }else {
                    String linkDownload = link.attr("href").replace("9minecraft.net","9minecraft.org");
                    System.out.println(linkDownload);
                }
                break;
            }

        }

//        System.out.println(blockquoteElements.text());
//        System.out.println(blockquoteElements.selectFirst("a").attr("href"));

    }


}
