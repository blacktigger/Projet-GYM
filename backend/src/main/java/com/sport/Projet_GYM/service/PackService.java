package com.sport.Projet_GYM.service;

import com.sport.Projet_GYM.model.Pack;
import com.sport.Projet_GYM.repository.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PackService {

    private final PackRepository packRepository;

    @Autowired
    public PackService(PackRepository packRepository) {
        this.packRepository = packRepository;
    }

    public Pack addPack(Pack pack) {
        return packRepository.save(pack);
    }

    public List<Pack> getAllPacks() {
        return packRepository.findAll();
    }

    public Pack updatePack(Pack pack) {
        return packRepository.save(pack);
    }

    public void deletePack(Long id) {
        packRepository.deleteById(id);
    }

    public Optional<Pack> getPackById(Long id) {
        return packRepository.findById(id);
    }
}
