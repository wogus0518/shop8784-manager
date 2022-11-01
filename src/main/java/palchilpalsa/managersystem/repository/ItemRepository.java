package palchilpalsa.managersystem.repository;

import org.springframework.stereotype.Repository;
import palchilpalsa.managersystem.domain.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ItemRepository {

    @PersistenceContext
    EntityManager em;

    public Long save(Item item) {
        em.persist(item);
        return item.getId();
    }

    public Item findById(Long id) {
        return em.find(Item.class, id);
    }
}
