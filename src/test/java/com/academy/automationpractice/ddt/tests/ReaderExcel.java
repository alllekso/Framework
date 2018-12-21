package com.academy.automationpractice.ddt.tests;

import com.academy.automationpractice.ddt.framework.model.AddressData;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReaderExcel {
    private static final int COUNT_COLUMNS = 0;

    public static List<AddressData> readAddress() {
        File file = new File(PropertyDemo.readProperty("loginFile"));
        List<AddressData> addressData = new ArrayList<>();

        try (XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file))) {
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            for (int r = 0; r <= sheet.getLastRowNum(); r++) {
                XSSFRow row = sheet.getRow(r);
                addressData.add(new AddressData()
                                .withFirstName(row.getCell(0).getStringCellValue())
                                .withLastName(row.getCell(1).getStringCellValue())
                                .withAddress(row.getCell(2).getStringCellValue())
                                .withCity(row.getCell(3).getStringCellValue())
                                .withState(row.getCell(4).getStringCellValue())
                                .withZipCode(row.getCell(5).getStringCellValue())
                                .withCountry(row.getCell(6).getStringCellValue())
                                .withHomePhone(row.getCell(7).getStringCellValue())
                                .withMobilePhone(row.getCell(8).getStringCellValue())
                                .withAddressAlias(row.getCell(9).getStringCellValue())
                                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addressData;

    }

}