package com.athenas.pelada_plus_api.controller;


import com.athenas.pelada_plus_api.entity.Group;
import com.athenas.pelada_plus_api.service.GroupService;
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

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Group searchIdGroup(@PathVariable String name) throws ExecutionException, InterruptedException {
        return groupService.toSearchId(name);
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String removeGroup(@PathVariable String name) throws ExecutionException, InterruptedException {
        return groupService.toRemove(name);
    }

    ;


    @PutMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String updateGroup(@PathVariable String name, @RequestBody Group group) throws ExecutionException, InterruptedException {
        return groupService.toUpdate(group);
    }
}