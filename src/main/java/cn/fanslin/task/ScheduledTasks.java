package cn.fanslin.task;

import cn.fanslin.utils.DateUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * Created by fanslin on 16/12/1.
 */
@Component
public class ScheduledTasks {

    /**
     * @Scheduled 注解支持Cron表达式，也支持使用fixedRate属性在固定间隔来执行任务
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void testJob(){
//        printCurrentTime();
    }

    /**
     * @Async 自动生成一个实现Runnable接口的类，并且将它实例化后交给TaskExecutor执行
     */
    @Async
    private void printCurrentTime() {
        System.out.println(Thread.currentThread().getId()+" ====> "+ DateUtils.date2Str(DateUtils.datetimeFormat)+" <====");
    }
}
