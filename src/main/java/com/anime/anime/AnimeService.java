package com.anime.anime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AnimeService {
    @Autowired
    private AnimeRepository animeRepository;

    public List<Anime> get() {
        return animeRepository.findAll();
    }

    public Anime getById(Long id) {
        return animeRepository.findById(id).orElse(null);
    }

    public Anime create(Anime anime) {
        return animeRepository.save(anime);
    }

    public Anime update(Anime anime) {
        Anime foundAnime = animeRepository.findById(anime.getId()).orElse(null);
        if(foundAnime == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        
        return animeRepository.save(anime);
    }
}
