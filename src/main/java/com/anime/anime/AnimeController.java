package com.anime.anime;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class AnimeController {

    private List<Anime> db = List.of( new Anime("1", "Oregairu", "super"));

    @GetMapping("/")
    public String hello() {
        return "Hello Anime";
    }

    @GetMapping("/animes")
    public List<Anime> get() {
        return db;
    }

    @GetMapping("/anime/{id}")
    public Anime getAnime(@PathVariable String id) {
        Anime anime = db.get(0);

        if(anime != null) return anime;
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/anime")
    public Anime create(@RequestBody @Validated Anime anime) {
        System.out.println("creating anime");
        System.out.println("creating anime");
        return anime;
    }
    
    
}
