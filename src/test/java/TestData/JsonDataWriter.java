package TestData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonDataWriter {


	private HashMap<String,String> jWriteData = new HashMap<String, String>();


	@SuppressWarnings({ "unchecked", "resource" })
	public void JsonWriteData(String jsonFilePath, String jObject, String [] jKeys, String[] jValues) throws IOException
	{

		JSONObject obj = new JSONObject();
		JSONArray jArray = new JSONArray();

		int i;
		int j;
		for ( i = 0; i<jKeys.length;i++)
		{

			for ( j = 0; j<jValues.length; j++)
			{
				if (i == j)
				{
					jWriteData.put(jKeys[i] ,jValues[j] );
					break;
					//obj.put(jObject, jData);	
				}
				
			}

			
		}
		//hashObj = (JSONObject) jWriteData;
		obj.put(jObject,jWriteData);
		
		jArray.add(obj);

		FileWriter file = new FileWriter(jsonFilePath);
		BufferedWriter bufferWriter = new BufferedWriter(file);
		bufferWriter.write(jArray.toJSONString());
		bufferWriter.newLine();
		bufferWriter.flush();


	}
}
