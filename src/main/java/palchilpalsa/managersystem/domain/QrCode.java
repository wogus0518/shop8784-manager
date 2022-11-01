package palchilpalsa.managersystem.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QRCODE")
@Getter @Setter
public class QrCode {

    public QrCode() {
    }

    public QrCode(Long id, String base64) {
        this.id = id;
        this.base64 = base64;
    }

    @Id
    private Long id;
    @Column(length = 10000)
    private String base64;
}
