package palchilpalsa.managersystem.web.dto.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDto {
    @NotBlank
    private String id;
    @NotBlank
    private String pw;
}
