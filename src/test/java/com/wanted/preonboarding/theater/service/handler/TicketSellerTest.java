package com.wanted.preonboarding.theater.service.handler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TicketSellerTest {

    @Test
    void 티켓_판매자_판매하면_티켓값_만큼_amount가_추가된다() {
        Ticket ticket = new Ticket(100L);
        TicketSeller ticketSeller = new TicketSeller(200L, new TicketOffice(ticket));

        ticketSeller.plusAmount(ticket.getFee());

        assertThat(ticketSeller.getAmount()).isEqualTo(300L);
    }

}