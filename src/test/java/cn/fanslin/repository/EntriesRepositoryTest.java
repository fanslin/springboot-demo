package cn.fanslin.repository;

import cn.fanslin.Application;
import cn.fanslin.entity.Entry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by fanslin on 16/11/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class EntriesRepositoryTest {
    @Autowired
    private EntriesRepository entriesRepository;

    @Autowired
    private CacheManager cacheManager;


    @Test
    public void findAll(){
        List<Entry>  entryList = entriesRepository.findAll();
        for (Entry entry : entryList) {

            System.out.println(entry);
        }
    }

    @Test
    public void findByTitle(){
        System.out.println(cacheManager.getClass().getName());
        Entry entry = entriesRepository.findByTitle("sasa");
        System.out.println("第一次查询："+entry);

        Entry entry2 = entriesRepository.findByTitle("sasa");
        System.out.println("第二次查询："+entry2);

        entry = entriesRepository.findByTitle("j");
        System.out.println("第三次查询："+entry);

        entry = entriesRepository.findByTitle("j");
        System.out.println("第四次查询："+entry);
    }
}