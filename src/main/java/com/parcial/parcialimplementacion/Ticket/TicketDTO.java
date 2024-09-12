package com.parcial.parcialimplementacion.Ticket;

public class TicketDTO {
    private Long ticketId;
    private Long userId;
    private Long eventId;

    public TicketDTO(Long ticketId, Long userId, Long eventId) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.eventId = eventId;
    }

    // Getters and setters
    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
