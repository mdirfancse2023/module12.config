package june.module1homework.classes;

import org.springframework.stereotype.Component;

@Component
public class ChocolateSyrup implements Syrup{
    @Override
    public String getSyrupType() {
        return "ChocolateSyrup";
    }
}
