package basic.knowledge.stephen.java8.lambda_java8;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//for customized filtration
public class FilterPredicateTest {

    public static void FilterPredicateTest(List<String> languages, Predicate<String> condition) {
        languages.stream().filter(x -> condition.test(x)).forEach(x -> System.out.println(x + " "));
    }

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Python", "scala", "Shell", "R");
        System.out.println("Language starts with J: ");
        FilterPredicateTest(languages, x -> x.startsWith("J"));
        System.out.println("\nLanguage ends with a: ");
        FilterPredicateTest(languages, x -> x.endsWith("a"));
        System.out.println("\nAll languages: ");
        FilterPredicateTest(languages, x -> true);
        System.out.println("\nNo languages: ");
        FilterPredicateTest(languages, x -> false);
        System.out.println("\nLanguage length bigger three: ");
        FilterPredicateTest(languages, x -> x.length() > 4);
    }

}