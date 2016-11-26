package com.entities;

import javax.persistence.Entity;

/**
 * Created by karima on 20/11/2016.
 */


public enum ApplicationState {

    Sent,
    Done,
    UnderFSD,
    UnderAgreement,
    ValidatedByStudent,
    ValidatedByCompany,
    ValidatedByFSD,
    ValidatedByINSA,
    Rejected
}
