package com.mast.client;
import org.opencv.core.*;
import org.opencv.imgcodecs.*;
import org.opencv.objdetect.*;
import org.opencv.imgproc.*;
 
public class DetectBody {
	public static void main(String[] args) {
		try {
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
 
			Mat src = Imgcodecs.imread("E:/work/qqq/b5.jpg");
			Imgcodecs.imwrite("E:/work/qqq/hh81.jpg", getUpperBody(src));
			Imgcodecs.imwrite("E:/work/qqq/hh82.jpg", getLefteye(src));
			Imgcodecs.imwrite("E:/work/qqq/hh83.jpg", getRighteye(src));
			// Imgcodecs.imwrite("E:/work/qqq/hh8.jpg", getLeftear(src));
			// Imgcodecs.imwrite("E:/work/qqq/hh8.jpg", getRightear(src));
			Imgcodecs.imwrite("E:/work/qqq/hh84.jpg", getMouth(src));
			Imgcodecs.imwrite("E:/work/qqq/hh85.jpg", getNose(src));
			// Imgcodecs.imwrite("E:/work/qqq/hh8.jpg", getSmile(src));
			// Imgcodecs.imwrite("E:/work/qqq/hh8.jpg", getLowerBody(src));
			// Imgcodecs.imwrite("E:/work/qqq/hh8.jpg", getFullBody(src));
			Imgcodecs.imwrite("E:/work/qqq/hh86.jpg", getFace(src));
			Imgcodecs.imwrite("E:/work/qqq/hh87.jpg", getProfileFace(getFace(src)));
 
			CascadeClassifier faceDetector = new CascadeClassifier("./resource/haarcascade_frontalface_alt2.xml");
			MatOfRect objDetections2 = new MatOfRect();
			faceDetector.detectMultiScale(src, objDetections2);
			for (Rect rect : objDetections2.toArray()) {
				Imgproc.rectangle(src, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
						new Scalar(0, 0, 255), 2);
				Mat s = src.submat(rect);
				getLefteye(s).copyTo(s);
			}
 
			Imgcodecs.imwrite("E:/work/qqq/hh88.jpg", src);
		} catch (Exception e) {
			System.out.println("例外：" + e);
		}
 
	}
 
