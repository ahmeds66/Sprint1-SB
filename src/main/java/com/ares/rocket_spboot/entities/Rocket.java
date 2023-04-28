package com.ares.rocket_spboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Rocket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRocket;
    private String name;
    private Long lowOrbitPayload;
    private Long highOrbitPayload;
    private Date lunchDate;
    private Long nbLaunches;
    private Long fails;

    public Rocket(){
        super();
    }

    public Rocket(String name, Long lowOrbitPayload, Long highOrbitPayload, Date lunchDate, Long nbLaunches, Long fails) {
        super();
        this.name = name;
        this.lowOrbitPayload = lowOrbitPayload;
        this.highOrbitPayload = highOrbitPayload;
        this.lunchDate = lunchDate;
        this.nbLaunches = nbLaunches;
        this.fails = fails;
    }

    public Long getIdRocket() {
        return idRocket;
    }

    public void setIdRocket(Long idRocket) {
        this.idRocket = idRocket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLowOrbitPayload() {
        return lowOrbitPayload;
    }

    public void setLowOrbitPayload(Long lowOrbitPayload) {
        this.lowOrbitPayload = lowOrbitPayload;
    }

    public Long getHighOrbitPayload() {
        return highOrbitPayload;
    }

    public void setHighOrbitPayload(Long highOrbitPayload) {
        this.highOrbitPayload = highOrbitPayload;
    }

    public Date getLunchDate() {
        return lunchDate;
    }

    public void setLunchDate(Date lunchDate) {
        this.lunchDate = lunchDate;
    }

    public Long getNbLaunches() {
        return nbLaunches;
    }

    public void setNbLaunches(Long nbLaunches) {
        this.nbLaunches = nbLaunches;
    }

    public Long getFails() {
        return fails;
    }

    public void setFails(Long fails) {
        this.fails = fails;
    }

    @Override
    public String toString(){
        return "Rocket [idRocket= " + idRocket +  " , Name = " + name + " , lowOrbitPayload= "+lowOrbitPayload
                + " , highOrbitPayload= " +highOrbitPayload +" , lunchDate= " + lunchDate + " , nbLaunches= "
                + nbLaunches + " , fails= "+ fails + " ]";
    }
}
