package palchilpalsa.managersystem.repository;

import org.springframework.stereotype.Repository;
import palchilpalsa.managersystem.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public class UserRepository {

    @PersistenceContext
    EntityManager em;

    public User findById(String id) {
        return em.find(User.class, id);
    }
}
