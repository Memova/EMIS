package com.emis.tasks.junior.scores;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class WorkbookCreator {

	public static void main(String[] args) {

		SXSSFWorkbook workbook = new SXSSFWorkbook();
		SXSSFSheet spreadsheet = workbook.createSheet("Scores Info");
		SXSSFRow row;
		SXSSFCell cellA;
		SXSSFCell cellB;
		SXSSFCell cellC;

		CellStyle headerRowStyle = createHeaderRowStyle(workbook);
		
		// create the header row
		SXSSFRow headerRow = spreadsheet.createRow(0);
		cellA = headerRow.createCell(0, CellType.STRING);
		cellA.setCellStyle(headerRowStyle);
		cellA.setCellValue("Name");
		cellB = headerRow.createCell(1, CellType.STRING);
		cellB.setCellStyle(headerRowStyle);
		cellB.setCellValue("Age");
		cellC = headerRow.createCell(2, CellType.STRING);
		cellC.setCellStyle(headerRowStyle);
		cellC.setCellValue("Scores");
		SXSSFCell cellD = headerRow.createCell(3);
		cellD.setCellStyle(headerRowStyle);
		SXSSFCell cellE = headerRow.createCell(4, CellType.STRING);
		cellE.setCellStyle(headerRowStyle);
		cellE.setCellValue("Average score");
		spreadsheet.trackColumnForAutoSizing(4);
		spreadsheet.autoSizeColumn(4);

		Font oddFont = workbook.createFont();
		oddFont.setColor(IndexedColors.GREEN.index);
		CellStyle oddRowStyle = workbook.createCellStyle();
		oddRowStyle.setFont(oddFont);

		// create the rest of the rows
		int i = 1;

		while (i <= 100000) {
			Person person = new Person();

			row = spreadsheet.createRow(i);
			cellA = row.createCell(0, CellType.STRING);
			cellB = row.createCell(1, CellType.NUMERIC);
			cellC = row.createCell(2, CellType.NUMERIC);

			cellA.setCellValue(person.getName());
			cellB.setCellValue(person.getAge());
			cellC.setCellValue(person.getScore());
			
			if (i == 1) {
				cellE = row.createCell(4, CellType.FORMULA);
				cellE.setCellFormula("AVERAGE(C2:C101)");
			}

			if (i % 2 == 0) {
				cellA.setCellStyle(oddRowStyle);
				cellB.setCellStyle(oddRowStyle);
				cellC.setCellStyle(oddRowStyle);
			}

			i++;
		}

		FileOutputStream out;
		try {
			out = new FileOutputStream(new File("scores.xlsx"));
			workbook.write(out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static CellStyle createHeaderRowStyle(SXSSFWorkbook workbook) {
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.PALE_BLUE.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(headerFont);
		return style;
	}
}
