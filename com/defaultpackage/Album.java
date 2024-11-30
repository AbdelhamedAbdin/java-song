package com.defaultpackage;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


public class Album {
    int numberOfSong;
    public String name;
    Date issuerDate;
    ArrayList<Album> albumList = new ArrayList<>();
    String referenceName;

    public Album(String name, int numberOfSong, Date issuerDate, String referenceName) {
        this.name = name;
        this.numberOfSong = numberOfSong;
        this.issuerDate = issuerDate;
        this.referenceName = referenceName;
    }

    public void create(String name, int numbers, String referenceName) {
        Album albums = new Album(name, numbers, dateFormat(), referenceName); // create a new Album instance
        albumList.add(albums); // Add the new album to the list
    }

    public ArrayList<Album> getAllObjects() {
        return albumList;
    }

    public ArrayList<Album> filterByRefName(String reference) {
        if (reference == null) return null;
        ArrayList<Album> filteredAlbums = new ArrayList<>();

        for (Album album : albumList) {
            if (Objects.equals(album.referenceName, reference)) {
                filteredAlbums.add(album);
            }
        }
        return filteredAlbums;
    }

    // apply the same date format for instances at once
    public static Date dateFormat() {
        return new Date();  // will keep it for now
    }

    public static Album defaultAlbumInstance() {
        return new Album("Initial Album", 10, dateFormat(), "reference name");
    }

//    public static void main(String[] args) {
//        Album createdAlbum = defaultAlbumInstance();
//
//        createdAlbum.create("Ettamen", 12, "Tamer Hosny");
//        createdAlbum.create("Ettamen", 13, "Tamer Hosny");
//        createdAlbum.create("Tamally Maak", 12, "Amr Diab");
//        createdAlbum.create("Bhebak Ya Lebnan", 8, "Fairuz");
//
//        System.out.println(createdAlbum.getAllObjects());
//        System.out.println(createdAlbum.filterByRefName("Tamer Hosny"));
//
//    }
}
