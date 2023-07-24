package com.example.healthsystem.dto;

import com.example.healthsystem.model.Address;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

public class AddressDTO {
    private Long id;
    private Long userId;
    private String street;
    private String complement;
    private String city;
    private String state;
    private String zipCode;
    private String latitude;
    private String longitude;
    private Date createdAt;
    private Date updatedAt;

    public AddressDTO() {

    }

    public Map<String, Object> getAddressDTOResponse(Address address) {
        Map<String, Object> addressDTO = Map.ofEntries(
            Map.entry("id", address.getId()),
            Map.entry("user_id", address.getUser().getId()),
            Map.entry("street", address.getStreet()),
            Map.entry("complement", address.getComplement()),
            Map.entry("city", address.getCity()),
            Map.entry("state", address.getState()),
            Map.entry("zip_code", address.getZipCode()),
            Map.entry("latitude", address.getLatitude()),
            Map.entry("longitude", address.getLongitude()),
            Map.entry("created_at", address.getCreatedAt()),
            Map.entry("updated_at", address.getUpdatedAt())
        );
        return addressDTO;
    }

}
