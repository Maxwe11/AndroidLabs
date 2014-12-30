package com.example.test_project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.widget.Toast;

public class JsAndroid {
	Context context;
	SharedPreferences sPref;

	final String FILENAME = "file";
	final String DIR_SD = "MyFiles";
	final String FILENAME_SD = "fileSD";

	public JsAndroid(Context context) {
		this.context = context;
	}

	public String getString(String text) {
		Toast.makeText(context, "hi", Toast.LENGTH_SHORT).show();
		return "new " + text;
	}

	public void saveGP(String text) {
		sPref = ((Activity) context).getPreferences(Context.MODE_PRIVATE);
		Editor ed = sPref.edit();
		ed.putString("gpText", text);
		ed.commit();
		Toast.makeText(context, "Text saved", Toast.LENGTH_SHORT).show();
	}

	public String loadGP() {
		sPref = ((Activity) context).getPreferences(Context.MODE_PRIVATE);
		String savedText = sPref.getString("gpText", "");
		Toast.makeText(context, "Text loaded", Toast.LENGTH_SHORT).show();
		return savedText;
	}

	public void saveGSP(String text) {
		sPref = ((Activity) context).getSharedPreferences("MyPref",
				Context.MODE_PRIVATE);
		Editor ed = sPref.edit();
		ed.putString("gpText", text);
		ed.commit();
		Toast.makeText(context, "Text saved", Toast.LENGTH_SHORT).show();
	}

	public String loadGSP() {
		sPref = ((Activity) context).getSharedPreferences("MyPref",
				Context.MODE_PRIVATE);
		String savedText = sPref.getString("gpText", "");
		Toast.makeText(context, "Text loaded", Toast.LENGTH_SHORT).show();
		return savedText;
	}

	public void loadActivity() {
		Intent intent = new Intent(context, SecondActivity.class);
		context.startActivity(intent);
	}

	public void saveFile(String text) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					context.openFileOutput(FILENAME, Context.MODE_PRIVATE)));
			bw.write(text);
			bw.close();
			Toast.makeText(context, "File saved!", Toast.LENGTH_SHORT).show();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String loadFile() {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					context.openFileInput(FILENAME)));
			String str = "";
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Toast.makeText(context, "File loaded!", Toast.LENGTH_SHORT).show();
		return sb.toString();
	}

	public void saveFileSD(String text) {
		if (!Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			Toast.makeText(context, "Card error!", Toast.LENGTH_SHORT).show();
			return;
		}
		File sdPath = Environment.getExternalStorageDirectory();
		sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
		sdPath.mkdirs();
		File sdFile = new File(sdPath, FILENAME_SD);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile));
			bw.write(text);
			bw.close();
			Toast.makeText(context, "FileSD saved!", Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String loadFileSD() {
		StringBuilder sb = new StringBuilder();
		if (!Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			Toast.makeText(context, "Card error!", Toast.LENGTH_SHORT).show();
			return "";
		}
		File sdPath = Environment.getExternalStorageDirectory();
		sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
		File sdFile = new File(sdPath, FILENAME_SD);
		try {
			BufferedReader br = new BufferedReader(new FileReader(sdFile));
			String str = "";
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Toast.makeText(context, "FileSD loaded!", Toast.LENGTH_SHORT).show();
		return sb.toString();
	}
}
