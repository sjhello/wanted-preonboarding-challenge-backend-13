package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;

@Getter
public class Audience {
    private final Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public boolean hasInvitation() {
        return this.bag.getInvitation() != null;
    }

    public long receiveTickets(Ticket ticket) {
        long money = this.bag.getAmount();

        if (!hasInvitation()) {
            bag.pushTicket(ticket);
            return money - ticket.getFee();
        }

        bag.pushTicket(ticket);
        return money;
    }
}