import RuleNgContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;


@Slf4j
@Service("RuleNg4Gift")
@DependsOn("ActionService")
public class RuleNg4Gift extends RuleNgContext<Student> {

    @Autowired
    private ActionService actionService;
  
    private AbstractAction giveGift;

    @PostConstruct
    public void init() {
        giveGift = new ConvertToAction(actionService::giveGift4girlthatgt11);
    }

    private ValueOf<Integer> age = new ValueOf<Integer>("age", Student::getAge);
    private ValueOf<String> gender = new ValueOf<String>("gender", Student::getGender);

    private AbstractCondition ageGt11   = age.gt(11);
    private AbstractCondition whenGirl  = gender.eq("girl");

    private AbstractRunner distributeFoRule;

    public AbstractRunner getRule() {
        if (distributeFoRule != null) {
            return distributeFoRule;
        }
        Node node = node(
                        iF(whenGirl, new ConvertToAction(actionService::giveGift4girl)),
                        iF(and(whenGirl,ageGt11), giveGift)
                );
        distributeFoRule = new Dtree(node);
        log.info(distributeFoRule.toString());
        return distributeFoRule;
    }
}
