package com.deneme.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deneme.Model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

}
