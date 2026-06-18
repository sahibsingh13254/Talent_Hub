package com.TalentHub.demo.entity;

import com.TalentHub.demo.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity //Marks this class as a JPA entity and maps it to a database table.
@Getter //Read private fields
@Setter //Modify private fields
@NoArgsConstructor   // Needed by JPA/Hibernate
@AllArgsConstructor   // Create object with all fields
@Table(name = "users") // maps table to db

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private Long userId;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;





}
