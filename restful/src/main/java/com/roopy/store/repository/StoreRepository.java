package com.roopy.store.repository;

import com.roopy.entity.Store3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store3,Integer> {

    /**
     * 입력 받은 radius 내에 위치하는 매장 정보 조회
     *
     * <pre>
     *  ST_DWithin
     *  param1: 매장 위치 정보
     *  param2: 사용자의 현재 위치 정보
     *  param3: 반경
     *  param4: 평면,구 검색 여부(true: 평면, flase: 구)
     * </pre>
     *
     * @param lat - 현재사용자의 위도
     * @param lot - 현재사용자의 경도
     * @param radius - 검색반경
     * @return List<Store> - 반경내에 존재하는 매장 목록
     */
    @Query(value = "select s.id"                                                                                                    +
                   "     , s.nm"                                                                                                    +
                   "     , s.addr"                                                                                                  +
                   "     , s.lat"                                                                                                   +
                   "     , s.lot"                                                                                                   +
                   "     , ROUND(ST_DistanceSphere(ST_GeomFromText('POINT('||s.lot||' '||s.lat||')', 4326),"                        +
                   "             ST_GeomFromText('POINT('||:lot||' '||:lat||')', 4326)))        AS dtnc"                            +
                   "  from Store3 s"                                                                                                +
                   " where ST_DWithin(s.geom, ST_Transform(ST_GeomFromText('POINT('||:lot||' '||:lat||')', 4326), 2097), :radius)"
         , nativeQuery = true)
    List<Store3> findStoresByPointWithRadius(@Param("lat") double lat, @Param("lot") double lot, @Param("radius") double radius);
}