package org.dreamy.dreamjournal.dream;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.dreamy.dreamjournal.dream.dto.DreamAddRequest;
import org.dreamy.dreamjournal.shared.domain.response.ResultResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Validated
@RequestMapping(path = "v1/dream")
public class DreamController {

    @PostMapping(path = "/add")
    public ResponseEntity<ResultResponse> addDream(@RequestBody @Valid DreamAddRequest dreamAddRequest)
    {
        return null;
    }

}
