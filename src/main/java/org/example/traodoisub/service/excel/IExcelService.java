package org.example.traodoisub.service.excel;


import org.example.traodoisub.model.ExcelExportOutput;
import org.example.traodoisub.model.ExcelInfoModel;
import org.example.traodoisub.model.ExportExcelToPathModel;

public interface IExcelService {

    byte[] exportExcelToByte(ExcelInfoModel model);

    ExcelExportOutput exportExcelToPath(ExportExcelToPathModel model);
}