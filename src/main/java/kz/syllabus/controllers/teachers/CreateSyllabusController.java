package kz.syllabus.controllers.teachers;




import kz.syllabus.entity.DisciplineInfo;
import kz.syllabus.entity.PersonalInfo;
import kz.syllabus.service.DisciplineInfoService;
import kz.syllabus.service.PersonalInfoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CreateSyllabusController {

    private final PersonalInfoService personalInfoService;
    private final DisciplineInfoService disciplineInfoService;

    @PostMapping("/api/create/syllabus")
    public void createSyllabus(@RequestBody PersonalInfo personalInfo) {
        personalInfoService.createPersonalInfo(personalInfo);
    }

    @PostMapping("/api/create/syllabus/disciplineinfo")
    public void createSyllabus(@RequestBody DisciplineInfo disciplineInfo) {
        disciplineInfoService.createDisciplineInfo(disciplineInfo);
    }
}
