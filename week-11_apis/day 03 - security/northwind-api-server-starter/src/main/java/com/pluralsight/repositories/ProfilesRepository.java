package com.pluralsight.repositories;

import com.pluralsight.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilesRepository extends JpaRepository<Profile, Integer>{}
