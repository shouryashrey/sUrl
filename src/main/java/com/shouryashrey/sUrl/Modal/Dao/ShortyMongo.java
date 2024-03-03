package com.shouryashrey.sUrl.Modal.Dao;

import com.shouryashrey.sUrl.Modal.ShortUrlModal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShortyMongo extends MongoRepository<ShortUrlModal, String> {
}
