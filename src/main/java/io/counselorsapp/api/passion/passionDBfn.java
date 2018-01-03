package io.counselorsapp.api.passion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import io.counselorsapp.api.passion.Passion;
@Transactional
@Repository

public class passionDBfn implements PassionDBFunction {
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<Passion> getAllpassion() {
		String hql = "FROM Passion as passt ORDER BY passt.id";
		return (List<Passion>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Passion getpassionById(int id) {
		return entityManager.find(Passion.class, id);
	}

	@Override
	public void addPassion(Passion passion) {
		// TODO Auto-generated method stub
		entityManager.merge(passion);
	}

	@Override
	public void updatePassion(Passion passion) {
		// TODO Auto-generated method stub
		Passion artcl = getpassionById(passion.getId());
		artcl.setName(passion.getName());
		artcl.setDescription(passion.getDescription());
		entityManager.flush();
	}

	@Override
	public void deletePassion(int id) {
		// TODO Auto-generated method stub
		entityManager.remove(getpassionById(id));
	}

	@Override
	public boolean passionExist(String name, String description) {
		String hql = "FROM Passion as atcl WHERE atcl.name = ? and atcl.description = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name)
		              .setParameter(2, description).getResultList().size();
		return count > 0 ? true : false;
	}	
}
