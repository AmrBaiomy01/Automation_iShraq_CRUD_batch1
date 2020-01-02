package TestData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReaderOnPage

{

	//create private hashtable to read data from json file
	private Hashtable<String,String> jData = new Hashtable<String,String>();

	//create method to read the desired object, keys and testcaseinputs then return a hashtable of (key and value)
	public Hashtable<String,String> JsonReaderData(String jsonFilePath,
			String jObject, String [] jKeys, String[] testCaseInputs) 
					throws FileNotFoundException, IOException, ParseException {

		//define json file path and read the data from it into a json array
		// Json file path for Fund testcase --> "/src/test/java/TestData/FundData.json"
		JSONParser parser = new JSONParser();
		String filePath = System.getProperty("user.dir") + jsonFilePath;
		File jFile = new File(filePath);
		JSONArray jArray = (JSONArray) parser.parse(new FileReader(jFile));

		//looping on objects of Json array
		for (Object jsonObj : jArray)
		{
			JSONObject jObj = (JSONObject) jsonObj;	

			if (jObj.get(jObject) != null) 
			{
				JSONObject testCasesObj = (JSONObject) jObj.get(jObject);
				//looping on every key and value under each object
				int i;
				int j;
				for ( i = 0; i<jKeys.length;i++)
				{
					for ( j = 0; j<testCaseInputs.length; j++)
					{

						if (jKeys[i] == testCaseInputs[j])
						{
							jData.put(jKeys[i], (String) testCasesObj.get(jKeys[i]));
							break;
						}
					}
				}
			}

		}
		return jData;
	}

	//Method to read json file from Test Data Packages Each method for module
	//Sector (18)
	public static JSONArray ReadFromJsonSector(String module) throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		JSONParser parser = new JSONParser();
		//String property = "java.io.tmpdir";
		//System.out.println(System.getProperty(property));

		//String tempDir = System.getProperty(property);
		//Sector Module
		String Sector = System.getProperty("user.dir")+("\\src\\test\\java\\TestData\\"+module+".json");
		JSONArray SectorModuleObjects = (JSONArray) parser.parse(new FileReader(Sector));
		return SectorModuleObjects;
	}

	//Document Types (150018)
	public static JSONArray ReadFromJsonDocumentTypes(String module) throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		JSONParser parser = new JSONParser();
		//String property = "java.io.tmpdir";
		//System.out.println(System.getProperty(property));

		//Document Types Module
		String DocumentTypes = System.getProperty("user.dir")+("\\src\\test\\java\\TestData\\"+module+".json");
		JSONArray DocumentTypesModuleObjects = (JSONArray) parser.parse(new FileReader(DocumentTypes));

		//JSONArray xzArray = (JSONArray) parser.parse(new FileReader(tempDire2));
		return DocumentTypesModuleObjects;
		//return xzArray;
	}

	//Regions (44)
	public static JSONArray ReadFromJsonRegions(String module) throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		JSONParser parser = new JSONParser();
		//String property = "java.io.tmpdir";
		//System.out.println(System.getProperty(property));

		//Document Types Module
		String DocumentTypes = System.getProperty("user.dir")+("\\src\\main\\java\\testData"+module+".json");
		JSONArray RegionsModuleObjects = (JSONArray) parser.parse(new FileReader(DocumentTypes));

		//JSONArray xzArray = (JSONArray) parser.parse(new FileReader(tempDire2));
		return RegionsModuleObjects;

	}

	//Customer Scoring Attributes (17005001)
	public static JSONArray ReadFromJsonCustomerScoringAttributes(String module) throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		JSONParser parser = new JSONParser();
		//Customer Scoring Attributes Module
		String DocumentTypes = System.getProperty("user.dir")+("\\src\\test\\java\\TestData\\"+module+".json");
		JSONArray CustomerScoringAttributesModuleObjects = (JSONArray) parser.parse(new FileReader(DocumentTypes));
		return CustomerScoringAttributesModuleObjects;

	}	
	//Annual Income (2000000150)
	public static JSONArray ReadFromJsonAnnualIncome(String module) throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		JSONParser parser = new JSONParser();
		//Customer Scoring Attributes Module
		String DocumentTypes = System.getProperty("user.dir")+("\\src\\test\\java\\TestData\\"+module+".json");
		JSONArray AnnualIncomeModuleObjects = (JSONArray) parser.parse(new FileReader(DocumentTypes));
		return AnnualIncomeModuleObjects;

	}	
	//Banks (15002423)
		public static JSONArray ReadFromJsonBanks(String module) throws FileNotFoundException, IOException, ParseException, InterruptedException
		{
			JSONParser parser = new JSONParser();
			//Customer Scoring Attributes Module
			String DocumentTypes = System.getProperty("user.dir")+("\\src\\test\\java\\TestData\\"+module+".json");
			JSONArray BanksModuleObjects = (JSONArray) parser.parse(new FileReader(DocumentTypes));
			return BanksModuleObjects;

		}
}

