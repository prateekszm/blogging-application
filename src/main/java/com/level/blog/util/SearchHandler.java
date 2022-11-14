package com.level.blog.util;
import java.util.ArrayList;
import java.util.HashMap;

/*
This class is responsible to convert Json to seach handler the Json must be in
This should be a hash map
{"fieldName": "value","fieldName2": "value2"}
* */
/*
TODO:
     -Search with in 1 table
     -Search with in 2 table
     -Scope for paginationT
     -
*/
public interface SearchHandler {
    String jsonToSearchQuery(String json,Integer start,Integer limit);
    String jsonToSearchQuery(HashMap<String,String>fieldValueMap , Integer start, Integer limit);

}
