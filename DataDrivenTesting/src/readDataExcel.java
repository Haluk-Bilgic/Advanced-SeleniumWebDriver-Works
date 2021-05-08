import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class readDataExcel {
    public void readExcel(String filePath,String fileName,String sheetName) throws IOException {

        File file=new File(filePath+"\\"+fileName);//it's created to open xlsx file

        FileInputStream inputStream=new FileInputStream(file);//it's created to read xlsx file

        Workbook workbook=null;

        String fileExtensionName=fileName.substring(fileName.indexOf("."));//it's created to get only extensionName of file

        if (fileExtensionName.equals(".xlsx")){
            workbook=new XSSFWorkbook(inputStream);
        }else if (fileExtensionName.equals(".xls")){
            workbook=new HSSFWorkbook(inputStream);
        }

        Sheet sheet=workbook.getSheet(sheetName);//read sheet inside the workbook by its name
        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
     // or  int rowCount=sheet.getPhysicalNumberOfRows();


        for (int i=0;i<rowCount+1;i++){
            Row row=sheet.getRow(i);
            for (int j=0;j<row.getLastCellNum();j++){
                System.out.print(row.getCell(j).getStringCellValue()+"||");
            }
            System.out.println();
        }
        String deneme=sheet.getRow(1).getCell(1).getStringCellValue(); //to get name of Ankara
        System.out.println(deneme);
    }

    public static void main(String[] args) throws IOException {

readDataExcel excelData=new readDataExcel();
String path=System.getProperty("user.dir");
String excelPath=path+"\\Excel";
excelData.readExcel(excelPath,"data.xlsx","Sheet1");

    }
}
