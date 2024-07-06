package org.example.traodoisub.controller;

import org.example.traodoisub.service.excel.Employee;
import org.example.traodoisub.service.excel.IExcelService;
import org.example.traodoisub.model.ExcelInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private IExcelService excelService;

    @GetMapping
    public ResponseEntity<?> test(@RequestParam("id") String id) {
        return ResponseEntity.ok().body(Integer.parseInt(id));
    }

    @GetMapping("a")
    public ResponseEntity<?> test1() {
        List<Employee> employees = Arrays.asList(
                new Employee("John Doe", 30, "Engineering"),
                new Employee("Jane Smith", 25, "Marketing"),
                new Employee("Michael Brown", 40, "Management")
        );

        Map<String, Object> beans = new HashMap<>();
        beans.put("employees", employees);
        ExcelInfoModel excelInfoModel = new ExcelInfoModel();
        excelInfoModel.setFileTempName("test.xlsx");
        excelInfoModel.setBeans(beans);

        byte[] excelData = excelService.exportExcelToByte(excelInfoModel);
        ByteArrayResource resource = new ByteArrayResource(excelData);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=test.xlsx")
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .contentLength(excelData.length)
                .body(resource);
    }
}
