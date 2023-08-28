package com.wanted.preonboarding.theater.service.handler;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class Bag {

    @Getter
    private Long amount;

    @Getter
    private final Invitation invitation;

    @Setter(AccessLevel.PRIVATE)
    private Ticket ticket;

    public Bag(long amount){
        this(null, amount);
    }

    public Bag(Invitation invitation, long amount){
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public void pushTicket(Ticket ticket) {
        setTicket(ticket);
    }
}
