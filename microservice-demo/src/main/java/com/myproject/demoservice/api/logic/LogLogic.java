package com.myproject.demoservice.api.logic;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface LogLogic {
    void export(Map<String, Object> params, HttpServletResponse response);
}
