package com.anime.anime;

import jakarta.validation.constraints.NotEmpty;

public class Anime {
    private String id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String opinion;

    public Anime(String id, String name, String opinion) {
        this.id = id;
        this.name = name;
        this.opinion = opinion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
    
}
