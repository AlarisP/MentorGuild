package main.java.com.mentorguild.controller;

import main.java.com.mentorguild.model.Lesson;
import main.java.com.mentorguild.model.Mentor;
import main.java.com.mentorguild.service.LessonService;
import main.java.com.mentorguild.service.MentorService;

//Right now (before Spring), your “controller” is basically: a class that accepts requests (from your main method / menu / later HTTP) and delegates to services.
public class LessonController {
    private final LessonService lessonService;
    private  final MentorService mentorService;
//constructor
    public LessonController(LessonService lessonService, MentorService mentorService){
        this.lessonService = lessonService;
        this.mentorService = mentorService;

    }

//Methods
    public Lesson getLessonById(int lessonId){
        return lessonService.getLessonById(lessonId);
    }

    public void displayLesson(int lessonId){
        Lesson lesson = lessonService.getLessonById(lessonId);
        if(lesson == null){
            System.out.println("Lesson not found");
            return;
        }
        lesson.displayLesson();
    }

    public void createLesson(
            int mentorId,
            String title,
            String topic,
            String content,
            String[] tags,
            int lessonId
    ){
        //making sure mentor exists
        Mentor mentor = mentorService.getMentorById(mentorId);
        if(mentor == null){
            System.out.println("Cannot create lesson, mentor not found.");
            return;
        }
        //create lesson object
        Lesson lesson = new Lesson(mentor, title, topic, content, tags, lessonId);

        //store via service
        lessonService.addLesson(lesson);
        System.out.println("Lesson created " + lessonId);
    }

}
