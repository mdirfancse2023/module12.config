package june.module1homework.classes;

import org.springframework.stereotype.Component;

@Component
public class ChocolateFrosting implements Frosting{
    @Override
    public String getFrostingType() {
        return "ChocolateFrosting";
    }
}
