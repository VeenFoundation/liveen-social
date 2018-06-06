package com.doubles.qna.domain;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{

    @Query(value="SELECT * FROM ACTIVITY", nativeQuery = true)
    List<Activity> findAllMyData();

	List<Activity> findByTitle(String title);
	
	
	 @Query(value="SELECT user.email, act.writer_id, count(act.behaviour), count(act.location), count(act.hashtag), sum(act.like_hit), sum(act.dislike_hit) FROM ACTIVITY act, USER user where act.writer_id = user.id group by writer_id", nativeQuery = true)
	 List<Activity> findAllMyData2(); // To Fix Return Object
}
