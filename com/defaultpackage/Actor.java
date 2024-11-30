package com.defaultpackage;

import java.util.ArrayList;


public class Actor {
    static Album albumInstance = Album.defaultAlbumInstance();
    String name;
    int age;
    ArrayList<Album> albums;
    long yearlyProfitNet;
    ArrayList<Actor> actorList = new ArrayList<>();

    public Actor(String name, int age, ArrayList<Album> albumList, long netProfit) {
        this.name = name;
        this.age = age;
        this.albums = albumList;
        this.yearlyProfitNet = netProfit;
    }

    // Simulation: Album table stored in DB
    public Album listCreatedAlbums() {
        albumInstance.create("Ettamen", 12, "Tamer Hosny");
        albumInstance.create("180", 12, "Tamer Hosny");
        albumInstance.create("Tamally Maak", 12, "Amr Diab");
        albumInstance.create("Bhebak Ya Lebnan", 8, "Fairuz");
        return albumInstance;
    }

    public void create(String name, int age, Album albums, long profitNet) {
        Album albumInstance = listCreatedAlbums();
        ArrayList<Album> getFilteredAlbums = albumInstance.filterByRefName(name);
        ArrayList<Album> createNewArrayOfAlbumInstances = new ArrayList<>();

        if (!getFilteredAlbums.isEmpty()) {
            createNewArrayOfAlbumInstances.addAll(getFilteredAlbums);
            Actor actor = new Actor(name, age, createNewArrayOfAlbumInstances, profitNet);
            actorList.add(actor);
        } else {
            System.out.println("IntegrityError: No such instance to integrate with.");
        }
    }

    public ArrayList<Actor> getAllActorObjects() {
        return actorList;
    }

    public static Actor defaultActorInstance() {
        return new Actor("Initial Actor", 10, albumInstance.getAllObjects(), 1_000_000);
    }

    public static void main(String[] args) {
        Actor createdActor = defaultActorInstance();
        createdActor.create("Tamer Hosny", 44, albumInstance, 1_000_000);

        for (Actor actor : createdActor.getAllActorObjects()) {
            for (Album albumInActor : actor.albums) {
                System.out.println(albumInActor.name);
            }
        }
    }
}
