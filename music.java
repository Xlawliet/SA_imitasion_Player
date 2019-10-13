package SA_third_5.AboutBox;

import java.util.LinkedList;

public class music {
    public LinkedList<String> Lyricslist=new LinkedList<String>();//歌曲歌手和歌词信息
    public LinkedList<String> Lyrics=new LinkedList<String>();//歌词信息
    public LinkedList<Integer> Lyricstime=new LinkedList<Integer>();//歌词时间信息
    public String name;//歌曲名称
    public String songer;//歌手
    public String time;//总时长
    public String playFileDirectory;//文件路径

    music(String na,String ti)
    {
        this.name=na;
        this.time=ti;
    }
}
