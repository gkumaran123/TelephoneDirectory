package com.telephone.service;

import java.util.List;

import com.telephone.entity.Directory;

public interface DirectoryService {

    Directory saveDirectory(Directory directory);

    List<Directory> fetchAllDirectorys();

    Directory getDirectoryById(Long id);

    Directory updateDirectoryById(Long id, Directory directory);

    String deleteDirectoryById(Long id);

	List<Directory> getDirectoryByName(String name);
}
