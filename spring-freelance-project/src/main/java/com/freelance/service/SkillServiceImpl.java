package com.freelance.service;

import com.freelance.model.Skill;
import com.freelance.repository.ISkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author - Akash
 * @date - 17-05-2022
 * @project - E-Freelance-Website
 */
@Service
public class SkillServiceImpl implements ISkillService{
    private ISkillRepository skillRepository;
    @Autowired
    public void setSkillRepository(ISkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    /**
     *
     * @param skill
     */
    @Override
    public void addSkill(Skill skill) {
        skillRepository.save(skill);
    }

    /**
     *
     * @param skill
     */
    @Override
    public void updateSkill(Skill skill) {
        skillRepository.save(skill);
    }

    /**
     *
     * @param skillId
     */
    @Override
    public void deleteSkill(int skillId) {
        skillRepository.deleteById(skillId);
    }

    /**
     *
     * @param skillId
     * @return skill by id
     */
    @Override
    public Skill getById(int skillId) {
        return skillRepository.findById(skillId).get();
    }

    /**
     *
     * @return list of all skills
     */
    @Override
    public List<Skill> getAll() {
        return skillRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Skill::getSkillName))
                .collect(Collectors.toList());
    }
}
