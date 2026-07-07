package june.module1homework.classes;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker{
    private final Frosting frosting;
    private final Syrup syrup;
    public CakeBaker(@Qualifier("chocolateFrosting") Frosting frosting, @Qualifier("strawberrySyrup") Syrup syrup){
        this.frosting = frosting;
        this.syrup = syrup;
    }
    public void bakeCake(){
        System.out.print("Cake bake with "+frosting.getFrostingType()+" and "+syrup.getSyrupType());
    }
}
