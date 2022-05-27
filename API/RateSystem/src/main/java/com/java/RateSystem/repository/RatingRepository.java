package com.java.RateSystem.repository;

import com.java.RateSystem.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RatingRepository extends JpaRepository<Rating, UUID> {
    @Query("SELECT s FROM Rating s WHERE s.ServiceId = ?1")
    Optional<Rating> findByUUID(UUID id);

}
