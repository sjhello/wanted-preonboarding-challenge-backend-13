package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.dto.AudienceRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class AudienceTest {

    @Test
    void 초대권이_있는_관객을_생성한다() {
        AudienceRequest request = new AudienceRequest(20L, LocalDateTime.now());

        Audience audience = request.toEntity();

        assertThat(audience.getBag().hasInvitation()).isTrue();
    }

    @Test
    void 초대권이_없는_관객을_생성한다() {
        AudienceRequest request = new AudienceRequest(20L, null);

        Audience audience = request.toEntity();

        assertThat(audience.getBag().hasInvitation()).isFalse();
    }

    @Test
    @DisplayName("초대권이 없는 관객은 티켓 값을 지불하여 티켓을 구매한다")
    void hasNotInvitation() {
        long firstTimeMoney = 200L;
        Audience audience = new Audience(new Bag(firstTimeMoney));

        Ticket ticket = new Ticket(50L);
        long remainAmount = audience.receiveTickets(ticket);

        assertThat(remainAmount).isEqualTo(firstTimeMoney - ticket.getFee());
    }

    @Test
    @DisplayName("초대권을 가지고 있는 관객은 티켓값을 지불하지 않고 티켓을 구매한다")
    void hasInvitation() {
        long firstTimeMoney = 200L;
        Audience audience = new Audience(new Bag(new Invitation(LocalDateTime.now()), firstTimeMoney));

        long remainAmount = audience.receiveTickets(new Ticket(50L));

        assertThat(remainAmount).isEqualTo(firstTimeMoney);
    }
}