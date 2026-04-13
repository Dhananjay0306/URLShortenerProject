package com.example.URLShortenerProject.service;



import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.URLShortenerProject.entity.Url;
import com.example.URLShortenerProject.repository.UrlRepository;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final String BASE_URL = "http://localhost:8080/";

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String shortenUrl(String originalUrl) {
        String shortCode = generateShortCode();

        Url url = new Url(originalUrl, shortCode);
        urlRepository.save(url);

        return BASE_URL + shortCode;
    }

    public String getOriginalUrl(String shortCode) {
        Url url = urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL not found"));

        url.setClickCount(url.getClickCount() + 1);
        urlRepository.save(url);

        return url.getOriginalUrl();
    }

    private String generateShortCode() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder shortCode = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            shortCode.append(chars.charAt(random.nextInt(chars.length())));
        }

        return shortCode.toString();
    }
}