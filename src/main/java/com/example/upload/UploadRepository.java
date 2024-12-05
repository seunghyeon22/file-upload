package com.example.upload;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UploadRepository {
    private final EntityManager em;

    public void save(Upload upload) {
        em.persist(upload);
    }

    public Upload findById(int i) {
        return em.find(Upload.class, i);
    }
}
