package org.jiaju.model;

import lombok.Data;

@Data
public class MainTemplateConfig {
    /**
     * 作者
     */
    private String author = "作者";

    /**
     * 输出信息
     */
    private String outputText="sum";

    /**
     * 是否循环（开关）
     */
    private boolean loop;
}
