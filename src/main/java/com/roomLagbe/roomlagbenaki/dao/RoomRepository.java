package com.roomLagbe.roomlagbenaki.dao;

import com.roomLagbe.roomlagbenaki.entities.Room;
import com.roomLagbe.roomlagbenaki.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// RoomRepository.java


public interface RoomRepository extends JpaRepository<Room, Integer> {
    public List<Room> findAll();
}
