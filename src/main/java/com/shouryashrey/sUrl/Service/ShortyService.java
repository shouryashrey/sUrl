package com.shouryashrey.sUrl.Service;

import com.shouryashrey.sUrl.Modal.Dao.ShortyDaoImpl;
import com.shouryashrey.sUrl.Modal.ShortUrlModal;
import com.shouryashrey.sUrl.Modal.ShortyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class ShortyService {

    @Autowired
    private ShortyUtils shortyUtils;

    @Autowired
    private ShortyDaoImpl shortyDao;


    @Value("${staticBaseUrl}")
    private String staticBaseUrl;

    public ShortyResponse saveLongUrl(String longUrl) throws RuntimeException {
        if(!shortyUtils.isValidUrl(longUrl)) {
            throw new RuntimeException();
        }
        String hashKey = shortyUtils.generateHash(longUrl);
        shortyDao.save(new ShortUrlModal(hashKey, longUrl));
        return new ShortyResponse(staticBaseUrl + hashKey);
    }

    public String getLongUrl(String id) {
        ShortUrlModal shortUrlModal = shortyDao.getUrl(id);
        return shortUrlModal.getLongUrl();
    }
}
