package kz.syllabus.controllers.teachers;


import kz.syllabus.entity.Discipline;
import kz.syllabus.exceptions.ExceptionHandling;
import kz.syllabus.service.DisciplineService;
import kz.syllabus.service.PersonalInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class TeacherController extends ExceptionHandling {

    private final DisciplineService disciplineService;

    @PostMapping("")
    public ResponseEntity<?> profile(){
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/api/teacher/syllabuses")
    public ResponseEntity<?> getAllSyllabusesTeacher(){
        return ResponseEntity.ok(disciplineService.getSyllabusNames());
    }

}
