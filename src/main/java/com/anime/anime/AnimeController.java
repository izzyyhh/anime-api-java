package com.anime.anime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class AnimeController {

    @Autowired
    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello Anime";
    }

    @GetMapping("/animes")
    public List<Anime> get() {
        return animeService.get();
    }

    @GetMapping("/anime/{id}")
    public Anime getAnime(@PathVariable Long id) {
        Anime anime = animeService.getById(id);

        if(anime == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return anime;
        
    }

    @PutMapping("/anime/{id}")
    public Anime putMethodName(@PathVariable Long id, @RequestBody @Valid Anime entity) {
        entity.setId(id);
        return animeService.update(entity);  
    }

    @PostMapping("/anime")
    public Anime create(@RequestBody @Validated Anime anime) {
        System.out.println("creating anime");
        animeService.create(anime);

        return anime;
    }
    
    
}
