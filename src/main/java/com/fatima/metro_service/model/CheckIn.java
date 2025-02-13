package com.fatima.metro_service.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "check_in")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long stationId;
    private LocalDateTime checkInTime;
}

