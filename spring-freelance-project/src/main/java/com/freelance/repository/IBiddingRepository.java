package com.freelance.repository;

import com.freelance.model.Bidding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IBiddingRepository extends JpaRepository<Bidding,Integer> {
    /**
     *
     * @param projectId
     * @return list of bidding's
     */
    @Query("from Bidding b inner join b.projects p where p.projectId = ?1")
    List<Bidding> getByProjectId(int projectId);

    /**
     *
     * @param freelanceId
     * @return list of bidding's
     */
    @Query("from Bidding b inner join b.freelance f where f.freelancerId = ?1")
    List<Bidding> getByFreelanceId(int freelanceId);

    /**
     *
     * @param bidDateTime
     * @param projectId
     * @return list of bidding's
     */
    @Query("from Bidding b inner join b.projects p where b.bidDateTime <= ?1 and p.projectId = ?2")
    List<Bidding> getByNewBid(LocalDateTime bidDateTime,int projectId);
}
