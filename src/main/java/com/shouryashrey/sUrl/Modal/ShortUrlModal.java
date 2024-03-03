package com.shouryashrey.sUrl.Modal;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "short-url")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShortUrlModal {

    @Id
    private String id;
    private String longUrl;
    private Instant timeStamp;

    public ShortUrlModal(String id, String longUrl) {
        this.id = id;
        this.longUrl = longUrl;
        this.timeStamp = Instant.now();
    }
}
