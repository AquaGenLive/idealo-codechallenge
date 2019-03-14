package de.idealo.robotcontrol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RobotControlRestController {

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping
    public String robotMovements() {
        return null;
    }
}
