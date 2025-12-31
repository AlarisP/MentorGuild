package main.java.com.mentorguild.service;
import main.java.com.mentorguild.model.Mentor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MentorService {
   private final Map<Integer, Mentor> mentorsById = new HashMap<>();

   public void addMentor(Mentor mentor){
       if(mentor == null){
           throw new IllegalArgumentException("Mentor cannot be null");
       }
       if(mentorsById.containsKey(mentor.getIdNumber())){
           throw new IllegalArgumentException("Duplicate mentor ID");
       }
       mentorsById.put(mentor.getIdNumber(), mentor);
   }
   //example of autoboxing
   public Mentor getMentorById(int idNumber){
      return mentorsById.get(idNumber);
   }
   public Collection<Mentor> getAllMentors(){
        return mentorsById.values();
   }

}
