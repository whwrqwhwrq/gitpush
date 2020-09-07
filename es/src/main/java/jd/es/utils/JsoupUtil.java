package jd.es.utils;

import jd.es.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//解析网页
public class JsoupUtil {
    //爬取京东  的 笔记本  搜索 结果页面
    //https://search.jd.com/Search?keyword=%E7%AC%94%E8%AE%B0%E6%9C%AC
    public static void main(String[] args) throws IOException {
        for (Content lt : JsoupUtil.parseJD("")) {
            System.out.println(lt);
        }
    }

    public static List<Content> parseJD(String keyword) throws IOException {
        String url = "https://search.jd.com/Search?keyword="+keyword;

        //解析网页
        URL Url = new URL(url);
        //Jsoup返回的docunment对象 就是 浏览器 的document对象
        Document document = Jsoup.parse(Url, 30000);
        //可以使用 js里所有方法
        Element j_goodsList = document.getElementById("J_goodsList");
        //获取所有 的  li 标签
        Elements elements = j_goodsList.getElementsByTag("li");
        //用来存储所有商品  的 list
        ArrayList<Content> goodList = new ArrayList<Content>();
        //获取元素中的内容
        for (Element element : elements) {
            //element就是每个li标签
            String img = element.getElementsByTag("img").eq(0).attr("src");
            String price = element.getElementsByClass("p-price").eq(0).text();
            String title = element.getElementsByClass("p-name").eq(0).text();
//            System.out.println("_______________________________________________");
//            System.out.println(img);
//            System.out.println(price);
//            System.out.println(title);
            //创建实体类    封装每个  查出的数据
            Content content = new Content(img,price,title);
            goodList.add(content);
        }
        return goodList;
    }

}
