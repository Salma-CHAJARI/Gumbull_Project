package com.example.startlist.service;

import com.example.startlist.Bean.Gumbull;
import com.example.startlist.Dao.IDao;

import java.util.ArrayList;
import java.util.List;

public class ListService implements IDao<Gumbull> {
    private List<Gumbull> gumbull;
    private static ListService instance;

    private ListService() {
        gumbull = new ArrayList<>();
    }

    public static ListService getInstance() {
        if (instance == null) {
            instance = new ListService();
        }
        return instance;
    }

    @Override
    public Boolean create(Gumbull o) {
        return gumbull.add(o);
    }

    @Override
    public Boolean delete(Gumbull o) {
        return gumbull.remove(o);
    }

    @Override
    public Boolean update(Gumbull o) {
        for (Gumbull s : gumbull) {
            if (o.getId() == s.getId()) {
                s.setPhoto(o.getPhoto());
                s.setNom(o.getNom());
                s.setStar(o.getStar());
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Gumbull> findAll() {
        return new ArrayList<>(this.gumbull);
    }

    @Override
    public Gumbull findById(int id) {
        for (Gumbull s : gumbull) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
