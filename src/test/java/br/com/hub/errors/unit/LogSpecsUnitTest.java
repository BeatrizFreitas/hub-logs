package br.com.hub.errors.unit;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.Predicate;


public class LogSpecsUnitTest {
    
    @Test
    public void sendsRepeatedParameters_thenConsidersOnlyOne() {
        List<Predicate> predicates;
        Map<String,String> allParams = new HashMap<>();

        allParams.put("date", "2019-05-28");
        allParams.put("errorLevel", "WARNING");
        allParams.put("date", "2019-05-28");
        allParams.put("date", "2019-05-28");


    }
}
