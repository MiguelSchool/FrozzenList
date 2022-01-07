package com.miguel.engeneering.frozzenlist.services.serviceImplementations;

import com.miguel.engeneering.frozzenlist.models.Tray;
import com.miguel.engeneering.frozzenlist.models.User;
import com.miguel.engeneering.frozzenlist.repositories.TrayRepository;
import com.miguel.engeneering.frozzenlist.services.TrayService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TrayServiceImpl implements TrayService {

    private final TrayRepository trayRepository;

    @Override
    public Tray saveTray(Tray tray) {
        return this.trayRepository.save(tray);
    }

    @Override
    public List<Tray> saveTrays(List<Tray> trays) {
        Iterator<Tray> trayIterator = trays.iterator();
        List<Tray> trayList = new ArrayList<>();
        while ((trayIterator.hasNext())) {
            if (trayIterator.next() != null) {
                trayList.add(this.saveTray(trayIterator.next()));
            }
        }
        return trayList;
    }

    @Override
    public Tray findTrayByID(Long id) {
        if (id != null && this.trayRepository.existsById(id)) {
            return this.trayRepository.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public List<Tray> findAllByID(List<Long> ids) {
        List<Tray> trayList = new ArrayList<>();
        ids.forEach(id -> trayList.add(this.findTrayByID(id)));
        return trayList;
    }

    @Override
    public Map<Long, Tray> findTrayByOwner(User user) {
        return user.getTrays();

    }

    @Override
    public boolean deleteById(Long id) {
        if(trayRepository.existsById(id)){
            this.trayRepository.deleteById(id);
            return true;
        }
        return  false;
    }

    @Override
    public void deleteAll(List<Long> ids) {
        this.trayRepository.deleteAllById(ids);
    }

    @Override
    public List<Tray> sortTrayByName(List<Tray> trayList) {
        return trayList.stream()
                       .sorted(Comparator.comparing(Tray::getName))
                       .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<Tray> sortTrayByUserLastName(List<Tray> trays) {
        return trays.stream()
                    .sorted(Comparator.comparing(e-> e.getOwner().getLastName()))
                    .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<Tray> sortTrayByUserFirstName(List<Tray> trays) {
        return trays.stream()
                .sorted(Comparator.comparing(e-> e.getOwner().getFirstName()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
