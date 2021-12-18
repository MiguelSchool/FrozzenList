package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.Tray;
import com.miguel.engeneering.frozzenlist.models.User;

import java.util.List;
import java.util.Map;

public interface TrayService {
    public Tray saveTray(Tray tray);
    public List<Tray> saveTrays(List<Tray>trays);

    public Tray findTrayByID(Long id);
    public List<Tray> findAllByID(List<Long>ids);

    public Map<Long,Tray> findTrayByOwner(User user);

    public boolean deleteById(Long id);
    public void deleteAll(List<Long>ids);

    public List<Tray> sortTrayByName(List<Tray>trayList);
    public List<Tray> sortTrayByUserLastName(List<Tray>trays);
    public List<Tray> sortTrayByUserFirstName(List<Tray>trays);
}
