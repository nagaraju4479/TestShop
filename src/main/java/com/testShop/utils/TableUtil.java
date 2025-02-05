package com.testShop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class TableUtil {

    /**
     * Gets the number of rows in the table.
     *
     * @param driver  The WebDriver instance.
     * @param tableLocator The By locator to find the table element.
     * @return The number of rows in the table.
     */
    public static int getRowCount(WebDriver driver, By tableLocator) {
        WebElement table = driver.findElement(tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        return rows.size();
    }

    /**
     * Gets the number of columns in the table.
     *
     * @param driver  The WebDriver instance.
     * @param tableLocator The By locator to find the table element.
     * @return The number of columns in the table.
     */
    public static int getColumnCount(WebDriver driver, By tableLocator) {
        WebElement table = driver.findElement(tableLocator);
        WebElement headerRow = table.findElement(By.tagName("tr"));
        List<WebElement> columns = headerRow.findElements(By.tagName("th"));
        return columns.size();
    }

    /**
     * Gets the data from a specific cell.
     *
     * @param driver    The WebDriver instance.
     * @param tableLocator The By locator to find the table element.
     * @param row       The row number (0-based index).
     * @param column    The column number (0-based index).
     * @return The data from the specified cell.
     */
    public static String getCellData(WebDriver driver, By tableLocator, int row, int column) {
        WebElement table = driver.findElement(tableLocator);
        WebElement cell = table.findElements(By.tagName("tr")).get(row).findElements(By.tagName("td")).get(column);
        return cell.getText();
    }

    /**
     * Gets data from a specific column.
     *
     * @param driver  The WebDriver instance.
     * @param tableLocator The By locator to find the table element.
     * @param column The column number (0-based index).
     * @return A list of data from the specified column.
     */
    public static List<String> getColumnData(WebDriver driver, By tableLocator, int column) {
        List<String> columnData = new ArrayList<>();
        WebElement table = driver.findElement(tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() > column) {
                columnData.add(cells.get(column).getText());
            }
        }
        return columnData;
    }

    /**
     * Gets data from a specific row.
     *
     * @param driver  The WebDriver instance.
     * @param tableLocator The By locator to find the table element.
     * @param row    The row number (0-based index).
     * @return A list of data from the specified row.
     */
    public static List<String> getRowData(WebDriver driver, By tableLocator, int row) {
        List<String> rowData = new ArrayList<>();
        WebElement table = driver.findElement(tableLocator);
        List<WebElement> cells = table.findElements(By.tagName("tr")).get(row).findElements(By.tagName("td"));
        for (WebElement cell : cells) {
            rowData.add(cell.getText());
        }
        return rowData;
    }

    /**
     * Finds a cell with specific text.
     *
     * @param driver  The WebDriver instance.
     * @param tableLocator The By locator to find the table element.
     * @param text    The text to search for.
     * @return The WebElement of the cell containing the text, or null if not found.
     */
    public static WebElement findCellWithText(WebDriver driver, By tableLocator, String text) {
        WebElement table = driver.findElement(tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                if (cell.getText().equals(text)) {
                    return cell;
                }
            }
        }
        return null;
    }

    /**
     * Clicks a cell in the table.
     *
     * @param driver  The WebDriver instance.
     * @param tableLocator The By locator to find the table element.
     * @param row     The row number (0-based index).
     * @param column  The column number (0-based index).
     */
    public static void clickCell(WebDriver driver, By tableLocator, int row, int column) {
        WebElement table = driver.findElement(tableLocator);
        WebElement cell = table.findElements(By.tagName("tr")).get(row).findElements(By.tagName("td")).get(column);
        cell.click();
    }

    /**
     * Clicks a button or link inside a cell.
     *
     * @param driver  The WebDriver instance.
     * @param tableLocator The By locator to find the table element.
     * @param row     The row number (0-based index).
     * @param column  The column number (0-based index).
     * @param elementTag The tag of the element to click (e.g., "a" for links, "button" for buttons).
     */
    public static void clickCellButton(WebDriver driver, By tableLocator, int row, int column, String elementTag) {
        WebElement table = driver.findElement(tableLocator);
        WebElement cell = table.findElements(By.tagName("tr")).get(row).findElements(By.tagName("td")).get(column);
        WebElement elementToClick = cell.findElement(By.tagName(elementTag));
        elementToClick.click();
        
     
        
    }
}
