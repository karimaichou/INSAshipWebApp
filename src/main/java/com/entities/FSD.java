package com.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

/**
 * Created by karima on 20/11/2016.
 */
@Entity
@Table(name = "fsd")
public class FSD extends User {


    private String address;

    @OneToMany(mappedBy = "fsd")
    private Collection<FSDProcedure> procedures;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Collection<FSDProcedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(Collection<FSDProcedure> procedures) {
        this.procedures = procedures;
    }
}
