package com.victorpereira.mrmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victorpereira.mrmanager.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
