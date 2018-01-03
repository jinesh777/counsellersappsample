package io.counselorsapp.api.passion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.counselorsapp.api.passion.PassionDBFunction;
import io.counselorsapp.api.passion.Passion;
@Service
public class PassionService implements PassionInterService{
	@Autowired
	private PassionDBFunction passionDAO;

	@Override
	public List<Passion> getAllPassion() {
		// TODO Auto-generated method stub
		return passionDAO.getAllpassion();
		
	}

	@Override
	public Passion getPassionById(int id) {
		Passion obj = passionDAO.getpassionById(id);
		return obj;
	}

	@Override
	public synchronized  boolean addPassion(Passion passi) {
		// TODO Auto-generated method stub
		if (passionDAO.passionExist(passi.getName(), passi.getDescription())) {
            return false;
        } else {
        	passionDAO.addPassion(passi);
            return true;
        }
		
	}

	@Override
	public void updatePassion(Passion passi) {
		// TODO Auto-generated method stub
		passionDAO.updatePassion(passi);
	}

	@Override
	public void deletePassion(int passid) {
		passionDAO.deletePassion(passid);
		// TODO Auto-generated method stub
		
	}

}
