package de.idealo.robotcontrol;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotControlRestController {

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        return "Robot Control";
    }
}
