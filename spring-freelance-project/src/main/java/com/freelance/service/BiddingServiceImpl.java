package com.freelance.service;

import com.freelance.exceptions.FreelanceNotFoundException;
import com.freelance.exceptions.NoBiddingException;
import com.freelance.exceptions.ProjectNotFoundException;
import com.freelance.model.BidDetailsView;
import com.freelance.model.Bidding;
import com.freelance.model.Freelance;
import com.freelance.model.Projects;
import com.freelance.repository.IBidDetailsRepository;
import com.freelance.repository.IBiddingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author - Akash
 * @Date - 16-05-2022
 */
@Service
public class BiddingServiceImpl implements IBiddingService{
    private IBiddingRepository biddingRepository;
    private IFreelanceService freelanceService;
    private IProjectService projectService;
    private IBidDetailsRepository bidDetailsRepository;
    @Autowired
    public void setBidDetailsRepository(IBidDetailsRepository bidDetailsRepository) {
        this.bidDetailsRepository = bidDetailsRepository;
    }
    @Autowired
    public void setFreelanceService(IFreelanceService freelanceService) {
        this.freelanceService = freelanceService;
    }
    @Autowired
    public void setProjectService(IProjectService projectService) {
        this.projectService = projectService;
    }
    @Autowired
    public void setBiddingRepository(IBiddingRepository biddingRepository) {
        this.biddingRepository = biddingRepository;
    }

    /**
     *
     * @param bidding
     * @param projectId
     * @param freelanceId
     */
    @Override
    public void addBid(Bidding bidding,int projectId,int freelanceId) {
        Projects projects = projectService.getById(projectId);
        Freelance freelance = freelanceService.getById(freelanceId);
        bidding.setFreelance(freelance);
        bidding.setProjects(projects);
        bidding.setBidDateTime(LocalDateTime.now());
        biddingRepository.save(bidding);
    }

    /**
     *
     * @param bidId
     */
    @Override
    public void deleteBid(int bidId) {
        biddingRepository.findById(bidId);
    }

    /**
     *
     * @param bidId
     * @return bid details view
     * @throws NoBiddingException
     */
    @Override
    public BidDetailsView getById(int bidId) throws NoBiddingException {
        BidDetailsView bidDetailsView = bidDetailsRepository.getBidDetails(bidId);
        if (bidDetailsView == null)
            throw new NoBiddingException("Invalid Bidding Id");
        return bidDetailsView;
    }

    /**
     *
     * @param projectId
     * @return list of bidding's in the single projects
     * @throws ProjectNotFoundException
     * @throws NoBiddingException
     */
    @Override
    public List<Bidding> getByProjectId(int projectId) throws ProjectNotFoundException ,NoBiddingException{
        Projects project = projectService.getById(projectId);
        if (project == null)
            throw new ProjectNotFoundException("Invalid Project Id");

        List<Bidding> biddings = biddingRepository.getByProjectId(projectId);
        if (biddings.isEmpty())
            throw new NoBiddingException("No Bidding's found for the project");
        return biddings;
    }

    /**
     *
     * @param freelanceId
     * @return list of bidding's done by freelancer
     * @throws FreelanceNotFoundException
     * @throws NoBiddingException
     */
    @Override
    public List<Bidding> getByFreelanceId(int freelanceId) throws FreelanceNotFoundException,NoBiddingException {
        Freelance freelance = freelanceService.getById(freelanceId);
        if (freelance == null)
            throw new FreelanceNotFoundException("Invalid Freelance Id");
        List<Bidding> biddings = biddingRepository.getByFreelanceId(freelanceId);
        if (biddings.isEmpty())
            throw new NoBiddingException("No Bidding's found for the Freelancer");
        return biddings;
    }

    /**
     *
     * @param bidDateTime
     * @param projectId
     * @return list of bidding's which are new
     * @throws NoBiddingException
     * @throws ProjectNotFoundException
     */
    @Override
    public List<Bidding> getByNewBid(LocalDateTime bidDateTime, int projectId) throws NoBiddingException , ProjectNotFoundException{
        Projects project = projectService.getById(projectId);
        if (project == null)
            throw new ProjectNotFoundException("Invalid Project Id");

        List<Bidding> biddings = biddingRepository.getByNewBid(bidDateTime,projectId);
        if (biddings.isEmpty())
            throw new NoBiddingException("No Bidding's found for the project");
        return biddings;
    }

}
