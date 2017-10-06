/**
 * 
 */
package com.github.fge.jsonpatch.diffcustom;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jackson.jsonpointer.JsonPointerException;

/**
 * @author Ritesh
 *
 */
public class JsonDataProvider {
	private static ObjectMapper objectMapper = new ObjectMapper();

	@DataProvider(name = "Provide Data To Json-Diff")
	public static Object[][] provideDataDiff() throws JsonProcessingException, IOException {
		JsonNode beforeNode1 = objectMapper.readTree(new File("src/test/resources/jsonpatch/diffcustom/old1.json"));
		JsonNode afterNode1 = objectMapper.readTree(new File("src/test/resources/jsonpatch/diffcustom/new1.json"));

		JsonNode beforeNode2 = objectMapper.readTree(new File("src/test/resources/jsonpatch/diffcustom/old2.json"));
		JsonNode afterNode2 = objectMapper.readTree(new File("src/test/resources/jsonpatch/diffcustom/new2.json"));

		JsonNode beforeNode3 = objectMapper.readTree(new File("src/test/resources/jsonpatch/diffcustom/old3.json"));
		JsonNode afterNode3 = objectMapper.readTree(new File("src/test/resources/jsonpatch/diffcustom/new3.json"));

		JsonNode beforeNode4 = objectMapper.readTree(new File("src/test/resources/jsonpatch/diffcustom/old4.json"));
		JsonNode afterNode4 = objectMapper.readTree(new File("src/test/resources/jsonpatch/diffcustom/new4.json"));

		JsonNode beforeNode5 = objectMapper.readTree(new File("src/test/resources/jsonpatch/diffcustom/old5.json"));
		JsonNode afterNode5 = objectMapper.readTree(new File("src/test/resources/jsonpatch/diffcustom/new5.json"));

		JsonNode beforeNode6 = objectMapper.readTree(new File("src/test/resources/jsonpatch/diffcustom/old6.json"));
		JsonNode afterNode6 = objectMapper.readTree(new File("src/test/resources/jsonpatch/diffcustom/new6.json"));

		JsonNode sampleold = objectMapper.readTree(new File("src/test/resources/jsonpatch/diffcustom/sampleold.json"));
		JsonNode samplenew = objectMapper.readTree(new File("src/test/resources/jsonpatch/diffcustom/samplenew.json"));
		return new Object[][] { 
			{ beforeNode1, afterNode1 }, 
			{ beforeNode2, afterNode2 }, 
			{ beforeNode3, afterNode3 },
			{ beforeNode4, afterNode4 }, 
			{ beforeNode5, afterNode5 }, 
			{ beforeNode6, afterNode6 },
			{ sampleold, samplenew } 	};
	}

	@DataProvider(name = "Array Operation")
	public static Object[][] dataForArrayRemoveOperaation()
			throws JsonPointerException, JsonProcessingException, IOException {

		JsonNode arrayObjectRemovalOLD = objectMapper
				.readTree(new File("src/test/resources/jsonpatch/diffcustom/arrayObjectRemovalOLD.json"));
		JsonNode arrayObjectRemovalNEW = objectMapper
				.readTree(new File("src/test/resources/jsonpatch/diffcustom/arrayObjectRemovalNEW.json"));

		JsonNode arrayObjectReplaceOLD = objectMapper
				.readTree(new File("src/test/resources/jsonpatch/diffcustom/arrayObjectReplaceOLD.json"));
		JsonNode arrayObjectReplaceNEW = objectMapper
				.readTree(new File("src/test/resources/jsonpatch/diffcustom/arrayObjectReplaceNEW.json"));

		JsonNode arrayObjectAddOLD = objectMapper
				.readTree(new File("src/test/resources/jsonpatch/diffcustom/arrayObjectAddOLD.json"));
		JsonNode arrayObjectAddNEW = objectMapper
				.readTree(new File("src/test/resources/jsonpatch/diffcustom/arrayObjectAddNEW.json"));

		JsonNode nullEmptyOLD = objectMapper
				.readTree(new File("src/test/resources/jsonpatch/diffcustom/nullEmptyOLD.json"));
		JsonNode nullEmptyNEW = objectMapper
				.readTree(new File("src/test/resources/jsonpatch/diffcustom/nullEmptyNEW.json"));

		return new Object[][] {
				{ arrayObjectRemovalOLD, arrayObjectRemovalNEW }, // Remove
				{ arrayObjectRemovalNEW, arrayObjectRemovalOLD }, // add
				{ arrayObjectReplaceOLD, arrayObjectReplaceNEW }, // replace
				{ arrayObjectReplaceNEW, arrayObjectReplaceOLD }, // replace
				{ arrayObjectAddOLD, arrayObjectAddNEW }, // add
				{ arrayObjectAddNEW, arrayObjectAddOLD }, // remove
				{ nullEmptyOLD, nullEmptyNEW }, // null old
				{ nullEmptyNEW, nullEmptyOLD } // null new
		};
	}

}