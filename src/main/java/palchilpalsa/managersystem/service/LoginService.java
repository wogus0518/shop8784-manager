package palchilpalsa.managersystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import palchilpalsa.managersystem.domain.User;
import palchilpalsa.managersystem.repository.UserRepository;
import palchilpalsa.managersystem.web.dto.user.LoginDto;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public User login(LoginDto loginDto) {
        try {
            User findUser = userRepository.findById(loginDto.getId());
            if (Objects.equals(findUser.getPw(), loginDto.getPw())) {
                return findUser;
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            return null;
        }
    }
}
