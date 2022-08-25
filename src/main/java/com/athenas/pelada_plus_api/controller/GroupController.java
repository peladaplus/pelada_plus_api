package com.athenas.pelada_plus_api.controller;


import com.athenas.pelada_plus_api.entity.Group;
import com.athenas.pelada_plus_api.service.GroupService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveGroup(@RequestBody Group group) throws ExecutionException, InterruptedException {
        return groupService.toSave(group);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Group> groupList() throws ExecutionException, InterruptedException {
        return groupService.toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Group searchIdGroup(@PathVariable String id) throws ExecutionException, InterruptedException {
        return groupService.toSearchId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String removeGroup(@PathVariable String id) throws ExecutionException, InterruptedException {
        return groupService.toRemove(id);
    };


    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String updateGroup(@RequestBody String id) throws ExecutionException, InterruptedException {
        return groupService.toUpdate(id);
    }
}
