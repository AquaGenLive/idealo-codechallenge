package de.idealo.robotcontrol;

import de.idealo.robotcontrol.robot.Robot;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotControlRestController {

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        return "Robot Control";
    }

    @RequestMapping(value = "init", method = RequestMethod.POST)
    public Robot initPosition(Robot robot) {
        return robot;
    }
}
