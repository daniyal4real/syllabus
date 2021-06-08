package kz.syllabus.repository;


import kz.syllabus.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {


    @Query(value = "SELECT name FROM disciplines", nativeQuery = true)
    List<Discipline> getSyllabusNames();
}
