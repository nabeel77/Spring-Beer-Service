package com.spring6mvcrest.spring6mvcrest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private UUID id;
    private String customerName;

    @Version
    private String version;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
