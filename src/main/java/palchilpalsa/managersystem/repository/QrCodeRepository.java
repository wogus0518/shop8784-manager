package palchilpalsa.managersystem.repository;

import org.springframework.stereotype.Repository;
import palchilpalsa.managersystem.domain.QrCode;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class QrCodeRepository {

    @PersistenceContext
    EntityManager em;

    public void save(QrCode qrCode) {
        em.persist(qrCode);
    }

    public QrCode findById(Long itemId) {
        return em.find(QrCode.class, itemId);
    }
}
