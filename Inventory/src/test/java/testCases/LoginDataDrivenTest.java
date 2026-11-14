package testCases;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginDataDrivenTest {

    // 1. DataProvider returning Object[][] where each row holds one HashMap
    @DataProvider(name = "excelData")
    public Object[][] getExcelData() throws IOException {
        String filePath = "./src/test/resources/TestData.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("LoginData");

        int rowCount = sheet.getLastRowNum(); // Excludes header row (index 0)
        int colCount = sheet.getRow(0).getLastCellNum();

        // Create Object[][] with size [rowCount][1] because each row is stored in 1 Map
        Object[][] data = new Object[rowCount][1];
        DataFormatter formatter = new DataFormatter(); // Safely converts numbers/strings to String

        Row headerRow = sheet.getRow(0);

        for (int i = 1; i <= rowCount; i++) {
            Row currentRow = sheet.getRow(i);
            Map<String, String> rowMap = new HashMap<>();

            for (int j = 0; j < colCount; j++) {
                String key = formatter.formatCellValue(headerRow.getCell(j));
                String value = formatter.formatCellValue(currentRow.getCell(j));
                rowMap.put(key, value); // Key = Column Header, Value = Cell Data
            }

            data[i - 1][0] = rowMap;
        }

        workbook.close();
        fis.close();
        return data;
    }

    // 2. Test method accepts only ONE parameter (HashMap) instead of multiple Strings
    @Test(dataProvider = "excelData")
    public void verifyLogin(HashMap<String, String> testData) {
        String user = testData.get("username");
        String pass = testData.get("password");
        String expected = testData.get("expectedTitle");

        System.out.println("Testing with: " + user + " | " + pass + " | Expected: " + expected);

    }
}
