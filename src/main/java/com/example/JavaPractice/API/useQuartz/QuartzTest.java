package com.example.JavaPractice.API.useQuartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {

    /**
     * 使用Quartz来创建多作业调度：
     * 1、构建一个作业调度池：Scheduler
     * 2、向作业调度池中添加作业
     *   2.1 创建一个新的作业
     *     2.1.1 创建作业详情：JobDetail
     *     2.1.2 创建作业调度器
     *     2.1.3 以作业详情和作业调度器创建一个新的作业
     *   2.2 添加作业到作业调度池
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        //创建一个scheduler作业调度池
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //创建新的作业
        add(scheduler);
        scheduler.start();
        deleteJob(scheduler);
    }

    private static void deleteJob(Scheduler scheduler) throws SchedulerException {
        JobKey jobKey = new JobKey("tigger1");
        scheduler.deleteJob(jobKey);
        JobKey j2 = new JobKey("1");
        boolean b = scheduler.deleteJob(j2);
        System.out.println(b);
    }

    private static void add(Scheduler scheduler) throws SchedulerException {
        //创建作业详情
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("v1", "group1").build();
        //创建作业调度器
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("tigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 57 17 * * ?"))
                .build();
        scheduler.scheduleJob(jobDetail,trigger);
    }

    private static void addNewJob(Scheduler scheduler) throws SchedulerException {

    }


    public static void quartzDemo(){
        try {
            Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();

            defaultScheduler.start();




            defaultScheduler.shutdown();


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
