package string.operation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String 字符串操作demo
 */
public class StringOperationDemo {
    public static void main(String[] args) {

        String str = "aabbbaaabbbaaabbbcccddduuuiiiieeerrrrccczzz";
        //获取 a 在 str 中第三次出现位置
        int index = getIndexOf(str, "a", 3);
        System.out.println("a 在 str 中第三次出现位置:"+index);

        //获取a 在str中出现的次数
        Integer count = getCount(str, "a");
        System.out.println("a 在 str 中出现次数:"+count);

    }

    /**
     * @param data 指定字符串
     * @param str  需要定位的特殊字符或者字符串
     * @param num  第n次出现
     * @return 第n次出现的位置索引
     */
    private static int getIndexOf(String data, String str, int num) {
        Pattern pattern = Pattern.compile(str);
        Matcher findMatcher = pattern.matcher(data);
        //标记遍历字符串的位置
        int indexNum = 0;
        while (findMatcher.find()) {
            indexNum++;
            if (indexNum == num) {
                break;
            }
        }
        return findMatcher.start();
    }


    /**
     * 获取字符串出现的次数
     *
     * @param str
     * @param searchChar
     * @return
     */
    private static Integer getCount(String str, String searchChar) {
        int origialLength = str.length();
        str = str.replace(searchChar, "");
        int newLength = str.length();
        return (origialLength - newLength) / searchChar.length();
    }
}
