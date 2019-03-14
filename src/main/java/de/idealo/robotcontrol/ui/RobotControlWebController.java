package de.idealo.robotcontrol.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RobotControlWebController {

    @GetMapping
    public String index(Model model) {
        ControlFormElementsContainer controlFormElementsContainer = new ControlFormElementsContainer();
        model.addAttribute("controlFormElements", controlFormElementsContainer);

        return "index";
    }

    @PostMapping("/robotMovements")
    public String robotMovements(@ModelAttribute ControlFormElementsContainer controlFormElements, Model model) {
        model.addAttribute("controlFormElements", controlFormElements);
        return "index";
    }
}
