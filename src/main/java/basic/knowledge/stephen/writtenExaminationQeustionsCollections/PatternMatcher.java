package basic.knowledge.stephen.writtenExaminationQeustionsCollections;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
    public static void main(String[] args) {
        Pattern compile = Pattern.compile("a.*?b");//正则表达式的编译表示形式
        Matcher matcher = compile.matcher("b===a===b===");//获取匹配器
        while(matcher.find(1)){
            System.out.println(matcher.group());
        }
    }
}
