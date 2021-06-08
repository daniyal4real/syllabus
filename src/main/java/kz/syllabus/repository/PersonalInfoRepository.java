package kz.syllabus.repository;

import kz.syllabus.entity.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {

    @Transactional
    @Modifying
    @Query(value="INSERT INTO personal_info(id, user_id, sname, name, mname, academic_degree, academic_rank, position_id, email, phone, description)" +
            " VALUES(:id, :user_id, :sname, :name, :mname, :academic_degree, :academic_rank, :position_id, :email, :phone, :description)", nativeQuery = true)
    void createPersonalInfo(@Param("id") Integer id, @Param("user_id") Integer userId, @Param("sname") String surname,
                                         @Param("name") String name, @Param("mname") String middleName,
                                         @Param("academic_degree") String academicDegree, @Param("academic_rank") String academicRank,
                                         @Param("position_id") Integer positionId, @Param("email") String email,
                                         @Param("phone") String phone, @Param("description") String description);



}
