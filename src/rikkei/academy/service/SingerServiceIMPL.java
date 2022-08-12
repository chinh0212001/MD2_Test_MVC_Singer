package rikkei.academy.service;

import rikkei.academy.model.Singer;

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;

public class SingerServiceIMPL implements ISingerService {
    static final List<Singer> singerList = new ArrayList<>();

    static {
        singerList.add(new Singer(1, 28, " Sơn Tùng MTP"));
        singerList.add(new Singer(2, 25, "Đạt G"));
        singerList.add(new Singer(3, 34, "Hoa Vinh"));
    }

    @Override
    public List<Singer> findAll() {
        return singerList;
    }

    @Override
    public void save(Singer singer) {
        singerList.add(singer);
    }

    @Override
    public void edit(int id, int age, String name) {
        singerList.get(id - 1).setAge(age);
        singerList.get(id - 1).setName(name);
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < singerList.size(); i++) {
            if (id == singerList.get(i).getId()){
                singerList.remove(i);
            }
        }

    }

    @Override
    public List<Singer> search(String name) {
        List<Singer> singers = new ArrayList<>();
        for (Singer singer : singerList) {
            if (singer.getName().equals(name)) {
                singers.add(singer);
            }
        }
        return singers;
    }

    @Override
    public void sortByName() {
        Collections.sort(singerList);
        for (int i = 0; i < singerList.size(); i++) {
            singerList.get(i).setId(i + 1);
        }
    }

    @Override
    public Singer findById(int id) {
        for (int i = 0; i < singerList.size(); i++) {
            if (id == singerList.get(i).getId()){
                return singerList.get(i);
            }
        }
        return null;
    }


}
