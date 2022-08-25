package com.minecraft.minecraft;
        import com.google.gson.Gson;
        import com.minecraft.minecraft.Model.Post;
        import io.qameta.allure.Links;
        import org.jsoup.Jsoup;
        import org.jsoup.nodes.Document;
        import org.jsoup.nodes.Element;
        import org.jsoup.nodes.TextNode;
        import org.jsoup.select.Elements;

        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

public class Mine2 {
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
        content.select(".heateor_sss_sharing_container").remove();
        content.select(".yasr-auto-insert-visitor").remove();
        content.select("script").remove();
        System.out.println("After remove \n"+content);
        Elements imgElements = content.getElementsByTag("img");
        int i =0;
       List<String> imageData = new ArrayList<>();

        imgElements.forEach(imgElement->{
            if(imgElement.attr("src").contains("http")){
                String img = imgElement.attr("src");
                System.out.println(img);
                imageData.add(img);

                System.out.println("hello-----");

                System.out.println(content.getElementsMatchingText(imgElement.toString()));


            }
        });


        List<String> linkData = new ArrayList<>();
        Elements blockquoteElements = (Elements) content.getElementsByTag("blockquote");
        blockquoteElements.forEach(blockquoteElement->{
            Elements links = blockquoteElement.getElementsByTag("a");
            links.forEach(link->{
                if(link.attr("href").contains("act=dl&id=")){
                    String ldt = link.attr("href");
                    System.out.println(link.attr("href"));
                    linkData.add(ldt);

                }

            });

        });

        // Info
        Post post = new Post();
        post.setTitle(title2);
        post.setContent(content.toString());
        post.setLinkDatas(linkData);
        post.setImageDatas(imageData);

        System.out.println("POST CONTENTS HERE: ");

        Gson gson = new Gson();

        String output = gson.toJson(post);
        System.out.println(output);

    }


}

