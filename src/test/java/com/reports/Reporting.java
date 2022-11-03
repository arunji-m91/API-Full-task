package com.reports;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.baseclass.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass {
	public static void generateJvmReport(String jsonFile) throws IOException {
		File file = new File(getProjectPath() + "\\target");
		Configuration configuration = new Configuration(file, "API Test Result");
		configuration.addClassifications("Browser Name", "Chrome");
		configuration.addClassifications("Browser Version", "104");
		configuration.addClassifications("OS", "Windows 7");
		//configuration.addClassifications("Sprint", "1");
		List<String> jasonFiles = new ArrayList<String>();
		jasonFiles.add(jsonFile);
		ReportBuilder builder = new ReportBuilder(jasonFiles, configuration);
		builder.generateReports();
	}

}
