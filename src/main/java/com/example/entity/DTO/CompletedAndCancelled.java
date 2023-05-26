package com.example.entity.DTO;

/**
 *
 * @author Javis
 */
public class CompletedAndCancelled {
    
    private Long completed;
    private Long cancelled;

    public CompletedAndCancelled(Long completed, Long cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    /**
     * @return the completed
     */
    public Long getCompleted() {
        return completed;
    }

    /**
     * @param completed the completed to set
     */
    public void setCompleted(Long completed) {
        this.completed = completed;
    }

    /**
     * @return the cancelled
     */
    public Long getCancelled() {
        return cancelled;
    }

    /**
     * @param cancelled the cancelled to set
     */
    public void setCancelled(Long cancelled) {
        this.cancelled = cancelled;
    }
    
    
}
