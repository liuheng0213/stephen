package basic.knowledge.stephen.java8.lambda_java8.loopReplacement;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FirstArticleSearch {
    private List<Article> articles = new ArrayList<>();


    //old
    public Article getOldFirstJavaArticle() {
        Article article1 = new Article("java", "cooper", Arrays.asList("8", "java"));
        Article article2 = new Article("python", "cooper", Arrays.asList("9", "python"));
        Article article3 = new Article("c", "cooper", Arrays.asList("10", "c"));
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        for (Article article : articles) {
            if (article.getTags().contains("java")) {
                return article;
            }
        }

        return null;
    }

    //new method
    public Optional<Article> getNewFirstJavaArticle() {
        return articles.stream()
                .filter(article -> article.getTags().contains("java"))
                .findFirst();
    }


    @Test
    public void testGetFirstJavaArticle(){
        //Article article = getOldFirstJavaArticle();
        Optional<Article> newFirstJavaArticle = getNewFirstJavaArticle();
        System.out.println(newFirstJavaArticle);
    }
}
