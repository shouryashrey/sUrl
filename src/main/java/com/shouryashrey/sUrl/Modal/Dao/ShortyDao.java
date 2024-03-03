package com.shouryashrey.sUrl.Modal.Dao;

import com.shouryashrey.sUrl.Modal.ShortUrlModal;

public interface ShortyDao {
    void save(ShortUrlModal shortUrlModal);

    ShortUrlModal getUrl(String id);
}
