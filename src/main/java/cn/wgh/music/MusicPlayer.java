package cn.wgh.music;

import java.io.*;
import java.util.Iterator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.player.Player;
public class MusicPlayer extends JFrame {

	boolean isStop = true;// 控制播放线程
	boolean hasStop = true;// 播放线程状态

	String filepath;// 播放文件目录
	String filename;// 播放文件名称
	String urlStr;
	AudioInputStream audioInputStream;// 音频文件流
	AudioFormat audioFormat;// 音频文件格式
	SourceDataLine sourceDataLine;// 接口：源数据行，可以写入音频数据

	List list;// 文件列表
	JLabel labelfilepath;// 播放目录显示标签
	JLabel labelURL;
	JLabel labelfilename;// 播放文件显示标签
	TextArea textArea;
	JMenuBar menubar;
	JMenu menufile;
	JMenuItem opensong;
	JMenuItem openURL;
	JPanel panelmain;
	Container container;
	JPanel paneright;
	JTextField textField;
	Container container2;
	URL url;

	static int testtimethread;

	public MusicPlayer() {
		// Framework
		this.setLayout(new BorderLayout());
		this.setTitle("Player");
		this.setSize(400, 300);

		// Menu
		menubar = new JMenuBar();
		menufile = new JMenu("File");
		opensong = new JMenuItem("Open file");
		openURL = new JMenuItem("Open URL");

		menufile.add(opensong);
		menufile.add(openURL);
		menubar.add(menufile);

		this.setVisible(true);
		this.setJMenuBar(menubar);

		opensong.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				openFile();

			}
		});
		openURL.addActionListener(new ActionListener() { // 打开URL按钮事件处理
			public void actionPerformed(ActionEvent e) {
				String addressName = JOptionPane.showInputDialog(MusicPlayer.this, "URL address");
				if (addressName != null) {
					openURL(addressName);
				}
			}
		});
		//
		list = new List();
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// mouse
				if (e.getClickCount() == 2) {
					// double kick
					filename = list.getSelectedItem();
					testtimethread++;
					if (filename != null) {
						play();
					} else {
//						playURL pla = new playURL(urlStr);

					}
				}
			}
		});

		//
		panelmain = new JPanel(new GridLayout(2, 1));
		container = new Container();
		container.setLayout(new GridLayout(1, 1));
		this.add(panelmain, BorderLayout.NORTH);
		this.add(container, BorderLayout.CENTER);
		labelfilepath = new JLabel("file path:");
		labelURL = new JLabel("URL");
		labelfilename = new JLabel("name:");
		panelmain.add(labelfilepath);
		panelmain.add(labelURL);
		panelmain.add(labelfilename);
		textField = new JTextField();
		textArea = new TextArea();
		textArea.enableInputMethods(false);

		container.add(list);

		// close
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setVisible(true);
	}

	private void openFile() {
		FileDialog dialog1 = new FileDialog(this, "chose music", FileDialog.LOAD);
		dialog1.setVisible(true);

		filepath = dialog1.getDirectory();
		String filename = dialog1.getFile();
		if (!(filename.endsWith("mp3") || filename.endsWith("wav"))) {
			JOptionPane.showMessageDialog(null, "mp3 or wav");
			System.exit(0);
		}
		if (filepath != null) {
			labelfilepath.setText("Play list" + filepath);
			list.add(filename);
		}
	}

	private void openURL(String str) {
		urlStr = str;
		try {
			url = new URL(str);
		} catch (Exception ex) {

		}
		if (!(str.endsWith("mp3") || str.endsWith("wav"))) {
			JOptionPane.showMessageDialog(null, "mp3 or wav");
			System.exit(0);
		}
		labelURL.setText("Play list" + str);
		list.add(str);
	}

	private void play() {
		try {
			isStop = true;// 停止播放线程
			// 等待播放线程停止
			while (!hasStop) {
				// System.out.print(".");
				try {
					Thread.sleep(10);
				} catch (Exception e) {

				}
			}
			File file = new File(filepath + filename);
			labelfilename.setText("file" + filename);

			// 取得文件输入流
			audioInputStream = AudioSystem.getAudioInputStream(file);
			audioFormat = audioInputStream.getFormat();

			if (audioFormat.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {// 编码不符合默认要求
				// 定义新的文件格式，
				audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, audioFormat.getSampleRate(), 16,
						audioFormat.getChannels(), audioFormat.getChannels() * 2, audioFormat.getSampleRate(), false);
				// 利用新的文件格式和音频输入流构造新的音频输入流
				audioInputStream = AudioSystem.getAudioInputStream(audioFormat, audioInputStream);
			}

			// 构造数据行
			DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat,
					AudioSystem.NOT_SPECIFIED);
			sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);// 将数据行读入源数据行
			sourceDataLine.open(audioFormat);
			sourceDataLine.start();// 允许源数据行操作（I/O）该数据行

			// 创建独立线程进行播放
			isStop = false;
			Thread playThread = new Thread(new PlayThread());
			playThread.start();
		} catch (Exception e) {
			e.printStackTrace();// 输出到标准错误流
		}
	}

	public static void main(String args[]) {
		new MusicPlayer();
	}

	// 播放线程
	class PlayThread extends Thread {
		byte tempBuffer[] = new byte[320];

		public void run() {
			try {
				int cnt;
				hasStop = false;
				// 读取数据到缓存数据
				while ((cnt = audioInputStream.read(tempBuffer, 0, tempBuffer.length)) != -1) {// ending
																								// test
					if (isStop)
						break;
					if (cnt > 0) {
						// 将缓存的音频数据写入混频器

						sourceDataLine.write(tempBuffer, 0, cnt);

						labelfilename.setText("song:" + filename);
					}
				}
				// Block等待临时数据被输出为空
				sourceDataLine.drain();
				sourceDataLine.close();// 关闭行
				hasStop = true;
			} catch (Exception e) {

				System.exit(0);
			}
		}
	}
}