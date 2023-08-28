package com.wanted.preonboarding.theater.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Invitation;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class AudienceRequest {

    private Long amount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime when;

    public AudienceRequest(Long amount, LocalDateTime when) {
        this.amount = amount;
        this.when = when;
    }

    public Audience toEntity() {
        if (validateWhen()) {
            return new Audience(new Bag(this.amount));
        }

        return new Audience(new Bag(new Invitation(this.when), amount));
    }

    private boolean validateWhen() {
        return this.when == null;
    }
}
