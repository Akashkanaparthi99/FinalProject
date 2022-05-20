package com.freelance.service;

import com.freelance.exceptions.FreelanceNotFoundException;
import com.freelance.exceptions.NoBiddingException;
import com.freelance.exceptions.ProjectNotFoundException;
import com.freelance.model.BidDetailsView;
import com.freelance.model.Bidding;

import java.time.LocalDateTime;
import java.util.List;

public interface IBiddingService {
    void addBid(Bidding bidding,int projectId,int freelanceId);
    void deleteBid(int bidId);
    BidDetailsView getById(int bidId) throws NoBiddingException;

    List<Bidding> getByProjectId(int projectId) throws ProjectNotFoundException,NoBiddingException;
    List<Bidding> getByFreelanceId(int freelanceId) throws FreelanceNotFoundException,NoBiddingException;
    List<Bidding> getByNewBid(LocalDateTime bidDateTime, int projectId) throws NoBiddingException, ProjectNotFoundException;
}
