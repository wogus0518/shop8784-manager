package palchilpalsa.managersystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import palchilpalsa.managersystem.domain.User;
import palchilpalsa.managersystem.web.argumentresolver.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping
public class HomeController {

    @GetMapping
    public String home(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session == null){
            return "home/home";
        }
        return "home/loginHome";
    }
}
