package com.shouryashrey.sUrl.Modal.Dao;

import com.shouryashrey.sUrl.Controller.Exception.LongUrlNotFoundException;
import com.shouryashrey.sUrl.Modal.ShortUrlModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ShortyDaoImpl implements ShortyDao {

    @Autowired
    private ShortyMongo repository;


    @Override
    public void save(ShortUrlModal shortUrlModal) {
        repository.save(shortUrlModal);
    }

    @Override
    public ShortUrlModal getUrl(String id) throws LongUrlNotFoundException {
        Optional<ShortUrlModal> shortUrlModal = repository.findById(id);
        if(shortUrlModal.isEmpty()) {
            throw new LongUrlNotFoundException("Oops!! No Such url found");
        }
        return shortUrlModal.get();
    }
}
