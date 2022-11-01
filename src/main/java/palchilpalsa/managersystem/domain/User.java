package palchilpalsa.managersystem.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
@Getter @Setter
public class User {
    @Id
    private String id;
    private String pw;
}
