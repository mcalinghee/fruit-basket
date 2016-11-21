package com.nuvelvision.startup;


import java.nio.file.Paths;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BootstrapTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void startWithWrongFilePath() throws Exception{
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Failed to read the file : \\basket.txt (No such file or directory)");
		Bootstrap.main(new String[]{"\\basket.txt"});
	}
	
	@Test
	public void startWithCorrectFilePathTest() throws Exception{
		Bootstrap.main(new String[]{Paths.get("src/test/resources/basket.txt").toAbsolutePath().toString()});
	}
	

}
