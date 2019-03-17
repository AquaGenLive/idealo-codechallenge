package de.idealo.robotcontrol.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model) {
        ControlFormElementsContainer controlFormElementsContainer = new ControlFormElementsContainer();
        model.addAttribute("controlFormElements", controlFormElementsContainer);

        return "index";
    }
}
