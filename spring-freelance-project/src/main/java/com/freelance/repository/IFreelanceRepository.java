package com.freelance.repository;

import com.freelance.model.Freelance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFreelanceRepository extends JpaRepository<Freelance , Integer> {
    /**
     *
     * @param noOfProjects
     * @return list of freelancer's
     */
    List<Freelance> findByNoOfProjects(int noOfProjects);

    /**
     *
     * @param freelanceName
     * @return list of freelancer's
     */
    @Query("from Freelance f where f.freelancerName like ?1")
    List<Freelance> findByFreelancerNameStarting(String freelanceName);

    /**
     *
     * @param ratings
     * @return list of freelancer's
     */
    @Query("from Freelance f where f.rating <= ?1")
    List<Freelance> findByRatings(double ratings);

    /**
     *
     * @param category
     * @return list of freelancer's
     */
    @Query("from Freelance f inner join f.category c where c.categoryType = ?1")
    List<Freelance> findByCategory(String category);

    /**
     *
     * @param skill
     * @return list of freelancer's
     */
    @Query("from Freelance f inner join f.skills s where s.skillName = ?1")
    List<Freelance> findBySkill(String skill);

    /**
     *
     * @param category
     * @param rating
     * @return list of freelancer's
     */
    @Query("from Freelance f inner join f.category c where c.categoryType = ?1 and f.rating <= ?2")
    List<Freelance> findByCategoryAndRating(String category,double rating);

    /**
     *
     * @param categoryType
     * @param skillName
     * @return list of freelancer's
     */
    @Query("from Freelance f inner join f.category c inner join f.skills s where c.categoryType=?1 and s.skillName=?2")
    List<Freelance> findByCategoryTypeAndSkillName(String categoryType,String skillName);

    /**
     *
     * @param rating
     * @param skillName
     * @return list of freelancer's
     */
    @Query("from Freelance f inner join f.skills s where f.rating >= ?1 and s.skillName=?2")
    List<Freelance> findByRatingAndSkillName(double rating,String skillName);

    /**
     *
     * @param skillName1
     * @param skillName2
     * @return list of freelancer's
     */
    @Query("from Freelance f inner join f.skills s where s.skillName=?1 and s.skillName=?2")
    List<Freelance> findByTwoSkillsNames(String skillName1,String skillName2);

    /**
     *
     * @param category
     * @param rating
     * @param skill
     * @return list of freelancer's
     */
    @Query("from Freelance f inner join f.category c inner join f.skills s where c.categoryType = ?1 and f.rating >= ?2 and s.skillName = ?3")
    List<Freelance> findByCategoryAndRatingAndSkill(String category,double rating,String skill);
}
