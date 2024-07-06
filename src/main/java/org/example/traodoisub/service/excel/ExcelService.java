package org.example.traodoisub.service.excel;

import org.example.traodoisub.model.ExcelExportOutput;
import org.example.traodoisub.model.ExcelInfoModel;
import org.example.traodoisub.model.ExportExcelToPathModel;
import org.springframework.stereotype.Service;

@Service
public class ExcelService implements IExcelService {

    @Override
    public byte[] exportExcelToByte(ExcelInfoModel model) {

        return ExcelUtils.exportToByte(model.getFileTempName(), model.getBeans());
    }

    @Override
    public ExcelExportOutput exportExcelToPath(ExportExcelToPathModel model) {

        return ExcelUtils.exportToPath(model);
    }
}