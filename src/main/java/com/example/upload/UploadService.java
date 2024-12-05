package com.example.upload;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UploadService {

    private final UploadRepository uploadRepository;

    @Transactional
    public void v1사진저장(UploadRequest.V1DTO v1DTO){
        // 1. DTO에 사진파일명을 롤링 시킨다.
        String imgName = UUID.randomUUID()+"_"+v1DTO.getImg().getOriginalFilename();
        String profileUrl = "images/"+imgName;
        String dbUrl = "/upload/"+imgName;
        // 2. DTO에 사진을 파일로 저장 (images 폴더)
        try {
            Path path = Paths.get(profileUrl);
            Files.write(path, v1DTO.getImg().getBytes());
            uploadRepository.save(v1DTO.toEntity(dbUrl));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Upload v1사진보기(int i) {
        return uploadRepository.findById(i);
    }
}
