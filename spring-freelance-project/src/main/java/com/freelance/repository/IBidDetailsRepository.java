package com.freelance.repository;

import com.freelance.model.BidDetailsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBidDetailsRepository extends JpaRepository<BidDetailsView,Integer> {
    /**
     *
     * @param bidId
     * @return Bid Details View
     */
    @Query(value = "select * from bid_details_view where bid_id = ?1",nativeQuery = true)
    BidDetailsView getBidDetails(int bidId);
}
