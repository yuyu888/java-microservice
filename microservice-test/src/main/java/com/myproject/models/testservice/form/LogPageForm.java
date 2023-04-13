package com.myproject.models.testservice.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.common.utils.PageForm;
import lombok.Data;

@Data
public class LogPageForm extends PageForm {
    @JsonProperty("uid")
    private Integer uid;

    @JsonProperty("operate_type")
    private Integer operateType;

}
