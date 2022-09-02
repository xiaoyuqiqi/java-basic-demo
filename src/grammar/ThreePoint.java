package grammar;

import org.junit.Test;

/**
 * @author xyqq
 */
public class ThreePoint {

    /**
     * 测试java中的三个点
     */
    @Test
    public void testThreePoint(){
        this.testJavaGrammar("1","2");
    }

    public void testJavaGrammar(String ... arg){
        for (String s : arg) {
            System.out.println(s);
        }
    }
}
