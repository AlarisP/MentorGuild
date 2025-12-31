package main.java.com.mentorguild.service;
import main.java.com.mentorguild.model.Lesson;
import java.util.ArrayList;
import  java.util.List;


//Gives control over lessons
public class LessonService {

    //this is an example of polymorphism. Same interface, different behavior.
   private final List<Lesson> lessons = new ArrayList<>();

    public void addLesson(Lesson lesson){
    lessons.add(lesson);
    }
    public List<Lesson> getAllLessons(){
        return lessons;
    }
    public Lesson getLessonById(int lessonId){
        for(Lesson lesson: lessons){
        if(lesson.getLessonId() == lessonId){
            return lesson;
        }
        }
        return null;
    }
}
