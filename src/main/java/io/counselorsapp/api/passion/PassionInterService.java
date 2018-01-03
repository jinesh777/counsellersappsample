package io.counselorsapp.api.passion;
import java.util.List;
import io.counselorsapp.api.passion.Passion;
public interface  PassionInterService {
	List<Passion> getAllPassion();
	Passion getPassionById(int id);
    boolean addPassion(Passion passi);
    void updatePassion(Passion passi);
    void deletePassion(int passid);
}
