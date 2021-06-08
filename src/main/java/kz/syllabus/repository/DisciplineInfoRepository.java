package kz.syllabus.repository;

import kz.syllabus.entity.DisciplineInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface DisciplineInfoRepository extends JpaRepository<DisciplineInfo, Long> {

    @Transactional
    @Modifying
    @Query(value="INSERT INTO discipline_info(id, discipline_id, credits, aim, tasks, results, methodology)" +
            " VALUES(:id, :discipline_id, :credits, :aim, :tasks, :results, :methodology)", nativeQuery = true)
    void createDisciplineMethodology(@Param("id") Integer id, @Param("discipline_id") Integer disciplineId, @Param("credits") Integer credits,
                                     @Param("aim") String aim, @Param("tasks") String tasks,
                                     @Param("results") String results, @Param("methodology") String methodology);
}
