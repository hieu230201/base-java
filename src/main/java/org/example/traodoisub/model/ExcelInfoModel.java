package org.example.traodoisub.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class ExcelInfoModel implements Serializable {
    private static final long serialVersionUID = -3902645311811985095L;

    String fileTempName;
    Map<String, Object> beans;
}