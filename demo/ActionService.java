import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author yuanjingkun
 * @create 2020/6/13 10:24
 */
@Service("ActionService")
@Slf4j
public class ActionService {


    public void giveGift4girlthatgt11(Student student) {
        log.info("------------------------------");
        log.info("giveGift4girlthatgt11");
        log.info("------------------------------");
    }

    public void giveGift4girl(Student student) {
        log.info("------------------------------");
        log.info("giveGift4girl");
        log.info("------------------------------");
    }
}
