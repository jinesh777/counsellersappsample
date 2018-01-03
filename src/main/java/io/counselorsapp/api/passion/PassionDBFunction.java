package io.counselorsapp.api.passion;
import io.counselorsapp.api.passion.Passion;
import java.util.List;
public interface  PassionDBFunction {
	  List<Passion> getAllpassion();
	  Passion getpassionById(int id);
	  void  addPassion(Passion passion);
	  void updatePassion(Passion passion);
	  void deletePassion(int id);
	  boolean passionExist(String name, String description);
}