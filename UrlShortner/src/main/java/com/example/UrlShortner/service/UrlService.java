package com.example.UrlShortner.service;

import com.example.UrlShortner.entity.UrlEntity;
import com.example.UrlShortner.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@Service
public class UrlService {
    @Autowired
   private UrlRepository urlRepository;
    public String save(String actualUrl) throws MalformedURLException {
        UrlEntity urlEntity=new UrlEntity();
        urlEntity.setActualUrl(actualUrl);
        Random random =new SecureRandom();
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<=5;i++){
            int index=random.nextInt(actualUrl.length());
            builder.append(actualUrl.charAt(index));
        }
        urlEntity.setShortenUrl(builder.toString());
        urlRepository.save(urlEntity);
        return "http://localhost:8080/r?s="+builder.toString();
    }


    public RedirectView redirect(String shortenUrl){
        List<UrlEntity> urlList=urlRepository.findAll();
        String url = "";
        for(int i=0;i<urlList.size();i++){
            if(urlList.get(i).getShortenUrl().equals(shortenUrl)){
                url= urlList.get(i).getActualUrl();
            }
        }
        return new RedirectView(url);
    }


    private static String extractDomain(String host) {
        String[] parts = host.split("\\.");
        if (parts.length >= 2) {
            return parts[parts.length - 2];
        }
        return host;
    }
}
