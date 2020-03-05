package com.baseball.Baseball.Players;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageableRepository extends PagingAndSortingRepository<Player,String> {
}
