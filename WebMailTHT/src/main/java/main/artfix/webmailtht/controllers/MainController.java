package main.artfix.webmailtht.controllers;

import lombok.RequiredArgsConstructor;
import main.artfix.webmailtht.services.Attack;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final Attack attack;

    @GetMapping("/")
    public String indexPage() {
        return "home";
    }

    @RequestMapping("/mail-attack-send")
    public String mailAttackSend(@RequestParam(value = "usermailforattack") String userMailForAttack,
                                 @RequestParam(value = "countforattack") int countForAttack,
                                 @RequestParam(value = "subjectforattack") String subjectForAttack,
                                 @RequestParam(value = "bodyforattack") String bodyForAttack, Model model) {
        String answer = attack.run(userMailForAttack,countForAttack, subjectForAttack, bodyForAttack);
        model.addAttribute("homemessage", answer);
        return "home";
    }
}
