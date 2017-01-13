package cn.fanslin.repository;

import cn.fanslin.entity.Entry;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by fanslin on 16/11/30.
 */
@CacheConfig(cacheNames = "entries")
public interface EntriesRepository extends JpaRepository<Entry, Long> {
    @Cacheable
    Entry findByTitle(String title);

    @Query("from Entry e where e.title=:title")
    Entry findEntry(@Param("title") String title);

    @CachePut(key = "#p0.id")
    Entry save(Entry entry);
}
