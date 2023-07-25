package com.telephone.service;

import com.telephone.entity.Directory;
import com.telephone.repository.DirectoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DirectoryServiceImpl implements DirectoryService{

    @Autowired
    private DirectoryRepository directoryRepository;

    @Override
    public Directory saveDirectory(Directory directory) {
        return directoryRepository.save(directory);
    }

    @Override
    public List<Directory> fetchAllDirectorys() {
        List<Directory> allDirectorys = directoryRepository.findAll();
        return allDirectorys;
    }

    @Override
    public Directory getDirectoryById(Long id) {
        Optional<Directory> directory = directoryRepository.findById(id);
        if (directory.isPresent()) {
            return directory.get();
        }
        return null;
    }

    @Override
    public Directory updateDirectoryById(Long id, Directory directory) {
        Optional<Directory> directory1 = directoryRepository.findById(id);

        if (directory1.isPresent()) {
            Directory originalDirectory = directory1.get();

            if (Objects.nonNull(directory.getName()) && !"".equalsIgnoreCase(directory.getName())) {
                originalDirectory.setDirectoryName(directory.getName());
            }
            if (Objects.nonNull(directory.getPhone()) && directory.getPhone() != 0) {
                originalDirectory.setPhone(directory.getPhone());
            }
            if (Objects.nonNull(directory.getEmail()) && !"".equalsIgnoreCase(directory.getEmail())) {
                originalDirectory.setEmail(directory.getEmail());
            }
            return directoryRepository.save(originalDirectory);
        }
        return null;
    }

    @Override
    public String deleteDirectoryById(Long id) {
        if (directoryRepository.findById(id).isPresent()) {
            directoryRepository.deleteById(id);
            return "Directory deleted successfully";
        }
        return "No such Directory in the database";
    }

	@Override
	public List<Directory> getDirectoryByName(String name) {
		List<Directory> allDirectorysByName = directoryRepository.findByName(name);
        return allDirectorysByName;
	}
}
