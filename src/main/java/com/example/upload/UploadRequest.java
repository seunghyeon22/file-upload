package com.example.upload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

public class UploadRequest {
    @Data
    public static class V1DTO{
        private String username;
        private MultipartFile img;

        public Upload toEntity(String profile){
            return Upload.builder().username(username).profileUrl(profile).build();
        }

    }
}
