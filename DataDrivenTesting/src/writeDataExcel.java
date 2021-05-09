import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class writeDataExcel {

    public void writeExcel(String filePath,String fileName,String sheetName,String []dataWrite) throws IOException {

        File file=new File(filePath+"\\"+fileName);//it's created to open excel file

        FileInputStream inputStream=new FileInputStream(file);//it's created to read excel file

        Workbook workbook=null;

        String fileExtensionName=fileName.substring(fileName.indexOf("."));//it's created to get only extensionName of file

        if (fileExtensionName.equals(".xlsx")){
            workbook=new XSSFWorkbook(inputStream);
        }else if (fileExtensionName.equals(".xls")){
            workbook=new HSSFWorkbook(inputStream);
        }
        Sheet sheet=workbook.getSheet(sheetName);//read sheet inside the workbook by its name
        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();

        Row row=sheet.getRow(0); //get the first row the sheet

        Row newRow=sheet.createRow(rowCount+1);//create a new row to append it at last of sheet

        for (int i=0;i<row.getLastCellNum();i++){ //fill data in new row
            Cell cell=newRow.createCell(i);
            cell.setCellValue(dataWrite[i]);
        }
     //   inputStream.close();

        FileOutputStream outputStream=new FileOutputStream(file);  //it's created to write data in excel file

        workbook.write(outputStream); //write data in excel file

        //outputStream.close();
    }

    public static void main(String[] args) throws IOException {

           String []value={"john","konya"};
           writeDataExcel excelData=new writeDataExcel();

            String path=System.getProperty("user.dir");
            String excelPath=path+"\\Excel";
            excelData.writeExcel(excelPath,"data.xlsx","Sheet1",value);

    }
}
