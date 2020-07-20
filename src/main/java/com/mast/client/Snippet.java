package com.mast.client;

import static org.opencv.imgcodecs.Imgcodecs.imwrite;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import com.mast.client.tool.Mat2BufferedImage;

public class Snippet {

	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	static String path = "/Users/krystal/Pictures/image";

	private JFrame frame;
	
	private static VideoCapture camera;
	
	// 视频比例 4:3
	private static int conx = 4;
	private static int cony = 3;

	static JLabel label;

	static int flag = 0;// 类静态变量，用于控制按下按钮后 停止摄像头的读取

	/**
	 * 
	 * Launch the application.
	 * 
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Snippet window = new Snippet();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		// 我们的操作
		camera = new VideoCapture();// 创建Opencv中的视频捕捉对象
		camera.open(0);// open函数中的0代表当前计算机中索引为0的摄像头，如果你的计算机有多个摄像头，那么一次1,2,3……
		if (!camera.isOpened()) {// isOpened函数用来判断摄像头调用是否成功
			System.out.println("Camera Error");// 如果摄像头调用失败，输出错误信息
		} else {
			showimage();
/*			Mat frame = new Mat();// 创建一个输出帧
			while (flag == 0) {
				camera.read(frame);// read方法读取摄像头的当前帧
				String fileExtension = System.currentTimeMillis() + ".jpg";
				String filePath = path + File.separator + fileExtension;
				label.setIcon(new ImageIcon(Mat2BufferedImage.Mat2BufImg(frame, ".jpg")));// 转换图像格式并输出
				imwrite(filePath, frame);  // 写图片
				try {
					Thread.sleep(100);// 线程暂停100ms
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
		}
	}
	
	public static void showimage() {
		Mat frame = new Mat();// 创建一个输出帧
		ImageIcon icon;
		while(true) {
			if(flag == 0 ) {
				camera.read(frame);// read方法读取摄像头的当前帧
				icon = new ImageIcon(Mat2BufferedImage.Mat2BufImg(frame, ".jpg"));
				Image img = icon.getImage();
				img = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
				icon.setImage(img);
				label.setIcon(icon);// 转换图像格式并输出
				try {
					Thread.sleep(100);// 线程暂停100ms
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println(flag);
				String fileExtension = System.currentTimeMillis() + ".jpg";
				String filePath = path + File.separator + fileExtension;
				imwrite(filePath, frame);  // 写图片
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flag = 0;
			}
		}
	}

	/**
	 * 
	 * Create the application.
	 * 
	 */
	public Snippet() {
		initialize();
	}

	/**
	 * 
	 * Initialize the contents of the frame.
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton btnNewButton = new JButton("抓拍");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (flag == 0) {
					flag = 1;// 静态变量设置为1，从而按下按钮时会停止摄像头的调用
				}
			}
		});
		btnNewButton.setBounds(33, 13, 113, 27);
		frame.getContentPane().add(btnNewButton);
		label = new JLabel("");
		label.setBounds(0, 0, 450, 450);
		frame.getContentPane().add(label);
		int inset = frame.getInsets().top;
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				// write you code here
				int newWidth = frame.getWidth();
				int newHeight = frame.getHeight();
				int labelWidth = 0;
				int labelHeight = 0;
				if (newWidth * cony > (newHeight - inset) * conx) {
					labelWidth = (newHeight - inset) * conx / cony;
					labelHeight = newHeight - inset;
				} else {
					labelWidth = newWidth;
					labelHeight = newWidth / conx * cony;
				}
				int x = (newWidth - labelWidth) / 2;
				int y = (newHeight - labelHeight - inset) / 2;
				label.setBounds(x, y, labelWidth, labelHeight);
			}
		});
	}
}