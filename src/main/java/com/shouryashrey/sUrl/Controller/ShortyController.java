package com.shouryashrey.sUrl.Controller;

import com.shouryashrey.sUrl.Controller.Exception.ErrorResponse;
import com.shouryashrey.sUrl.Controller.Exception.LongUrlNotFoundException;
import com.shouryashrey.sUrl.Modal.ShortyRequest;
import com.shouryashrey.sUrl.Modal.ShortyResponse;
import com.shouryashrey.sUrl.Service.ShortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController("/sUrl")
public class ShortyController {

    @Autowired
    public ShortyService shortyService;

    @PostMapping("/create")
    public ResponseEntity<ShortyResponse> createShortUrl(@RequestBody ShortyRequest shortyRequest) {
        return new ResponseEntity<>(shortyService.saveLongUrl(shortyRequest.getLongUrl()), HttpStatus.OK);
    }

    @GetMapping("/retrieve/{hashKey}")
    public ResponseEntity<HttpStatus> retrieveLongUrl(@PathVariable("hashKey") String hashKey) throws URISyntaxException {
        URI uri = new URI(shortyService.getLongUrl(hashKey));
        return ResponseEntity
            .status(HttpStatus.MOVED_PERMANENTLY)
            .location(uri)
            .header(HttpHeaders.CONNECTION, "close")
            .build();
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse error = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            exception.getMessage(),
            System.currentTimeMillis()
        );
        return new ResponseEntity<> (error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleNotFoundException(LongUrlNotFoundException exception) {
        ErrorResponse error = new ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            exception.getMessage(),
            System.currentTimeMillis()
        );
        return new ResponseEntity<> (error, HttpStatus.NOT_FOUND);
    }
}
