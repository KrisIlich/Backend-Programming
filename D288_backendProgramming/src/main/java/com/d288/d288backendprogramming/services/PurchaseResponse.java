package com.d288.d288backendprogramming.services;

import com.d288.d288backendprogramming.entities.StatusType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PurchaseResponse {
    private final String orderTrackingNumber;
    private StatusType status;
}
