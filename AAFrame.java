package SA_third_5.AAFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;
import SA_third_5.Plugin.WAVPlayerPlugin;
import SA_third_5.Plugin.MP3PlayerPlugin;
import SA_third_5.AboutBox.music;


public class AAFrame extends JFrame {


    private JFileChooser fileChooser = new JFileChooser();
    private LinkedList<music>mylist;
    private WAVPlayerPlugin audioPlay;




    public void init() {
        // 3.在initUI方法中，实例化JFrame类的对象。
        JFrame frame = new JFrame();
        // 4.设置窗体对象的属性值：标题、大小、显示位置、关闭操作、布局、禁止调整大小、可见、...
        frame.setTitle("Login");// 设置窗体的标题
        frame.setSize(500, 400);// 设置窗体的大小，单位是像素
        frame.setDefaultCloseOperation(3);// 设置窗体的关闭操作；3表示关闭窗体退出程序；2、1、0
        frame.setLocationRelativeTo(null);// 设置窗体相对于另一个组件的居中位置，参数null表示窗体相对于屏幕的中央位置
        frame.setResizable(false);// 设置禁止调整窗体大小

        // 实例化FlowLayout流式布局类的对象，指定对齐方式为居中对齐，组件之间的间隔为5个像素
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 10, 10);
        // 实例化流式布局类的对象
        frame.setLayout(fl);



        // 实例化JLabel标签对象，该对象显示"发送消息："
        JButton CHOOSESONG = new JButton("选择歌曲");
        //所选歌曲的消息框
        JTextField SONGName = new JTextField();
        // 将labName标签添加到窗体上
        frame.add(CHOOSESONG);
        CHOOSESONG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                int i = fileChooser.showOpenDialog(frame.getContentPane());// 显示文件选择对话框



                // 判断用户单击的是否为“打开”按钮
                if (i == JFileChooser.APPROVE_OPTION) {

                    File selectedFile = fileChooser.getSelectedFile();// 获得选中的文件对象
                    SONGName.setText(selectedFile.getName());// 显示选中文件的名称
                }



            }
                                     });
        // 实例化JTextField标签对象
        //将要发送的消息

        Dimension dim1 = new Dimension(450,30);
        //textName.setSize(dim);//setSize这方法只对顶级容器有效，其他组件使用无效。
        SONGName.setPreferredSize(dim1);//设置除顶级容器组件其他组件的大小
        // 将textName标签添加到窗体上
        frame.add(SONGName);



        //实例化JButton组件
        Dimension dim2 = new Dimension(150,30);
        JButton LASTONE=new JButton();
        //设置按钮的显示内容
        LASTONE.setText("上一首");
        //设置按钮的大小
        LASTONE.setSize(dim2);
        frame.add(LASTONE);

        JButton PLAY=new JButton();
        PLAY.setText("播放");
        PLAY.setSize(dim2);
        frame.add(PLAY);
        PLAY.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //如果是播放按钮点击事件

                if (mylist.size() != 0) {
                    PLAY.setVisible(false);
                    audioPlay.SetPlayAudioPath("file:" + mylist.get(0).name);
                    audioPlay.play();
                    music mc = mylist.get(0);
                    File file = new File(mc.name + ".wav");
                    //System.out.println(mc.playFileDirectory);
                    //mc.loadlyrics(mc.playFileDirectory, mc.name);

                    int iMusicTime = (int) file.length() / 1024 / 173;
                    //System.out.println(iMusicTime);
                    audioPlay.SetPlayAudioPath("file:" + mylist.get(0).name + ".wav");//设置播放文件
                    audioPlay.play();//开始播放

                }


            }});

        //暂停
        JButton PAUSE=new JButton();
        PAUSE.setText("暂停");
        PAUSE.setSize(dim2);
        frame.add(PAUSE);
        PLAY.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                audioPlay.stop();

            }});


        //
        JButton NEXTONE=new JButton();
        NEXTONE.setText("下一首");
        NEXTONE.setSize(dim2);
        frame.add(NEXTONE);



        frame.setVisible(true);// 设置窗体为可见
    }
}
