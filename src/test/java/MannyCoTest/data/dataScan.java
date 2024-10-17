package MannyCoTest.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;



public class dataScan {

	
	public List<HashMap<String, String>> jsonToMap(String fileName) throws IOException
	{
		
		//This is reading the created data json file to string
	String jsonFile =	FileUtils.readFileToString(new File (System.getProperty("user.dir")+"//src//test//java//MannyCoTest//data//jsonData.json")
			,StandardCharsets.UTF_8);
		
	ObjectMapper mapper = new ObjectMapper();	
	
	List<HashMap<String, String>> data = mapper.readValue(jsonFile, new TypeReference <List<HashMap<String, String>>>(){
		
	});
	return data;
	
	}
	
}
