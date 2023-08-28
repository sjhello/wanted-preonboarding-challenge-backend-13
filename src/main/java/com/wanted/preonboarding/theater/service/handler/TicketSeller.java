package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;

@Getter
public class TicketSeller {
    private final TicketOffice ticketOffice;
    private long amount;

    public TicketSeller(long amount, TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
        this.amount = amount;
    }

    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
