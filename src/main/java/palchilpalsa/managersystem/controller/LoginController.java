package palchilpalsa.managersystem.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import palchilpalsa.managersystem.domain.User;
import palchilpalsa.managersystem.service.LoginService;
import palchilpalsa.managersystem.web.dto.user.LoginDto;
import palchilpalsa.managersystem.web.session.SessionConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @GetMapping
    public String viewLogin(@ModelAttribute LoginDto loginDto) {
        return "login/login";
    }

    @PostMapping
    public String login(@Validated @ModelAttribute LoginDto loginDto,
                        BindingResult bindingResult,
                        HttpServletRequest request,
                        @RequestParam(defaultValue = "/") String redirectURL) { // 없을 때 뒤에 계속 /null 붙음
        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "login/login";
        }
        User loginUser = loginService.login(loginDto);
        if (loginUser == null) {
            bindingResult.reject("loginFail", "IDとパスワードが一致しません。");
            log.info("errors={}", bindingResult);

            return "login/login";
        }

        //로그인 성공
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.MANAGER, "manager");

        return "redirect:" + redirectURL;
    }
}
