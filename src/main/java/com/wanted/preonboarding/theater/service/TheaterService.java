package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.dto.AudienceRequest;
import com.wanted.preonboarding.theater.service.handler.Theater;
import com.wanted.preonboarding.theater.service.handler.Ticket;
import com.wanted.preonboarding.theater.service.handler.TicketOffice;
import com.wanted.preonboarding.theater.service.handler.TicketSeller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(AudienceRequest request){
        theater.enter(
                request.toEntity(),
                new TicketSeller(20000L, new TicketOffice(new Ticket(100L)))
        );
        return "Have a good time.";
    }
}
