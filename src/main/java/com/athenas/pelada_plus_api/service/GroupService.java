package com.athenas.pelada_plus_api.service;

import com.athenas.pelada_plus_api.entity.Group;
import com.athenas.pelada_plus_api.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group toSave(Group group) {
        return groupRepository.save(group);
    }

    public List<Group> toList() {
        return groupRepository.findAll();
    }

    public Optional<Group> toSearchId(Long id) {
        return groupRepository.findById(id);
    }

    public void toRemove(Long id) {
        groupRepository.deleteById(id);
    }
}
