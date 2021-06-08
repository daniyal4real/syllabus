package kz.syllabus.service;

import kz.syllabus.entity.DisciplineInfo;
import kz.syllabus.repository.DisciplineInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DisciplineInfoService {

    private DisciplineInfoRepository disciplineInfoRepository;

    public void createDisciplineInfo(DisciplineInfo disciplineInfo) {
        Integer id = disciplineInfo.getId();
        Integer disciplineId = disciplineInfo.getDisciplineId();
        Integer credits = disciplineInfo.getCredits();
        String aim = disciplineInfo.getAim();
        String tasks = disciplineInfo.getTasks();
        String results = disciplineInfo.getResults();
        String methodology = disciplineInfo.getMethodology();
        disciplineInfoRepository.createDisciplineMethodology(id, disciplineId, credits, aim, tasks, results, methodology);
    }
}
