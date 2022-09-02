package string.operation;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author xyqq
 */
public class StringJoinerDemo {

    @Test
    public void testStringJoiner(){
        //StringBuffer 拼接  可以看到这里需要拼接多次"," 。
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.append(",");
        sb.append("world");
        sb.append(",");
        sb.append("Java程序员");
        String str = sb.toString(); //输出: hello,world,Java程序员
        System.out.println("str :" + str);

        //StringJoiner 拼接
        StringJoiner sj = new StringJoiner(",");
        sj.add("hello");
        sj.add("world");
        sj.add("Java程序员");
        String strJ = sj.toString(); //输出: hello,world,Java程序员
        System.out.println("str :" + strJ);

        //demo
        StringJoiner sj1 = new StringJoiner(",").add("hello").add("world").add("Java程序员");
        System.out.println(sj1);

        //前后缀拼接
        StringJoiner sj2 = new StringJoiner(",", "[", "]");
        sj2.add("hello");
        sj2.add("world");
        sj2.add("Java程序员");
        String str2 = sj2.toString();
        System.out.println(str2);

        //空值处理  中间拼接null
        // 如果add null,则会输出null,所以,如果add前需要判空
        StringJoiner sjNull = new StringJoiner(",").add("hello").add(null).add("Java程序员");
        System.out.println(sjNull); //输出: hello,null,Java程序员

        //  输出指定字符串
        // 如果没有拼接的value,会输出emptyValue的值; 如果value有值 是不会输出emptyValue的值
        StringJoiner sj0 = new StringJoiner(",", "[", "]");
        sj0.setEmptyValue("没有值,设置默认空值!!!");
        System.out.println(sj0.toString()); //输出: 没有值,设置默认空值!!!

        StringJoiner sj11 = new StringJoiner(",").add("hello").add("Java程序员");
        sj1.setEmptyValue("没有值,设置默认空值!!!");
        System.out.println(sj11.toString()); //hello,Java程序员


        String sjs = String.join(",", "hello", "Java程序员");
        System.out.println(sjs); //输出: hello,Java程序员
        List<String> strings = new LinkedList<>();
        strings.add("Java");
        strings.add("is");
        strings.add("cool");
        String message = String.join(" ", strings);
        System.out.println(message); //输出: Java is cool
    }
}
