package kz.syllabus.service;


import kz.syllabus.entity.Discipline;
import kz.syllabus.repository.DisciplineRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DisciplineService {

    private final DisciplineRepository disciplineRepository;

    public List<Discipline> getSyllabusNames() {
        return disciplineRepository.getSyllabusNames();
    }
}
