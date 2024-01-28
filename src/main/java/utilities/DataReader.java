package utilities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.List;

public class DataReader {
    static FileInputStream stream=null;
    MyLogger logger = new MyLogger();
    private FileInputStream getFileInputStream(String path)
    {

        File src = new File(path);
        try {
            stream = new FileInputStream(src);
        }
        catch (FileNotFoundException e){
            System.out.println("Error Occurred"+ e.getMessage());
        }
        return stream;

    }
    public Object[][] readDataFromExcel(String path, int numberOfColumns) throws IOException {
        int totalNumberOfColumns =numberOfColumns;
        int totalNumberOfRows;
        stream=getFileInputStream(path);

        XSSFWorkbook workBook = new XSSFWorkbook(stream);
        XSSFSheet workSheet = workBook.getSheetAt(0);
        totalNumberOfRows = workSheet.getLastRowNum()+1  ;

        String[][] arrayExcelData = new String[totalNumberOfRows][totalNumberOfColumns];
        for(int i=0; i<totalNumberOfRows;i++)
        {
            XSSFRow row = workSheet.getRow(i);
            for(int j=0; j<totalNumberOfColumns; j++)
            {
                arrayExcelData[i][j]=row.getCell(j).toString();
            }
        }
        workBook.close();
        return arrayExcelData;

    }

    public  Object[][] readDataFromCsv(String path)  {

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            logger.writeErrorInLogFile(e);
        }
        List<String[]> records= null;
        try {
            records = reader.readAll();
        } catch (IOException e) {
            logger.writeErrorInLogFile(e);
        } catch (CsvException e) {
            logger.writeErrorInLogFile(e);
        }
        String[][] obj= new String[records.size()][records.get(0).length];
        for(int i = 0 ; i<records.size(); i++)
        {
            obj[i]=records.get(i);
        }
        return obj;
    }
    public String[] readLocatorsFromJsonFile(String locatorName){
        File src = new File(System.getProperty("user.dir")+"/locators.json");
        JSONParser parser = new JSONParser();
        JSONArray jsonArray;
        try {
            jsonArray= (JSONArray) parser.parse(new FileReader(src));
            for(int i=0; i<jsonArray.size();i++){
                JSONObject obj =(JSONObject) jsonArray.get(i);
                if(locatorName.equalsIgnoreCase((String) obj.get("name"))){
                   return new String[]{(String) obj.get("value"), (String) obj.get("type")};
                }

            }
        } catch (IOException e) {
            logger.writeErrorInLogFile(e);
        } catch (ParseException e) {
            logger.writeErrorInLogFile(e);
        }
        try{
            throw new Exception("There is no element with the name: "+ locatorName + " in the file");
        }catch (Exception e){
            logger.writeErrorInLogFile(e);
        }
        return null;
    }
public JSONObject readJsonFile (String filePath) throws FileNotFoundException {
        InputStream is = new FileInputStream(filePath);
        JSONTokener tok = new JSONTokener(is);
        return new JSONObject(tok);
}

}
