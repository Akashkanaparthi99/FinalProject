package com.freelance.repository;


import com.freelance.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IProjectRepository extends JpaRepository<Projects,Integer> {

    /**
     *
     * @param projectName
     * @return single project object
     */
    Projects findByProjectNameStartingWith(String projectName);

    /**
     *
     * @param budget
     * @return list of Project's
     */
    List<Projects> findByBudget(double budget);

    /**
     *
     * @param duration
     * @return list of Project's
     */
    List<Projects> findByDuration(String duration);

    /**
     *
     * @param projectCategory
     * @return list of Project's
     */
    List<Projects> findByProjectCategory(String projectCategory);

    /**
     *
     * @param duration
     * @param payPerHour
     * @return list of Project's
     */
    @Query("from Projects p inner join p.bid b where p.duration = ?1 and b.payPerHour = ?2")
    List<Projects> findByDurationAndPayPerHour(String duration,String payPerHour);


}
