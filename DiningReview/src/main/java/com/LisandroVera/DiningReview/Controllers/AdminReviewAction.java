package com.LisandroVera.DiningReview.Controllers;

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


