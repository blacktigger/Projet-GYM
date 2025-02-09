package com.sport.Projet_GYM.controller;

import com.sport.Projet_GYM.model.Pack;
import com.sport.Projet_GYM.service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/packs")
public class PackController {

    private final PackService packService;

    @Autowired
    public PackController(PackService packService) {
        this.packService = packService;
    }

    @PostMapping
    public ResponseEntity<Pack> addPack(@RequestBody Pack pack) {
        Pack created = packService.addPack(pack);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<Pack>> getAllPacks() {
        List<Pack> packs = packService.getAllPacks();
        return ResponseEntity.ok(packs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pack> updatePack(@PathVariable Long id, @RequestBody Pack pack) {
        pack.setId(id);
        Pack updated = packService.updatePack(pack);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePack(@PathVariable Long id) {
        packService.deletePack(id);
        return ResponseEntity.noContent().build();
    }
}
