package com.athenas.pelada_plus_api.controller;


import com.athenas.pelada_plus_api.entity.Group;
import com.athenas.pelada_plus_api.service.GroupService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Group saveGroup(@RequestBody Group group) {
        return groupService.toSave(group);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Group> groupList() {
        return groupService.toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Group> searchIdGroup(@PathVariable("id") Long id) {
        return groupService.toSearchId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeGroup(@PathVariable("id") Long id) {
        groupService.toSearchId(id)
                .map(group -> {
                    groupService.toRemove(group.getId());
                    return null;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGroup(@PathVariable("id") Long id, @RequestBody Group group) {
        groupService.toSearchId(id)
                .map(groupBase -> {
                    modelMapper.map(group, groupBase);
                    groupService.toSave(groupBase);
                    return null;
                });
    }
}
