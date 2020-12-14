#!/usr/bin/env groovy

@Grab('com.xlson.groovycsv:groovycsv:1.0')
import com.xlson.groovycsv.CsvParser


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
      def data = new CsvParser().parse(libraryResource('test.csv'))
      def match = data.find{(it."${matchingColumn}" as String) == "${matchingValue}"}?."${returnColumn}"
      if ( match != null ) {
          return "${match}"
      } else {
          return false
      }
    }
}
