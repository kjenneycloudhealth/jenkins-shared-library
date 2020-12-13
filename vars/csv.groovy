#!/usr/bin/env groovy

/**
 * Given matchingValue in matchingColumn
 * @param matchingValue The value that is in matchingColumn
 * @param matchingColumn The column to search
 * @return boolean
 * @see #checkValue(String)
 */
Object checkValue(String matchingValue, String matchingColumn) {
    def column_number = sh(returnStdout: true, script: awk -F',' '{for(i=1;i<=NF;i++) {if($i == "${matchingColumn}") printf("%d", i)} exit 0 }' libraryResource('test.csv'))
    def map_script= $/grep \^${matchingValue} libraryResource('test.csv') | awk -F ',' '{print ${column_number}}'/$
    match = sh(returnStdout: true, script: map_script).trim()
    if ( match != null ) {
        return true
    } else {
        return false
    }
}

/**
 * Given matchingValue in matchingColumn return the value in returnColumn
 * Use verifyValue first to confirm the value is present
 * @param matchingValue The value that is in matchingColumn
 * @param matchingColumn The column to search
 * @param returnColumn The column to return
 * @return The value in returnColumn in the row of matchingValue
 * @see #matchValue(String)
 */
Object matchValue(String matchingValue, String matchingColumn, String returnColumn) {

}
