package com.pluralsight.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer
{
    @Id
    @Column(name="CustomerID")
    private String customerId;

    @Column(name="CompanyName")
    private String companyName;

    @Column(name="ContactName")
    private String contactName;

    @Column(name="Address")
    private String address;

    @Column(name="City")
    private String city;

    @Column(name="Region")
    private String state;

    @Column(name="PostalCode")
    private String zip;

    @Column(name="Country")
    private String country;

}
