package fil.iagl.opl.helper;

import fil.iagl.opl.handler.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HelperManager {

    public void helperGenerator(List<DetectedAntiPattern> antiPatterns){
        Set<String> antiPatternsDetected = new HashSet<String>();

        for(DetectedAntiPattern antiPattern : antiPatterns){
            antiPatternsDetected.add(antiPattern.getAntiPattern().toString());
        }

        for(String antiPatternType : antiPatternsDetected){
            if(antiPatternType == "Blob"){
                Blob blob = new Blob();
                blob.helper();
            }
            else if(antiPatternType == "SpaghettiCode"){
                SpaghettiCode spaghettiCode = new SpaghettiCode();
                spaghettiCode.helper();
            }
            else if(antiPatternType == "TooManyParameters"){
                TooManyParameters tooManyParameters = new TooManyParameters();
                tooManyParameters.helper();
            }
            else if(antiPatternType == "BooleanParameter"){
                BooleanParameter booleanParameter = new BooleanParameter();
                booleanParameter.helper();
            }
        }
    }

}