	public static Mat getUpperBody(Mat src) {
		Mat result = src.clone();
		if (src.cols() > 1000 || src.rows() > 1000) {
			Imgproc.resize(src, result, new Size(src.cols() / 3, src.rows() / 3));
		}
 
		CascadeClassifier faceDetector = new CascadeClassifier("./resource/haarcascade_mcs_upperbody.xml");
		MatOfRect objDetections = new MatOfRect();
		faceDetector.detectMultiScale(result, objDetections);
		for (Rect rect : objDetections.toArray()) {
			Imgproc.rectangle(result, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 0, 255), 2);
		}
		return result;
	}
 
	public static Mat getLefteye(Mat src) {
		Mat result = src.clone();
		if (src.cols() > 1000 || src.rows() > 1000) {
			Imgproc.resize(src, result, new Size(src.cols() / 3, src.rows() / 3));
		}
 
		CascadeClassifier faceDetector = new CascadeClassifier("./resource/haarcascade_mcs_lefteye.xml");
		MatOfRect objDetections = new MatOfRect();
		faceDetector.detectMultiScale(result, objDetections);
		for (Rect rect : objDetections.toArray()) {
			Imgproc.rectangle(result, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 0, 255), 2);
		}
		return result;
	}
 
	public static Mat getRighteye(Mat src) {
		Mat result = src.clone();
		if (src.cols() > 1000 || src.rows() > 1000) {
			Imgproc.resize(src, result, new Size(src.cols() / 3, src.rows() / 3));
		}
 
		CascadeClassifier faceDetector = new CascadeClassifier("./resource/haarcascade_mcs_righteye.xml");
		MatOfRect objDetections = new MatOfRect();
		faceDetector.detectMultiScale(result, objDetections);
		for (Rect rect : objDetections.toArray()) {
			Imgproc.rectangle(result, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 0, 255), 2);
		}
		return result;
	}
 
	public static Mat getLeftear(Mat src) {
		Mat result = src.clone();
		if (src.cols() > 1000 || src.rows() > 1000) {
			Imgproc.resize(src, result, new Size(src.cols() / 3, src.rows() / 3));
		}
 
		CascadeClassifier faceDetector = new CascadeClassifier("./resource/haarcascade_mcs_leftear.xml");
		MatOfRect objDetections = new MatOfRect();
		faceDetector.detectMultiScale(result, objDetections);
		for (Rect rect : objDetections.toArray()) {
			Imgproc.rectangle(result, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 0, 255), 2);
		}
		return result;
	}
 
	public static Mat getRightear(Mat src) {
		Mat result = src.clone();
		if (src.cols() > 1000 || src.rows() > 1000) {
			Imgproc.resize(src, result, new Size(src.cols() / 3, src.rows() / 3));
		}
 
		CascadeClassifier faceDetector = new CascadeClassifier("./resource/haarcascade_mcs_rightear.xml");
		MatOfRect objDetections = new MatOfRect();
		faceDetector.detectMultiScale(result, objDetections);
		for (Rect rect : objDetections.toArray()) {
			Imgproc.rectangle(result, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 0, 255), 2);
		}
		return result;
	}
 
	public static Mat getMouth(Mat src) {
		Mat result = src.clone();
		if (src.cols() > 1000 || src.rows() > 1000) {
			Imgproc.resize(src, result, new Size(src.cols() / 3, src.rows() / 3));
		}
 
		CascadeClassifier faceDetector = new CascadeClassifier("./resource/haarcascade_mcs_mouth.xml");
		MatOfRect objDetections = new MatOfRect();
		faceDetector.detectMultiScale(result, objDetections);
		for (Rect rect : objDetections.toArray()) {
			Imgproc.rectangle(result, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 0, 255), 2);
		}
		return result;
	}
 
	public static Mat getNose(Mat src) {
		Mat result = src.clone();
		if (src.cols() > 1000 || src.rows() > 1000) {
			Imgproc.resize(src, result, new Size(src.cols() / 3, src.rows() / 3));
		}
 
		CascadeClassifier faceDetector = new CascadeClassifier("./resource/haarcascade_mcs_nose.xml");
		MatOfRect objDetections = new MatOfRect();
		faceDetector.detectMultiScale(result, objDetections);
		for (Rect rect : objDetections.toArray()) {
			Imgproc.rectangle(result, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 0, 255), 2);
		}
		return result;
	}
 
	public static Mat getSmile(Mat src) {
		Mat result = src.clone();
		if (src.cols() > 1000 || src.rows() > 1000) {
			Imgproc.resize(src, result, new Size(src.cols() / 3, src.rows() / 3));
		}
 
		CascadeClassifier faceDetector = new CascadeClassifier("./resource/haarcascade_smile.xml");
		MatOfRect objDetections = new MatOfRect();
		faceDetector.detectMultiScale(result, objDetections);
		for (Rect rect : objDetections.toArray()) {
			Imgproc.rectangle(result, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 0, 255), 2);
		}
		return result;
	}
 
	public static Mat getLowerBody(Mat src) {
		Mat result = src.clone();
		if (src.cols() > 1000 || src.rows() > 1000) {
			Imgproc.resize(src, result, new Size(src.cols() / 3, src.rows() / 3));
		}
 
		CascadeClassifier faceDetector = new CascadeClassifier("./resource/haarcascade_lowerbody.xml");
		MatOfRect objDetections = new MatOfRect();
		faceDetector.detectMultiScale(result, objDetections);
		for (Rect rect : objDetections.toArray()) {
			Imgproc.rectangle(result, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 0, 255), 2);
		}
		return result;
	}
 
	public static Mat getFullBody(Mat src) {
		Mat result = src.clone();
		if (src.cols() > 1000 || src.rows() > 1000) {
			Imgproc.resize(src, result, new Size(src.cols() / 3, src.rows() / 3));
		}
 
		CascadeClassifier faceDetector = new CascadeClassifier("./resource/haarcascade_fullbody.xml");
		MatOfRect objDetections = new MatOfRect();
		faceDetector.detectMultiScale(result, objDetections);
		for (Rect rect : objDetections.toArray()) {
			Imgproc.rectangle(result, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 0, 255), 2);
		}
		return result;
	}
 
	public static Mat getFace(Mat src) {
		Mat result = src.clone();
		if (src.cols() > 1000 || src.rows() > 1000) {
			Imgproc.resize(src, result, new Size(src.cols() / 3, src.rows() / 3));
		}
 
		CascadeClassifier faceDetector = new CascadeClassifier("./resource/haarcascade_frontalface_alt2.xml");
		MatOfRect objDetections = new MatOfRect();
		faceDetector.detectMultiScale(result, objDetections);
		for (Rect rect : objDetections.toArray()) {
			Imgproc.rectangle(result, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 0, 255), 2);
		}
		return result;
	}
 
	public static Mat getProfileFace(Mat src) {
		Mat result = src.clone();
		if (src.cols() > 1000 || src.rows() > 1000) {
			Imgproc.resize(src, result, new Size(src.cols() / 3, src.rows() / 3));
		}
 
		CascadeClassifier faceDetector = new CascadeClassifier("./resource/haarcascade_profileface.xml");
		MatOfRect objDetections = new MatOfRect();
		faceDetector.detectMultiScale(result, objDetections);
		for (Rect rect : objDetections.toArray()) {
			Imgproc.rectangle(result, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 0, 255), 2);
		}
		return result;
	}
}
 