package com.crossover.app.utils;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by parag.dhoble on 04-08-2018.
 */
public class ReportGenerator {
   public static HashMap <String, Object[]> testResultDetails = new HashMap<String, Object[]>();


    public void writeDataInExcel() throws IOException {
        File template = new File ("C:\\Study\\template.xlsx");
        File Report = new File (System.getProperty("user.dir")+"\\Report.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(template));
        XSSFSheet sheet = workbook.getSheetAt(0);

        Set<String> keyset = testResultDetails.keySet();
        int row1 = 1;

        for(String key : keyset) {
            Row row = sheet.createRow(row1++);
            Object[] resultDetails = testResultDetails.get(key);
            int cellno = 0;
            for (Object obj : resultDetails) {
                Cell cell = row.createCell(cellno++);
                cell.setCellValue((String) obj);
            }
        }

        FileOutputStream write = new FileOutputStream(Report);
        workbook.write(write);
        write.close();

    }


}
