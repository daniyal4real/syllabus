package kz.syllabus.service;


import kz.syllabus.entity.PersonalInfo;
import kz.syllabus.repository.PersonalInfoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonalInfoService {

    private final PersonalInfoRepository personalInfoRepository;

    public void createPersonalInfo(PersonalInfo personalInfo) {
        Integer id = personalInfo.getId();
        Integer userId = personalInfo.getUserId();
        String surname = personalInfo.getSname();
        String name = personalInfo.getName();
        String middleName = personalInfo.getMname();
        String academicDegree = personalInfo.getAcademicDegree();
        String academicRank = personalInfo.getAcademicRank();
        Integer positionId = personalInfo.getPositionId();
        String email = personalInfo.getEmail();
        String phone = personalInfo.getPhone();
        String description = personalInfo.getDescription();
        personalInfoRepository.createPersonalInfo(id, userId, surname, name, middleName,
                academicDegree, academicRank, positionId, email, phone, description);
    }


    public ResponseEntity<?> findAll(){
        System.out.println(personalInfoRepository.findAll());
        return ResponseEntity.ok(personalInfoRepository.findAll());
    }
}
