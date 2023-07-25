package com.telephone.controller;

import com.telephone.entity.Directory;
import com.telephone.service.DirectoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TelephoneDirectory")
public class DirectoryController {

    @Autowired
    private DirectoryService directoryService; 

    @PostMapping("/directory")
    public Directory saveDirectory(@RequestBody Directory directory) {
        return directoryService.saveDirectory(directory);
    }

    @GetMapping("/directory")
    public List<Directory> getAllDirectorys() {
        return directoryService.fetchAllDirectorys();
    }
    
    @GetMapping("/directory/{name}")
    public List<Directory> getDirectoryByName(@PathVariable("name") String name) {
        return directoryService.getDirectoryByName(name);
    }

    @PutMapping("/directory/{id}")
    public Directory updateDirectory(@PathVariable("id") Long id, @RequestBody Directory directory) {
        return directoryService.updateDirectoryById(id, directory);
    }

    @DeleteMapping("/directory/{id}")
    public String deleteDirectory(@PathVariable("id") Long id) {
        return directoryService.deleteDirectoryById(id);
    }
}
