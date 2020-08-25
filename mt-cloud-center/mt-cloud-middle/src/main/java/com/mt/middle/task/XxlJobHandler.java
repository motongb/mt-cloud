package com.mt.middle.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 任务调度执行器
 */
@Slf4j
@Component
public class XxlJobHandler {

    @XxlJob("demoJobHandler")
    public ReturnT<String> execute(String param) {
        XxlJobLogger.log("hello world");
        log.info("demo task!!!!!!!!!!!!!!!!!!!");
        return ReturnT.SUCCESS;
    }
}
