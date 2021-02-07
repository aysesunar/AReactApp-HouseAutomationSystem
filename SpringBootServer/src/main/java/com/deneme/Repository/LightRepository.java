package com.deneme.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deneme.Model.Light;
import com.deneme.Model.Room;
import com.deneme.Model.DTO.RoomDTO;



@Repository
public interface LightRepository extends JpaRepository<Light, Integer>{
	/*@Query(value = "SELECT a FROM artist a WHERE a.email=:email AND a.password=:password")
	public List<Artist> isThereAPersonLikeThis(@Param("email") String email, @Param("password") String password);*/
	/*@Query("SELECT c FROM Artist c WHERE c.email=?1 AND c.password=?2")
	Artist isThereAPersonLikeThis( String email, String password);
	
	@Query("SELECT c FROM Artist c WHERE c.style=?1")
	List<Artist> styleArtistListAll( String style);
	
	@Query("SELECT c FROM Artist c WHERE c.name=?1 ")
	Artist findByName( String name);*/
	

}
