package com.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * <p>
 * </p>
 *
 * @author renwujie
 * @since 2018-07-23 19:02
 */
public class SpringQuartzTest extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("执行调度任务" + new Date());
    }
}
