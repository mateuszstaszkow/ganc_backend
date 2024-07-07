package com.ganc_backend.inquiries.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "inquiries")
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String message;
}
