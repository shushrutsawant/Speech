 /*

   ***********************************************************************************************************************
   *                                                                                                                     *
   *  PROGRAMMER:-SHUSHRUT SAWANT
   *
   *  ARTIFICIAL INTELLIGENCE 
   *  SPEECH RECOGNITION
   *  SPEECH SYNTHESISER                                                                                                                   *
   *                                                                                                                     *
   *                                                                                                                     *
   *                                                                                                                     *
   ***********************************************************************************************************************


*/
package friday;

import com.gtranslate.Audio;
import com.gtranslate.Language;
import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import javazoom.jl.decoder.JavaLayerException;


public class FRIDAY {
    
  
    static String resultText;
   
    public static void main(String[] args) throws IOException, URISyntaxException {
        
      //.......................... configuration manager ....................................................
        ConfigurationManager cm;
       if (args.length > 0) {
            cm = new ConfigurationManager(args[0]);
        } else {
            cm = new ConfigurationManager(FRIDAY.class.getResource("helloworld.config.xml"));
        }
         
         Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
                  recognizer.allocate();

        //......................... start the microphone or exit if the programm if this is not possible...................................
        Microphone microphone = (Microphone) cm.lookup("microphone");
        if (!microphone.startRecording()) {
            System.out.println("Cannot start microphone.");
            recognizer.deallocate();
            System.exit(1);
        }
        
      
         
       System.out.println("loding.....");
         while (true) {
            
             
            Result result = recognizer.recognize();
            result.getBestPronunciationResult();
            
            
          
            if(result != null ){
              Application obj = new Application();
             greetings gobj = new greetings();
             sites sobj = new sites();
                
                 String  hello = result.getBestFinalResultNoFiller();  
                
                System.out.println(" you said :" +hello);
                
                
              if(hello.equalsIgnoreCase( "Friday introduce yourself" ))
                {
                     gobj.introduction();
                   
                }
                
                else if(hello.equalsIgnoreCase( "Friday Wakeup" ))
                {
                    
                     gobj.great();
                   
                }
                
                else  if(hello.equalsIgnoreCase( "Friday Are you there" ))
                {
                     gobj.there();
                   
                }
                
 //...................................ends .......greeting..........................................................//              
               
                
//..................................application....................................................................//                
                
                else if(hello.equalsIgnoreCase("open player"))
                {
                     
                       obj.vlcplayer();
                }
                else if (hello.equalsIgnoreCase("open itunes"))
                {
                    
                   obj.itunes();
                }
                else if (hello.equalsIgnoreCase("open web"))
                {
                      
                      obj.web();
                }
 //..........................................open sites.........................................//
                else if(hello.equalsIgnoreCase("open gmail")){
                    
                    sobj.Gmail();
                }
                
                else if(hello.equalsIgnoreCase("open facebook")){
                    
                    sobj.facebook();
                }
                
                else if(hello.equalsIgnoreCase("open youtube")){
                    
                    sobj.youtube();
                }
            } 
             else
            {
             
                System.out.println("cant hear");
            
            }
            
         }
    
     }

}
