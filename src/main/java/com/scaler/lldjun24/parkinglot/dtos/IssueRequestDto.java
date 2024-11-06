package com.scaler.lldjun24.parkinglot.dtos;

public class IssueRequestDto {
    private Long gateid;
    private String number;
    private String ownername;
    private String vehicleType;

    public Long getGateid() {
        return gateid;
    }

    public void setGateid(Long gateid) {
        this.gateid = gateid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
