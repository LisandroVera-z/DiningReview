package com.LisandroVera.DiningReview.Entities;

public enum AdminReviewAction {

    ACCEPT(true),
    REJECT(false),
    PENDING(null);

    private final Boolean accept;

    AdminReviewAction(Boolean accept) {
        this.accept = accept;
    }

    public Boolean getAccept() {
        return accept;
    }
}


