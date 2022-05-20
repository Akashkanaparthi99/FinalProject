package com.freelance.service;

import com.freelance.model.Skill;

import java.util.List;

public interface ISkillService{
    void addSkill(Skill skill);
    void updateSkill(Skill skill);
    void deleteSkill(int skillId);
    Skill getById(int skillId);
    List<Skill> getAll();
}
