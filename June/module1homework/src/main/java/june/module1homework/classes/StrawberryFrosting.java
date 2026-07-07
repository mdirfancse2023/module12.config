package june.module1homework.classes;

import org.springframework.stereotype.Component;

@Component
public class StrawberryFrosting implements Frosting{
    @Override
    public String getFrostingType() {
        return "StrawberryFrosting";
    }
}
