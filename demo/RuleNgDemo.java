import com.clubfactory.ofc.server.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author yuanjingkun
 * @create 2020/6/13 10:34
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RuleNgDemo {

    @Autowired
    RuleNg4Gift ruleNg4Gift;

    @Test
    public void test(){
        Student student = new Student();
        student.setAge(12);
        student.setGender("girl");
        student.setGrade(5);
        student.setClassNum(3);
        // 执行处理
        ruleNg4Gift.getRule().run(student);
    }
}
