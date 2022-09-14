package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {

    /**
     * java 中文数字排序_JAVA实现对包含数字、字母、中文的字符串按首字母排序
     * @param args
     */
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(23, 100,"阿里azj001"));
        students.add(new Student(27, 98,"腾讯bzj002"));
        students.add(new Student(29, 99,"百度dzj003"));
        students.add(new Student(29, 98,"华为czj004"));
        students.add(new Student(22, 89,"择天ezj005"));

        students.add(new Student(22, 89,"a择天ezj005"));
        students.add(new Student(22, 89,"A择天ezj005"));

        students.add(new Student(22, 89,"8择天ezj005"));
        students.add(new Student(22, 89,"0择天ezj005"));

        students.add(new Student(22, 89,"z择天ezj005"));

        students.add(new Student(22, 89,"_z择天ezj005"));
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                Student newo1 = new Student();
                newo1.setName(PinyinUtils.ToPinyinAndGetFirstChar(o1.getName()));
                Student newo2 = new Student();
                newo2.setName(PinyinUtils.ToPinyinAndGetFirstChar(o2.getName()));
                int i = newo1.getName().substring(0, 1).compareTo(newo2.getName().substring(0, 1));
                return i;
            }
        });
        for(Student stu : students){
            System.out.println("score:" + stu.getScore() + ":age" + stu.getAge()+":name:"+stu.getName());
        }
    }
}
