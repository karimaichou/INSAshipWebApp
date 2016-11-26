package com.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;

/**
 * Created by karima on 20/11/2016.
 */
@Entity
public class FSD extends User {


    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "fsd")
    private Collection<FSDProcedure> procedures;

    public Collection<FSDProcedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(Collection<FSDProcedure> procedures) {
        this.procedures = procedures;
    }
}
