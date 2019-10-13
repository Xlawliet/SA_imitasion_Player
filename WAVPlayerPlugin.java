package SA_third_5.Plugin;

import javax.sound.sampled.AudioSystem;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class WAVPlayerPlugin implements Runnable,IPlayerPlugin {
    AudioClip adc;// 声音音频剪辑对象
    URL url;
    boolean adcFlag=false;
    boolean playFlag=false;
    public void SetPlayAudioPath(String path){
        try{
            url = new URL(path);
            // System.out.println(adc.toString());
            if(adcFlag==true){adc.stop();playFlag=false;}
            adc = Applet.newAudioClip(url);
            adcFlag=true;
        }
        catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
    }


    @Override
    public void loadFile(String name) {
        try{

        }catch (Exception e){
        }
    }

    @Override
    public void play() {
        adc.play();
        playFlag=true;

    }

    @Override
    public void stop() {
        adc.stop();
        playFlag=false;
    }

    @Override
    public void pause() {
         }

    @Override
    public void run() {

    }
}
